package biz.picosoft.demo.controller;


import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.domain.InvoiceItem;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.FactureRepository;
import biz.picosoft.demo.service.FactureQueryService;
import biz.picosoft.demo.service.FactureService;
import biz.picosoft.demo.service.criteria.FactureCriteria;
import biz.picosoft.demo.service.dto.FactureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link biz.picosoft.demo.domain.Facture}.
 */
@RestController
@RequestMapping("/api")
public class FactureResource {

    private final Logger log = LoggerFactory.getLogger(FactureResource.class);

    private static final String ENTITY_NAME = "facture";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FactureService factureService;

    private final FactureRepository factureRepository;

    private final FactureQueryService factureQueryService;
    private final ClientRepository clientRepository;

    public FactureResource(FactureService factureService, FactureRepository factureRepository, FactureQueryService factureQueryService,
                            ClientRepository clientRepository
    ) {
        this.factureService = factureService;
        this.factureRepository = factureRepository;
        this.factureQueryService = factureQueryService;
        this.clientRepository = clientRepository;
    }

    /**
     * {@code POST  /factures} : Create a new facture.
     *
     * @param factureDTO the factureDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new factureDTO, or with status {@code 400 (Bad Request)} if the facture has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/factures")
    public ResponseEntity<FactureDTO> createFacture(@RequestBody FactureDTO factureDTO) throws URISyntaxException {
        log.debug("REST request to save Facture : {}", factureDTO);

        if (factureDTO.getId() != null) {
            throw new BadRequestAlertException("A new facture cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FactureDTO result = factureService.save(factureDTO);
        return ResponseEntity
            .created(new URI("/api/factures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /factures/:id} : Updates an existing facture.
     *
     * @param id the id of the factureDTO to save.
     * @param factureDTO the factureDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated factureDTO,
     * or with status {@code 400 (Bad Request)} if the factureDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the factureDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/factures/{id}")
    public ResponseEntity<FactureDTO> updateFacture(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FactureDTO factureDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Facture : {}, {}", id, factureDTO);
        if (factureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, factureDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!factureRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FactureDTO result = factureService.update(factureDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, factureDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /factures/:id} : Partial updates given fields of an existing facture, field will ignore if it is null
     *
     * @param id the id of the factureDTO to save.
     * @param factureDTO the factureDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated factureDTO,
     * or with status {@code 400 (Bad Request)} if the factureDTO is not valid,
     * or with status {@code 404 (Not Found)} if the factureDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the factureDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/factures/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<FactureDTO> partialUpdateFacture(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FactureDTO factureDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Facture partially : {}, {}", id, factureDTO);
        if (factureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, factureDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!factureRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FactureDTO> result = factureService.partialUpdate(factureDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, factureDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /factures} : get all the factures.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of factures in body.
     */
    @GetMapping("/factures")
    public ResponseEntity<Page<FactureDTO>> getAllFactures(
        @RequestParam(required = false) FactureCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable

    ) {

        log.debug("REST request to get Factures by criteria: {}", criteria);
        Page<FactureDTO> page = factureQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }

