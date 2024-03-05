package biz.picosoft.demo.controller;


import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.OpportuniteQueryService;
import biz.picosoft.demo.service.OpportuniteService;
import biz.picosoft.demo.service.criteria.OpportuniteCriteria;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
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

    public OpportuniteResource(
        OpportuniteService opportuniteService,
        OpportuniteRepository opportuniteRepository,
        OpportuniteQueryService opportuniteQueryService
    ) {
        this.opportuniteService = opportuniteService;
        this.opportuniteRepository = opportuniteRepository;
        this.opportuniteQueryService = opportuniteQueryService;
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
}
