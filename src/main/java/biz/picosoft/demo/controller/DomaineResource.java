package biz.picosoft.demo.controller;

 import biz.picosoft.demo.controller.errors.BadRequestAlertException;
 import biz.picosoft.demo.repository.DomaineRepository;
 import biz.picosoft.demo.service.DomaineQueryService;
 import biz.picosoft.demo.service.DomaineService;
 import biz.picosoft.demo.service.criteria.DomaineCriteria;
 import biz.picosoft.demo.service.dto.DomaineDTO;
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
 * REST controller for managing {@link biz.picosoft.demo.domain.Domaine}.
 */
@RestController
@RequestMapping("/api")
public class DomaineResource {

    private final Logger log = LoggerFactory.getLogger(DomaineResource.class);

    private static final String ENTITY_NAME = "domaine";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;


    private final DomaineService domaineService;

    private final DomaineRepository domaineRepository;

    private final DomaineQueryService domaineQueryService;

    public DomaineResource(DomaineService domaineService, DomaineRepository domaineRepository, DomaineQueryService domaineQueryService) {
        this.domaineService = domaineService;
        this.domaineRepository = domaineRepository;
        this.domaineQueryService = domaineQueryService;
    }

    /**
     * {@code POST  /domaines} : Create a new domaine.
     *
     * @param domaineDTO the domaineDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new domaineDTO, or with status {@code 400 (Bad Request)} if the domaine has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/domaines")
    public ResponseEntity<DomaineDTO> createDomaine(@RequestBody DomaineDTO domaineDTO) throws URISyntaxException {
        log.debug("REST request to save Domaine : {}", domaineDTO);
        if (domaineDTO.getId() != null) {
            throw new BadRequestAlertException("A new domaine cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DomaineDTO result = domaineService.save(domaineDTO);
        return ResponseEntity
            .created(new URI("/api/domaines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /domaines/:id} : Updates an existing domaine.
     *
     * @param id the id of the domaineDTO to save.
     * @param domaineDTO the domaineDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated domaineDTO,
     * or with status {@code 400 (Bad Request)} if the domaineDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the domaineDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/domaines/{id}")
    public ResponseEntity<DomaineDTO> updateDomaine(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DomaineDTO domaineDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Domaine : {}, {}", id, domaineDTO);
        if (domaineDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, domaineDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!domaineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DomaineDTO result = domaineService.update(domaineDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, domaineDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /domaines/:id} : Partial updates given fields of an existing domaine, field will ignore if it is null
     *
     * @param id the id of the domaineDTO to save.
     * @param domaineDTO the domaineDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated domaineDTO,
     * or with status {@code 400 (Bad Request)} if the domaineDTO is not valid,
     * or with status {@code 404 (Not Found)} if the domaineDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the domaineDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/domaines/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DomaineDTO> partialUpdateDomaine(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DomaineDTO domaineDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Domaine partially : {}, {}", id, domaineDTO);
        if (domaineDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, domaineDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!domaineRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DomaineDTO> result = domaineService.partialUpdate(domaineDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, domaineDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /domaines} : get all the domaines.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of domaines in body.
     */
    @GetMapping("/domaines")
    public ResponseEntity<Page<DomaineDTO>> getAllDomaines(
        DomaineCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Domaines by criteria: {}", criteria);
        Page<DomaineDTO> page = domaineQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }

    /**
     * {@code GET  /domaines/count} : count all the domaines.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/domaines/count")
    public ResponseEntity<Long> countDomaines(DomaineCriteria criteria) {
        log.debug("REST request to count Domaines by criteria: {}", criteria);
        return ResponseEntity.ok().body(domaineQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /domaines/:id} : get the "id" domaine.
     *
     * @param id the id of the domaineDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the domaineDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/domaines/{id}")
    public ResponseEntity<DomaineDTO> getDomaine(@PathVariable Long id) {
        log.debug("REST request to get Domaine : {}", id);
        Optional<DomaineDTO> domaineDTO = domaineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(domaineDTO);
    }

    /**
     * {@code DELETE  /domaines/:id} : delete the "id" domaine.
     *
     * @param id the id of the domaineDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/domaines/{id}")
    public ResponseEntity<Void> deleteDomaine(@PathVariable Long id) {
        log.debug("REST request to delete Domaine : {}", id);
        domaineService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
