package biz.picosoft.demo.controller;

import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.intercomm.KernelService;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.client.kernel.model.global.CurrentUser;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.repository.OffreRepository;
import biz.picosoft.demo.service.OffreQueryService;
import biz.picosoft.demo.service.OffreService;
import biz.picosoft.demo.service.criteria.OffreCriteria;
import biz.picosoft.demo.service.dto.*;

import biz.picosoft.demo.service.impl.OffreServiceImpl;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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

/**
 * REST controller for managing {@link biz.picosoft.demo.domain.Offre}.
 */
@RestController
@RequestMapping("/api")
public class OffreResource {

    private final Logger log = LoggerFactory.getLogger(OffreResource.class);

    private static final String ENTITY_NAME = "offre";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OffreService offreService;

    private final OffreRepository offreRepository;

    private final OffreQueryService offreQueryService;
    private final CurrentUser currentUser;

    private final KernelService kernelService;
    private final KernelInterface kernelInterface;
    private final OffreServiceImpl offreServiceImp;
    public OffreResource(OffreService offreService, OffreRepository offreRepository, OffreQueryService offreQueryService, CurrentUser currentUser,
                         KernelService kernelService, KernelInterface kernelInterface, OffreServiceImpl offreServiceImp) {
        this.offreService = offreService;
        this.offreRepository = offreRepository;
        this.offreQueryService = offreQueryService;
        this.currentUser = currentUser;
        this.kernelService = kernelService;
        this.kernelInterface = kernelInterface;
        this.offreServiceImp = offreServiceImp;
    }

    /**
     * {@code POST  /offres} : Create a new offre.
     *
     * @param offreDTO the offreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new offreDTO, or with status {@code 400 (Bad Request)} if the offre has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/offres")
    public ResponseEntity<OffreDTO> createOffre(@RequestBody OffreDTO offreDTO) throws URISyntaxException {
        log.debug("REST request to save Offre : {}", offreDTO);
        if (offreDTO.getId() != null) {
            throw new BadRequestAlertException("A new offre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OffreDTO result = offreService.save(offreDTO);
        return ResponseEntity
            .created(new URI("/api/offres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /offres/:id} : Updates an existing offre.
     *
     * @param id the id of the offreDTO to save.
     * @param offreDTO the offreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated offreDTO,
     * or with status {@code 400 (Bad Request)} if the offreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the offreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/offres/{id}")
    public ResponseEntity<OffreDTO> updateOffre(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody OffreDTO offreDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Offre : {}, {}", id, offreDTO);
        if (offreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, offreDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!offreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        OffreDTO result = offreService.update(offreDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, offreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /offres/:id} : Partial updates given fields of an existing offre, field will ignore if it is null
     *
     * @param id the id of the offreDTO to save.
     * @param offreDTO the offreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated offreDTO,
     * or with status {@code 400 (Bad Request)} if the offreDTO is not valid,
     * or with status {@code 404 (Not Found)} if the offreDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the offreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/offres/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<OffreDTO> partialUpdateOffre(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody OffreDTO offreDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Offre partially : {}, {}", id, offreDTO);
        if (offreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, offreDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!offreRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<OffreDTO> result = offreService.partialUpdate(offreDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, offreDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /offres} : get all the offres.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of offres in body.
     */
    @GetMapping("/offres")
    public ResponseEntity<Page<OffreDTO>> getAllOffres(
        OffreCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Offres by criteria: {}", criteria);
        Page<OffreDTO> page = offreQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }
    @GetMapping("/offresList")
    public ResponseEntity<List<OffreDTO>> getAllOffreslist(
            OffreCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Offres by criteria: {}", criteria);
        Page<OffreDTO> page = offreQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    /**
     * {@code GET  /offres/count} : count all the offres.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/offres/count")
    public ResponseEntity<Long> countOffres(OffreCriteria criteria) {
        log.debug("REST request to count Offres by criteria: {}", criteria);
        return ResponseEntity.ok().body(offreQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /offres/:id} : get the "id" offre.
     *
     * @param id the id of the offreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the offreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/offres/{id}")
    public ResponseEntity<OffreDTO> getOffre(@PathVariable Long id) {
        log.debug("REST request to get Offre : {}", id);
        Optional<OffreDTO> offreDTO = offreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(offreDTO);
    }

    /**
     * {@code DELETE  /offres/:id} : delete the "id" offre.
     *
     * @param id the id of the offreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/offres/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        log.debug("REST request to delete Offre : {}", id);
        offreService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    // process
    @PatchMapping("/initOffre")
    public OffreOutputDTO initOffre() throws Exception {

        // check if the conneceted person have role can create inbound
        offreService.checkRole(currentUser.getProfileName(), kernelService.anf_invoice_role_canCreatedemande);

        // extract acl class
        AclClass aclClass = kernelInterface.getaclClassByClassName(Offre.class.getName());

        return offreServiceImp.initProcessOffre(aclClass);

    }

    @GetMapping("/offreById/{id}")
    OffreOutputDTO getOffreDTO(@PathVariable Long id) throws IOException, TemplateException {

        return offreServiceImp.getbyideDTO(id);
    }
    @GetMapping("/offre/byid/{id}")
    public ResponseEntity<Offre> getoffrebyid(@PathVariable Long id) {
        log.debug("REST request to get Demande : {}", id);
        Offre offre = offreServiceImp.getById(id);
        return ResponseEntity.ok().body(offre);
    }

    @PatchMapping(value = {"/submitOffre"})
    public OffreOutputDTO submitRequestCase(@RequestBody OffreInputDTO requestCaseInputDTO) throws Exception {

        // check if the conneceted person have role can create inbound
        offreService.checkRole(currentUser.getProfileName(), kernelService.anf_invoice_role_canCreatedemande);

        // extract acl class
        AclClass aclClass = kernelInterface.getaclClassByClassName(Offre.class.getName());

        OffreOutputDTO result = offreServiceImp.submitProcessOffre(requestCaseInputDTO, aclClass);

        return result;
    }
    @PutMapping("/offreupdate/{id}/{idOpp}")
    public OffreOutputDTO updateRequestCase(
            @PathVariable(value = "id", required = false) final Long id,
            @PathVariable(value = "idOpp", required = false) final Long idOpp,
            @RequestBody OffreInputDTO requestCaseInputDTO) throws URISyntaxException {
        log.debug("REST request to update RequestCase : {}, {}", id, requestCaseInputDTO);
        if (requestCaseInputDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }


        OffreOutputDTO result = offreServiceImp.update(requestCaseInputDTO);
        return result;
    }
    @PutMapping("/{demandeId}/setCreateBCTrue")
    public ResponseEntity<String> setCreateOppTrue(@PathVariable Long demandeId) {
        offreService.setCreateBCTrue(demandeId);
        return ResponseEntity.ok("createOpp set to true for demandeId: " + demandeId);
    }
}