    /**
     * {@code GET  /factures/count} : count all the factures.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/factures/count")
    public ResponseEntity<Long> countFactures(FactureCriteria criteria) {
        log.debug("REST request to count Factures by criteria: {}", criteria);
        return ResponseEntity.ok().body(factureQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /factures/:id} : get the "id" facture.
     *
     * @param id the id of the factureDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the factureDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/factures/{id}")
    public ResponseEntity<FactureDTO> getFacture(@PathVariable Long id) {
        log.debug("REST request to get Facture : {}", id);
        Optional<FactureDTO> factureDTO = factureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(factureDTO);
    }

    /**
     * {@code DELETE  /factures/:id} : delete the "id" facture.
     *
     * @param id the id of the factureDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/factures/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        log.debug("REST request to delete Facture : {}", id);
        factureService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }

    @PostMapping("/generateReportFacture")
    public ResponseEntity<String> generateReport(@RequestBody Map<String, Object> requestMap) {
        try {
            return factureService.generateReport(requestMap);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // return somthing wrong
        return ResponseEntity.ok().body("Something went wrong");

    }
    //add and affecter PV
    @PostMapping("/affectFactureToPv/{idPv}")
    public ResponseEntity<String> affectFactureToPv(@RequestBody Facture facture, @PathVariable Long idPv) {
        try {
            return factureService.affectFactureToPv(facture, idPv);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        // return somthing wrong
        return ResponseEntity.ok().body("Something went wrong");

    }

    @PostMapping("/saveFactureWithItems")
    public ResponseEntity<Facture> saveFactureWithItems(@RequestBody Facture facture) {
        Facture savedFacture = factureService.saveFactureWithItems(facture, facture.getInvoiceItems());
        return ResponseEntity.ok().body(savedFacture);
    }
    @PostMapping("/saveFactureWithItems2/{clientId}")
    @Transactional
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture, @PathVariable Long clientId) {
        // Ensure invoice items are properly associated with the facture
        for (InvoiceItem item : facture.getInvoiceItems()) {
            item.setFacture(facture);
        }
        //find client by id
        Client client = clientRepository.findById(clientId).orElseThrow();
        facture.setClient(client);
        Facture savedFacture = factureRepository.save(facture);
        return ResponseEntity.ok().body(savedFacture);
    }

    //getbyid
    @GetMapping("/factures/invoiceItems/{id}")
    public ResponseEntity<Facture> getFactureWithItems(@PathVariable Long id) {
        Optional<Facture> facture = factureRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(facture);
    }
    //get list item by id facture
    @GetMapping("/factures/items/{id}")
    public ResponseEntity<Set<InvoiceItem>> getItemsByFactureId(@PathVariable Long id) {
        Set<InvoiceItem> items = factureService.getItemsByFactureId(id);
        return ResponseEntity.ok().body(items);
    }
    //assignClientToFacture
    @PostMapping("/factures/assignClient/{factureId}/{clientId}")
    public ResponseEntity<Facture> assignClientToFacture(@PathVariable Long factureId, @PathVariable Long clientId) {
        Facture facture = factureService.assignClientToFacture(factureId, clientId);
        return ResponseEntity.ok().body(facture);
    }
    //update Facture
    @PutMapping("/factures/updateFacture/{factureId}/{clientId}")
    @Transactional
    public ResponseEntity<Facture> updateFacture(@RequestBody Facture updatedFacture,
                                                 @PathVariable Long factureId,
                                                 @PathVariable Long clientId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        Facture existingFacture = factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture not found with id: " + factureId));

        existingFacture.setDescription(updatedFacture.getDescription());
        existingFacture.setDateFacture(updatedFacture.getDateFacture());
        existingFacture.setServiceFournis(updatedFacture.getServiceFournis());

        existingFacture.getInvoiceItems().clear();
        for (InvoiceItem item : updatedFacture.getInvoiceItems()) {
            item.setFacture(existingFacture);
            existingFacture.getInvoiceItems().add(item);
        }

        existingFacture.setClient(client);

        Facture savedFacture = factureRepository.save(existingFacture);
        return ResponseEntity.ok().body(savedFacture);
    }
    // set boolean isPaid true
    @PutMapping("/factures/setIsPaid/{factureId}")
    public ResponseEntity<Facture> setIsPaid(@PathVariable Long factureId) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture not found with id: " + factureId));
        facture.setIsPaid(facture.getIsPaid() == null || !facture.getIsPaid());
        Facture savedFacture = factureRepository.save(facture);
        return ResponseEntity.ok().body(savedFacture);
    }
    //return ispaid by facture id
    @GetMapping("/factures/isPaid/{factureId}")
    public ResponseEntity<Boolean> getIsPaid(@PathVariable Long factureId) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture not found with id: " + factureId));
        return ResponseEntity.ok().body(facture.getIsPaid());
    }
    // somme total des montants des factures
    @GetMapping("/factures/totalAmount")
    public ResponseEntity<Double> getTotalAmount() {
        Double totalAmount = factureService.getTotalAmount();
        return ResponseEntity.ok().body(totalAmount);
    }

}
