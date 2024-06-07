package biz.picosoft.demo.controller;

import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.TacheOpp;
import biz.picosoft.demo.repository.EtudeOppRepository;
import biz.picosoft.demo.service.EtudeOppQueryService;
import biz.picosoft.demo.service.EtudeOppService;
import biz.picosoft.demo.service.criteria.EtudeOppCriteria;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import biz.picosoft.demo.service.impl.TacheServiceImp;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * REST controller for managing {@link biz.picosoft.demo.domain.EtudeOpp}.
 */
@RestController
@RequestMapping("/api")
public class EtudeOppResource {

    private final Logger log = LoggerFactory.getLogger(EtudeOppResource.class);

    private static final String ENTITY_NAME = "etudeOpp";

    // @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EtudeOppService etudeOppService;
private final TacheServiceImp tacheServiceImp;
    private final EtudeOppRepository etudeOppRepository;

    private final EtudeOppQueryService etudeOppQueryService;

    public EtudeOppResource(
            EtudeOppService etudeOppService,
            EtudeOppRepository etudeOppRepository,
            EtudeOppQueryService etudeOppQueryService,
            TacheServiceImp tacheServiceImp
    ) {
        this.etudeOppService = etudeOppService;
        this.etudeOppRepository = etudeOppRepository;
        this.etudeOppQueryService = etudeOppQueryService;
        this.tacheServiceImp = tacheServiceImp;
    }

    /**
     * {@code POST  /etude-opps} : Create a new etudeOpp.
     *
     * @param etudeOppDTO the etudeOppDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new etudeOppDTO, or with status {@code 400 (Bad Request)} if the etudeOpp has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/etude-opps")
    public ResponseEntity<EtudeOppDTO> createEtudeOpp(@RequestBody EtudeOppDTO etudeOppDTO) throws URISyntaxException {
        log.debug("REST request to save EtudeOpp : {}", etudeOppDTO);
        if (etudeOppDTO.getId() != null) {
            throw new BadRequestAlertException("A new etudeOpp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EtudeOppDTO result = etudeOppService.save(etudeOppDTO);
        return ResponseEntity
                .created(new URI("/api/etude-opps/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * {@code PUT  /etude-opps/:id} : Updates an existing etudeOpp.
     *
     * @param id          the id of the etudeOppDTO to save.
     * @param etudeOppDTO the etudeOppDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated etudeOppDTO,
     * or with status {@code 400 (Bad Request)} if the etudeOppDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the etudeOppDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/etude-opps/{id}")
    public ResponseEntity<EtudeOppDTO> updateEtudeOpp(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody EtudeOppDTO etudeOppDTO
    ) throws URISyntaxException {
        log.debug("REST request to update EtudeOpp : {}, {}", id, etudeOppDTO);
        if (etudeOppDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, etudeOppDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!etudeOppRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        EtudeOppDTO result = etudeOppService.update(etudeOppDTO);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, etudeOppDTO.getId().toString()))
                .body(result);
    }

    /**
     * {@code PATCH  /etude-opps/:id} : Partial updates given fields of an existing etudeOpp, field will ignore if it is null
     *
     * @param id          the id of the etudeOppDTO to save.
     * @param etudeOppDTO the etudeOppDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated etudeOppDTO,
     * or with status {@code 400 (Bad Request)} if the etudeOppDTO is not valid,
     * or with status {@code 404 (Not Found)} if the etudeOppDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the etudeOppDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/etude-opps/{id}", consumes = {"application/json", "application/merge-patch+json"})
    public ResponseEntity<EtudeOppDTO> partialUpdateEtudeOpp(
            @PathVariable(value = "id", required = false) final Long id,
            @RequestBody EtudeOppDTO etudeOppDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update EtudeOpp partially : {}, {}", id, etudeOppDTO);
        if (etudeOppDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, etudeOppDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!etudeOppRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EtudeOppDTO> result = etudeOppService.partialUpdate(etudeOppDTO);

        return ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, etudeOppDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /etude-opps} : get all the etudeOpps.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of etudeOpps in body.
     */
    @GetMapping("/etude-opps")
    public ResponseEntity<Page<EtudeOppDTO>> getAllEtudeOpps(
            EtudeOppCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get EtudeOpps by criteria: {}", criteria);
        Page<EtudeOppDTO> page = etudeOppQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }

    /**
     * {@code GET  /etude-opps/count} : count all the etudeOpps.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/etude-opps/count")
    public ResponseEntity<Long> countEtudeOpps(EtudeOppCriteria criteria) {
        log.debug("REST request to count EtudeOpps by criteria: {}", criteria);
        return ResponseEntity.ok().body(etudeOppQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /etude-opps/:id} : get the "id" etudeOpp.
     *
     * @param id the id of the etudeOppDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the etudeOppDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/etude-opps/{id}")
    public ResponseEntity<EtudeOppDTO> getEtudeOpp(@PathVariable Long id) {
        log.debug("REST request to get EtudeOpp : {}", id);
        Optional<EtudeOppDTO> etudeOppDTO = etudeOppService.findOne(id);
        return ResponseUtil.wrapOrNotFound(etudeOppDTO);
    }

    /**
     * {@code DELETE  /etude-opps/:id} : delete the "id" etudeOpp.
     *
     * @param id the id of the etudeOppDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/etude-opps/{id}")
    public ResponseEntity<Void> deleteEtudeOpp(@PathVariable Long id) {
        log.debug("REST request to delete EtudeOpp : {}", id);
        etudeOppService.delete(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }

    // // ajouter EtudeOpp acec affectation opportunité
    @PostMapping("/createEtudeOppWithAffectation/{idOpportunite}")
    public ResponseEntity<EtudeOppDTO> createEtudeOppWithAffectation(
            @PathVariable(value = "idOpportunite", required = false) final Long idOpportunite,
            @RequestBody EtudeOppDTO etudeOppDTO
    ) throws URISyntaxException {
        log.debug("REST request to save EtudeOpp : {}, {}", idOpportunite, etudeOppDTO);

        EtudeOppDTO result = etudeOppService.saveEtudeOppWithAffectation(etudeOppDTO, idOpportunite);
        return ResponseEntity
                .created(new URI("/api/etude-opps/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }


    @GetMapping("/opportunite/{opportuniteId}/etudes")
    public List<EtudeOpp> getAllEtudesByOpportuniteId(@PathVariable Long opportuniteId) {
        return etudeOppService.findAllByOpportuniteId(opportuniteId);
    }
    @PostMapping("/etudes/{etudeId}/taches")
    public ResponseEntity<Void> addTacheToEtude(@PathVariable Long etudeId, @RequestBody TacheOpp tacheOpp) {
        log.debug("REST request to add TacheOpp : {} to EtudeOpp : {}", tacheOpp, etudeId);
        tacheServiceImp.addTacheToEtude(etudeId, tacheOpp);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/etudes/{etudeId}/taches")
    public ResponseEntity<List<TacheOpp>> getTachesByEtudeId(@PathVariable Long etudeId) {
        List<TacheOpp> taches = tacheServiceImp.findTachesByEtudeId(etudeId);
        return ResponseEntity.ok(taches);
    }
    // add tache
    @PostMapping("/etudes/taches")
    public ResponseEntity<TacheOpp> createTache(@RequestBody TacheOpp tacheOpp) throws URISyntaxException {
        log.debug("REST request to save TacheOpp : {}", tacheOpp);

        TacheOpp result = tacheServiceImp.save(tacheOpp);
        return ResponseEntity
                .created(new URI("/api/etudes/taches/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
}