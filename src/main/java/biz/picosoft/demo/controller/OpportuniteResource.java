package biz.picosoft.demo.controller;


import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.OpportuniteQueryService;
import biz.picosoft.demo.service.OpportuniteService;
import biz.picosoft.demo.service.criteria.OpportuniteCriteria;
import biz.picosoft.demo.service.dto.*;
import biz.picosoft.demo.service.impl.DemandeServiceImpl;
import biz.picosoft.demo.service.impl.OpportuniteServiceImpl;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * REST controller for managing {@link biz.picosoft.demo.domain.Opportunite}.
 */
@RestController
@RequestMapping("/api")
public class OpportuniteResource {

    private final Logger log = LoggerFactory.getLogger(OpportuniteResource.class);

    private static final String ENTITY_NAME = "opportunite";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OpportuniteService opportuniteService;

    private final OpportuniteRepository opportuniteRepository;

    private final OpportuniteQueryService opportuniteQueryService;

    private final CurrentUser currentUser;

    private final KernelService kernelService;
    private final OpportuniteServiceImpl oppServiceImp;
    private final KernelInterface kernelInterface;
    private final OpportuniteServiceImpl opportuniteServiceImpl;
    public OpportuniteResource(
        OpportuniteService opportuniteService,
        OpportuniteRepository opportuniteRepository,
        OpportuniteQueryService opportuniteQueryService,
        CurrentUser currentUser,
        KernelService kernelService,
        OpportuniteServiceImpl oppServiceImp,
        KernelInterface kernelInterface,
        OpportuniteServiceImpl opportuniteServiceImpl
    ) {
        this.opportuniteService = opportuniteService;
        this.opportuniteRepository = opportuniteRepository;
        this.opportuniteQueryService = opportuniteQueryService;
        this.currentUser = currentUser;
        this.kernelService = kernelService;
        this.oppServiceImp = oppServiceImp;
        this.kernelInterface = kernelInterface;
        this.opportuniteServiceImpl = opportuniteServiceImpl;
    }

