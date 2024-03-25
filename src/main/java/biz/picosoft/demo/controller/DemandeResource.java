package biz.picosoft.demo.controller;

import biz.picosoft.demo.client.kernel.intercomm.KernelInterface;
import biz.picosoft.demo.client.kernel.model.acl.AclClass;
import biz.picosoft.demo.controller.errors.BadRequestAlertException;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.FileModel;
import biz.picosoft.demo.domain.enumeration.StatutDemande;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.service.ClientService;
import biz.picosoft.demo.service.DemandeQueryService;
import biz.picosoft.demo.service.DemandeSer;
import biz.picosoft.demo.service.DemandeService;
import biz.picosoft.demo.service.criteria.DemandeCriteria;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link biz.picosoft.demo.domain.Demande}.
 */
@RestController
@RequestMapping("/api")
public class DemandeResource {

    private final Logger log = LoggerFactory.getLogger(DemandeResource.class);

    private static final String ENTITY_NAME = "demande";

    //@Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DemandeService demandeService;
    private final ClientService clientService;
    private final DemandeSer demandeSer;
    private final KernelInterface kernelInterface;

    private final DemandeRepository demandeRepository;

    private final DemandeQueryService demandeQueryService;

    public DemandeResource(DemandeService demandeService, DemandeSer demandeSer, KernelInterface kernelInterface, DemandeRepository demandeRepository, DemandeQueryService demandeQueryService,ClientService clientService) {
        this.demandeService = demandeService;
        this.demandeSer = demandeSer;
        this.kernelInterface = kernelInterface;
        this.demandeRepository = demandeRepository;
        this.demandeQueryService = demandeQueryService;
        this.clientService=clientService;
    }
    @PatchMapping("/initDemande")
    public ResponseEntity<DemandeDTO> initDemande() throws JsonProcessingException {
        log.debug("REST request to init Demande : {}");
        DemandeDTO result = demandeSer.initDemande();

        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
    @PutMapping(value = {"/save-demande"})
    public ResponseEntity<Void> putBPMDemande(@RequestBody String stringInvoice) throws ParseException, JsonProcessingException {
        log.debug("REST request to Save Demande : {}");

        demandeSer.putBPMDemande(stringInvoice, Demande.class.getName());

        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, "")).build();

    }
    /**
     * {@code PATCH  /submitInvoice} : submit invoice.
     *
     * @return the {@link ResponseEntity<DemandeDTO>}  with status {@code 201 (Created)} and with body the identified invoice recement initiated, or with status {@code 400 (Bad Request)} if the invoice no already has an ID.
     */
    @PatchMapping("/submitInvoice")
    public ResponseEntity<DemandeDTO> submitDemande(@Valid @RequestBody DemandeDTO demandeDTO) throws Exception {
        log.debug("REST request to submit demande: " + demandeDTO.toString());

        AclClass aclClass = kernelInterface.getaclClassByClassName(Demande.class.getName());

        Long id = demandeSer.submitInvoice(demandeDTO, aclClass);

        DemandeDTO result=demandeSer.findOneById(id, aclClass);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
                .body(result);

    }

    /**
     * {@code POST  /demandes} : Create a new demande.
     *
     * @param demandeDTO the demandeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new demandeDTO, or with status {@code 400 (Bad Request)} if the demande has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/demandes")
    public ResponseEntity<DemandeDTO> createDemande(@RequestBody DemandeDTO demandeDTO) throws URISyntaxException {
        log.debug("REST request to save Demande : {}", demandeDTO);
        if (demandeDTO.getId() != null) {
            throw new BadRequestAlertException("A new demande cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DemandeDTO result = demandeService.save(demandeDTO);
        return ResponseEntity
            .created(new URI("/api/demandes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /demandes/:id} : Updates an existing demande.
     *
     * @param id the id of the demandeDTO to save.
     * @param demandeDTO the demandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated demandeDTO,
     * or with status {@code 400 (Bad Request)} if the demandeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the demandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/demandes/{id}")
    public ResponseEntity<DemandeDTO> updateDemande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DemandeDTO demandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Demande : {}, {}", id, demandeDTO);
        if (demandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, demandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!demandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DemandeDTO result = demandeService.update(demandeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, demandeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /demandes/:id} : Partial updates given fields of an existing demande, field will ignore if it is null
     *
     * @param id the id of the demandeDTO to save.
     * @param demandeDTO the demandeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated demandeDTO,
     * or with status {@code 400 (Bad Request)} if the demandeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the demandeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the demandeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/demandes/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DemandeDTO> partialUpdateDemande(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody DemandeDTO demandeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Demande partially : {}, {}", id, demandeDTO);
        if (demandeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, demandeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!demandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DemandeDTO> result = demandeService.partialUpdate(demandeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, demandeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /demandes} : get all the demandes.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of demandes in body.
     */
    @GetMapping("/demandes")
    public ResponseEntity<Page<DemandeDTO>> getAllDemandes(
        DemandeCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Demandes by criteria: {}", criteria);
        Page<DemandeDTO> page = demandeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }
    @GetMapping("/demandes/WithoutPages")
    public ResponseEntity<List<DemandeDTO>> getAllDemandesWithoutPages(
            DemandeCriteria criteria,
            @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get Demandes by criteria: {}", criteria);
        Page<DemandeDTO> page = demandeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    @GetMapping("/demandes/list")
    public ResponseEntity<List<Demande>> getAllDemandeslist() {
        log.debug("REST request to get all Demandes");
        List<Demande> demandes = demandeRepository.findAll();
        return ResponseEntity.ok().body(demandes);
    }
    /**
     * {@code GET  /demandes/count} : count all the demandes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/demandes/count")
    public ResponseEntity<Long> countDemandes(DemandeCriteria criteria) {
        log.debug("REST request to count Demandes by criteria: {}", criteria);
        return ResponseEntity.ok().body(demandeQueryService.countByCriteria(criteria));
    }


    /**
     * {@code GET  /demandes/:id} : get the "id" demande.
     *
     * @param id the id of the demandeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the demandeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/demandes/{id}")
    public ResponseEntity<DemandeDTO> getDemande(@PathVariable Long id) {
        log.debug("REST request to get Demande : {}", id);
        Optional<DemandeDTO> demandeDTO = demandeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(demandeDTO);
    }

    /**
     * {@code DELETE  /demandes/:id} : delete the "id" demande.
     *
     * @param id the id of the demandeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/demandes/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        log.debug("REST request to delete Demande : {}", id);
        demandeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<String>> getStatusList() {
        List<String> statusList = Arrays.stream(StatutDemande.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        return ResponseEntity.ok(statusList);
    }

//    /**
//     * {@code POST  /demandes} : Create a new demande and assign it to a client.
//     *
//     * @param demandeDTO the demandeDTO to create.
//     * @param clientId   the ID of the client to assign the demande to.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new demandeDTO, or with status {@code 400 (Bad Request)} if the demande has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//
//
//
//    @RequestMapping(value = "/demandes/client", method = RequestMethod.POST, consumes = {"multipart/form-data"})
//    public Demande createDemandeAndAssignToClient(@RequestBody Demande demandeDTO, @RequestParam Long clientId,@RequestPart("imageFile")MultipartFile[] file) throws URISyntaxException {
//        log.debug("REST request to save Demande and assign to Client: {}", demandeDTO);
//        if (demandeDTO.getId() != null) {
//            throw new BadRequestAlertException("A new demande cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        try{
//            // Set<ImageModel> images= uploadImage
//            Set<FileModel> images=uploadFile(file);
//            demandeDTO.setImages(images);
//            return demandeService.saveAndAssignToClient(demandeDTO, clientId);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//       // Demande result = demandeService.saveAndAssignToClient(demandeDTO, clientId);
//
//
//    }


    @PostMapping(value = "/demandes/client", consumes = {"multipart/form-data"})
    public ResponseEntity<Demande> createDemandeAndAssignToClient(
            @RequestParam("demandeDTO") String demandeDTOJson,
            @RequestParam("clientId") Long clientId,
            @RequestPart("imageFile") MultipartFile[] file) throws URISyntaxException {
        log.debug("REST request to save Demande and assign to Client: {}", demandeDTOJson);

        ObjectMapper objectMapper = new ObjectMapper();
        Demande demandeDTO = null;
        try {
            demandeDTO = objectMapper.readValue(demandeDTOJson, Demande.class);
        } catch (IOException e) {
            // Handle JSON parsing exception
            e.printStackTrace();
        }

        if (demandeDTO.getId() != null) {
            throw new BadRequestAlertException("A new demande cannot already have an ID", ENTITY_NAME, "idexists");
        }

        try {
            Set<FileModel> images = uploadFile(file);
            demandeDTO.setImages(images);
            Demande savedDemande = demandeService.saveAndAssignToClient(demandeDTO, clientId);
            return ResponseEntity
                    .created(new URI("/api/demandes/" + savedDemande.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, savedDemande.getId().toString()))
                    .body(savedDemande);
        } catch (Exception e) {
            // Handle file upload exception
            log.error("Error occurred while processing file upload: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public Set<FileModel>  uploadFile(MultipartFile[] multipartFiles) throws IOException, IOException {
        Set<FileModel> imageModels=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            FileModel imageModel=new FileModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }
    @GetMapping("/demandes/byid/{id}")
    public ResponseEntity<Demande> getDemandebyid(@PathVariable Long id) {
        log.debug("REST request to get Demande : {}", id);
        Demande demande = demandeService.getById(id);
        return ResponseEntity.ok().body(demande);
    }

    @PutMapping("/demandes/assign-client/{id}/{clientId}")
    public ResponseEntity<Demande> updateAndAssignToClient(
            @PathVariable Long id,
            @PathVariable Long clientId,
            @RequestBody DemandeDTO demande
    ) throws URISyntaxException {
        log.debug("REST request to update Demande with ID {} and assign to Client with ID {}", id, clientId);


        if (!demandeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Demande result = demandeService.updateAndAssignToClient(id, clientId, demande);
        return ResponseEntity
                .ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, demande.getId().toString()))
                .body(result);
    }
}
