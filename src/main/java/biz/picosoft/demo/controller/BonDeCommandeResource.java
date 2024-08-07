package biz.picosoft.demo.controller;

import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.repository.BonDeCommandeRepository;
import biz.picosoft.demo.service.BonDeCommandeQueryService;
import biz.picosoft.demo.service.BonDeCommandeService;
import biz.picosoft.demo.service.criteria.BonDeCommandeCriteria;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * REST controller for managing {@link biz.picosoft.demo.domain.BonDeCommande}.
 */
@RestController
@RequestMapping("/api")
public class BonDeCommandeResource {

    private final Logger log = LoggerFactory.getLogger(BonDeCommandeResource.class);

    private static final String ENTITY_NAME = "bonDeCommande";

  //  @Value("${jhipster.clientApp.name}")

    private String applicationName;

    private final BonDeCommandeService bonDeCommandeService;

    private final BonDeCommandeRepository bonDeCommandeRepository;

    private final BonDeCommandeQueryService bonDeCommandeQueryService;

    public BonDeCommandeResource(
        BonDeCommandeService bonDeCommandeService,
        BonDeCommandeRepository bonDeCommandeRepository,
        BonDeCommandeQueryService bonDeCommandeQueryService
    ) {
        this.bonDeCommandeService = bonDeCommandeService;
        this.bonDeCommandeRepository = bonDeCommandeRepository;
        this.bonDeCommandeQueryService = bonDeCommandeQueryService;
    }

    /**
     * {@code POST  /bon-de-commandes} : Create a new bonDeCommande.
     *
     * @param bonDeCommandeDTO the bonDeCommandeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bonDeCommandeDTO, or with status {@code 400 (Bad Request)} if the bonDeCommande has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bon-de-commandes")
    public ResponseEntity<BonDeCommandeDTO> createBonDeCommande(@RequestBody BonDeCommandeDTO bonDeCommandeDTO) throws URISyntaxException {
        log.debug("REST request to save BonDeCommande : {}", bonDeCommandeDTO);
        if (bonDeCommandeDTO.getId() != null) {
            throw new BadRequestAlertException("A new bonDeCommande cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BonDeCommandeDTO result = bonDeCommandeService.save(bonDeCommandeDTO);
        return ResponseEntity
            .created(new URI("/api/bon-de-commandes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bon-de-commandes/:id} : Updates an existing bonDeCommande.
     *
     * @param id the id of the bonDeCommandeDTO to save.
     * @param bonDeCommandeDTO the bonDeCommandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bonDeCommandeDTO,
     * or with status {@code 400 (Bad Request)} if the bonDeCommandeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bonDeCommandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bon-de-commandes/{id}")
    public ResponseEntity<BonDeCommandeDTO> updateBonDeCommande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody BonDeCommandeDTO bonDeCommandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update BonDeCommande : {}, {}", id, bonDeCommandeDTO);
        if (bonDeCommandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, bonDeCommandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!bonDeCommandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        BonDeCommandeDTO result = bonDeCommandeService.update(bonDeCommandeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bonDeCommandeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /bon-de-commandes/:id} : Partial updates given fields of an existing bonDeCommande, field will ignore if it is null
     *
     * @param id the id of the bonDeCommandeDTO to save.
     * @param bonDeCommandeDTO the bonDeCommandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bonDeCommandeDTO,
     * or with status {@code 400 (Bad Request)} if the bonDeCommandeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the bonDeCommandeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the bonDeCommandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/bon-de-commandes/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<BonDeCommandeDTO> partialUpdateBonDeCommande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody BonDeCommandeDTO bonDeCommandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update BonDeCommande partially : {}, {}", id, bonDeCommandeDTO);
        if (bonDeCommandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, bonDeCommandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!bonDeCommandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<BonDeCommandeDTO> result = bonDeCommandeService.partialUpdate(bonDeCommandeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bonDeCommandeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /bon-de-commandes} : get all the bonDeCommandes.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bonDeCommandes in body.
     */
    @GetMapping("/bon-de-commandes")
    public ResponseEntity<List<BonDeCommandeDTO>> getAllBonDeCommandes(
        BonDeCommandeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get BonDeCommandes by criteria: {}", criteria);
        Page<BonDeCommandeDTO> page = bonDeCommandeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /bon-de-commandes/count} : count all the bonDeCommandes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/bon-de-commandes/count")
    public ResponseEntity<Long> countBonDeCommandes(BonDeCommandeCriteria criteria) {
        log.debug("REST request to count BonDeCommandes by criteria: {}", criteria);
        return ResponseEntity.ok().body(bonDeCommandeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /bon-de-commandes/:id} : get the "id" bonDeCommande.
     *
     * @param id the id of the bonDeCommandeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bonDeCommandeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bon-de-commandes/{id}")
    public ResponseEntity<BonDeCommandeDTO> getBonDeCommande(@PathVariable Long id) {
        log.debug("REST request to get BonDeCommande : {}", id);
        Optional<BonDeCommandeDTO> bonDeCommandeDTO = bonDeCommandeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bonDeCommandeDTO);
    }

    /**
     * {@code DELETE  /bon-de-commandes/:id} : delete the "id" bonDeCommande.
     *
     * @param id the id of the bonDeCommandeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bon-de-commandes/{id}")
    public ResponseEntity<Void> deleteBonDeCommande(@PathVariable Long id) {
        log.debug("REST request to delete BonDeCommande : {}", id);
        bonDeCommandeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
