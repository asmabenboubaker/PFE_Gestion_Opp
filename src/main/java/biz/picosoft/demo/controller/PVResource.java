package biz.picosoft.demo.controller;


import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.repository.PVRepository;
import biz.picosoft.demo.service.PVQueryService;
import biz.picosoft.demo.service.PVService;
import biz.picosoft.demo.service.criteria.PVCriteria;
import biz.picosoft.demo.service.dto.PVDTO;
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
 * REST controller for managing {@link biz.picosoft.demo.domain.PV}.
 */
@RestController
@RequestMapping("/api")
public class PVResource {

    private final Logger log = LoggerFactory.getLogger(PVResource.class);

    private static final String ENTITY_NAME = "pV";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PVService pVService;

    private final PVRepository pVRepository;

    private final PVQueryService pVQueryService;

    public PVResource(PVService pVService, PVRepository pVRepository, PVQueryService pVQueryService) {
        this.pVService = pVService;
        this.pVRepository = pVRepository;
        this.pVQueryService = pVQueryService;
    }

    /**
     * {@code POST  /pvs} : Create a new pV.
     *
     * @param pVDTO the pVDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pVDTO, or with status {@code 400 (Bad Request)} if the pV has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pvs")
    public ResponseEntity<PVDTO> createPV(@RequestBody PVDTO pVDTO) throws URISyntaxException {
        log.debug("REST request to save PV : {}", pVDTO);
        if (pVDTO.getId() != null) {
            throw new BadRequestAlertException("A new pV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PVDTO result = pVService.save(pVDTO);
        return ResponseEntity
            .created(new URI("/api/pvs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pvs/:id} : Updates an existing pV.
     *
     * @param id the id of the pVDTO to save.
     * @param pVDTO the pVDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pVDTO,
     * or with status {@code 400 (Bad Request)} if the pVDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pVDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pvs/{id}")
    public ResponseEntity<PVDTO> updatePV(@PathVariable(value = "id", required = false) final Long id, @RequestBody PVDTO pVDTO)
        throws URISyntaxException {
        log.debug("REST request to update PV : {}, {}", id, pVDTO);
        if (pVDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pVDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pVRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        PVDTO result = pVService.update(pVDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pVDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /pvs/:id} : Partial updates given fields of an existing pV, field will ignore if it is null
     *
     * @param id the id of the pVDTO to save.
     * @param pVDTO the pVDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pVDTO,
     * or with status {@code 400 (Bad Request)} if the pVDTO is not valid,
     * or with status {@code 404 (Not Found)} if the pVDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the pVDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/pvs/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<PVDTO> partialUpdatePV(@PathVariable(value = "id", required = false) final Long id, @RequestBody PVDTO pVDTO)
        throws URISyntaxException {
        log.debug("REST request to partial update PV partially : {}, {}", id, pVDTO);
        if (pVDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pVDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!pVRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<PVDTO> result = pVService.partialUpdate(pVDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pVDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /pvs} : get all the pVS.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pVS in body.
     */
    @GetMapping("/pvs")
    public ResponseEntity<List<PVDTO>> getAllPVS(PVCriteria criteria, @org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get PVS by criteria: {}", criteria);
        Page<PVDTO> page = pVQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pvs/count} : count all the pVS.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/pvs/count")
    public ResponseEntity<Long> countPVS(PVCriteria criteria) {
        log.debug("REST request to count PVS by criteria: {}", criteria);
        return ResponseEntity.ok().body(pVQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /pvs/:id} : get the "id" pV.
     *
     * @param id the id of the pVDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pVDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pvs/{id}")
    public ResponseEntity<PVDTO> getPV(@PathVariable Long id) {
        log.debug("REST request to get PV : {}", id);
        Optional<PVDTO> pVDTO = pVService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pVDTO);
    }

    /**
     * {@code DELETE  /pvs/:id} : delete the "id" pV.
     *
     * @param id the id of the pVDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pvs/{id}")
    public ResponseEntity<Void> deletePV(@PathVariable Long id) {
        log.debug("REST request to delete PV : {}", id);
        pVService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