    /**
     * {@code POST  /opportunites} : Create a new opportunite.
     *
     * @param opportuniteDTO the opportuniteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new opportuniteDTO, or with status {@code 400 (Bad Request)} if the opportunite has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/opportunites")
    public ResponseEntity<OpportuniteDTO> createOpportunite(@RequestBody OpportuniteDTO opportuniteDTO) throws URISyntaxException {
        log.debug("REST request to save Opportunite : {}", opportuniteDTO);
        if (opportuniteDTO.getId() != null) {
            throw new BadRequestAlertException("A new opportunite cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpportuniteDTO result = opportuniteService.save(opportuniteDTO);
        return ResponseEntity
            .created(new URI("/api/opportunites/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /opportunites/:id} : Updates an existing opportunite.
     *
     * @param id the id of the opportuniteDTO to save.
     * @param opportuniteDTO the opportuniteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated opportuniteDTO,
     * or with status {@code 400 (Bad Request)} if the opportuniteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the opportuniteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/opportunites/{id}")
    public ResponseEntity<OpportuniteDTO> updateOpportunite(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody OpportuniteDTO opportuniteDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Opportunite : {}, {}", id, opportuniteDTO);
        if (opportuniteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, opportuniteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!opportuniteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        OpportuniteDTO result = opportuniteService.update(opportuniteDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, opportuniteDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /opportunites/:id} : Partial updates given fields of an existing opportunite, field will ignore if it is null
     *
     * @param id the id of the opportuniteDTO to save.
     * @param opportuniteDTO the opportuniteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated opportuniteDTO,
     * or with status {@code 400 (Bad Request)} if the opportuniteDTO is not valid,
     * or with status {@code 404 (Not Found)} if the opportuniteDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the opportuniteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/opportunites/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<OpportuniteDTO> partialUpdateOpportunite(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody OpportuniteDTO opportuniteDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Opportunite partially : {}, {}", id, opportuniteDTO);
        if (opportuniteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, opportuniteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!opportuniteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<OpportuniteDTO> result = opportuniteService.partialUpdate(opportuniteDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, opportuniteDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /opportunites} : get all the opportunites.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of opportunites in body.
     */
    @GetMapping("/opportunites")
    public ResponseEntity<Page<OpportuniteDTO>> getAllOpportunites(
        OpportuniteCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Opportunites by criteria: {}", criteria);
        Page<OpportuniteDTO> page = opportuniteQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }
    @GetMapping("/opportunites/withoutpage")
    public ResponseEntity<List<OpportuniteDTO>> getAllOpportunite(
            OpportuniteCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Opportunites by criteria: {}", criteria);
        Page<OpportuniteDTO> page = opportuniteQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    /**
     * {@code GET  /opportunites/count} : count all the opportunites.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/opportunites/count")
    public ResponseEntity<Long> countOpportunites(OpportuniteCriteria criteria) {
        log.debug("REST request to count Opportunites by criteria: {}", criteria);
        return ResponseEntity.ok().body(opportuniteQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /opportunites/:id} : get the "id" opportunite.
     *
     * @param id the id of the opportuniteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the opportuniteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/opportunites/{id}")
    public ResponseEntity<OpportuniteDTO> getOpportunite(@PathVariable Long id) {
        log.debug("REST request to get Opportunite : {}", id);
        Optional<OpportuniteDTO> opportuniteDTO = opportuniteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(opportuniteDTO);
    }
    @GetMapping("/opportunitesid/{id}")
    public ResponseEntity<Opportunite> getOpportuniteid(@PathVariable Long id) {
        log.debug("REST request to get Opportunite : {}", id);
        Optional<Opportunite> opportuniteDTO = opportuniteRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(opportuniteDTO);
    }
    /**
     * {@code DELETE  /opportunites/:id} : delete the "id" opportunite.
     *
     * @param id the id of the opportuniteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/opportunites/{id}")
    public ResponseEntity<Void> deleteOpportunite(@PathVariable Long id) {
        log.debug("REST request to delete Opportunite : {}", id);
        opportuniteService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    @PatchMapping("/initOpp")
    public OpportuniteOutputDTO initOpp() throws Exception {

        // check if the conneceted person have role can create inbound
        opportuniteService.checkRole(currentUser.getProfileName(), kernelService.anf_invoice_role_canCreateopp);

        // extract acl class
        AclClass aclClass = kernelInterface.getaclClassByClassName(Opportunite.class.getName());

        return oppServiceImp.initProcessOpp(aclClass);

    }
    @GetMapping("/OpportuniteDTO/{id}")
    OpportuniteOutputDTO getOppDTO(@PathVariable Long id) throws IOException, TemplateException {

        return opportuniteService.getbyideDTO(id);
    }
    @PatchMapping(value = {"/submitOpp"})
    public OpportuniteOutputDTO submitRequestCase(@RequestBody OpportuniteInputDTO requestCaseInputDTO) throws Exception {

        // check if the conneceted person have role can create inbound
        opportuniteService.checkRole(currentUser.getProfileName(), kernelService.anf_invoice_role_canCreateopp);

        // extract acl class
        AclClass aclClass = kernelInterface.getaclClassByClassName(Opportunite.class.getName());

        OpportuniteOutputDTO result = opportuniteServiceImpl.submitProcessOpp(requestCaseInputDTO, aclClass);

        return result;
    }
//    @PutMapping("/demandemm/{id}/{idclient}")
//    public DemandeOutputDTO updateRequestCase(
//            @PathVariable(value = "id", required = false) final Long id,
//            @PathVariable(value = "idclient", required = false) final Long idclient,
//            @RequestBody DemandeInputDTO requestCaseInputDTO) throws URISyntaxException {
//        log.debug("REST request to update RequestCase : {}, {}", id, requestCaseInputDTO);
//        if (requestCaseInputDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        if (!Objects.equals(id, requestCaseInputDTO.getId())) {
//            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
//        }
//
//        if (!demandeRepository.existsById(id)) {
//            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
//        }
////        System.out.println("updateeeeeeeeeeeee====getSource"+requestCaseInputDTO.getSource());
////        System.out.println("updateeeeeeeeeeeee====setCommentaires"+requestCaseInputDTO.getCommentaires());
//        DemandeOutputDTO result = demandeService.update(requestCaseInputDTO,idclient);
//        return result;
//    }
    @PutMapping("/updateOpp/{idOpp}")
    public OpportuniteOutputDTO updateOpp(

            @PathVariable(value = "idOpp", required = false) final Long idOpp,
            @RequestBody OpportuniteInputDTO requestCaseInputDTO) throws URISyntaxException {

        if (requestCaseInputDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        OpportuniteOutputDTO result = opportuniteService.update(requestCaseInputDTO,idOpp);
        return result;
    }
    @GetMapping("/{opportuniteId}/allequipes")
    public ResponseEntity<List<Equipe>> getEquipesAffectees(@PathVariable Long opportuniteId) {
        List<Equipe> equipes = opportuniteService.getEquipesAffectees(opportuniteId);
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }
    //get etude from opportunite
    @GetMapping("/etude/{id}")
    public Set<EtudeOpp> getEtude(@PathVariable Long id) {
        return (Set<EtudeOpp>) opportuniteService.getEtude(id);
    }


    @PostMapping("/opportunites/affectation/{opportuniteId}/{demandeId}")
    public ResponseEntity<OpportuniteDTO> affecterOpportuniteADemande(@PathVariable Long opportuniteId,
                                                                      @PathVariable Long demandeId) {
        Optional<OpportuniteDTO> result = opportuniteService.affecterOpportuniteADemande(opportuniteId, demandeId);
        return result.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{demandeId}/setCreateOffreTrue")
    public ResponseEntity<String> setCreateOppTrue(@PathVariable Long demandeId) {
        opportuniteService.setCreateOffreTrue(demandeId);
        return ResponseEntity.ok("createOpp set to true for opp: " + demandeId);
    }

    @PutMapping("/{opportuniteId}/affecter-offre/{offreId}")
    public ResponseEntity<Opportunite> affecterOffre(@PathVariable Long opportuniteId, @PathVariable Long offreId) {
        return opportuniteService.affecterOffre(opportuniteId, offreId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
