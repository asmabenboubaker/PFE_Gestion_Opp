package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.repository.ClientRepository;
import biz.picosoft.demo.repository.DemandeRepository;
import biz.picosoft.demo.service.DemandeService;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.mapper.DemandeMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Demande}.
 */
@Service
@Transactional
public class DemandeServiceImpl implements DemandeService {

    private final Logger log = LoggerFactory.getLogger(DemandeServiceImpl.class);

    private final DemandeRepository demandeRepository;
    private final ClientRepository clientRepository;
    private final DemandeMapper demandeMapper;

    public DemandeServiceImpl(DemandeRepository demandeRepository, DemandeMapper demandeMapper,ClientRepository clientRepository) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
        this.clientRepository=clientRepository;

    }

    @Override
    public DemandeDTO save(DemandeDTO demandeDTO) {
        log.debug("Request to save Demande : {}", demandeDTO);
        Demande demande = demandeMapper.toEntity(demandeDTO);
        demande = demandeRepository.save(demande);
        return demandeMapper.toDto(demande);
    }

    @Override
    public DemandeDTO update(DemandeDTO demandeDTO) {
        log.debug("Request to save Demande : {}", demandeDTO);
        Demande demande = demandeMapper.toEntity(demandeDTO);
        demande = demandeRepository.save(demande);
        return demandeMapper.toDto(demande);
    }

    @Override
    public Optional<DemandeDTO> partialUpdate(DemandeDTO demandeDTO) {
        log.debug("Request to partially update Demande : {}", demandeDTO);

        return demandeRepository
            .findById(demandeDTO.getId())
            .map(existingDemande -> {
                demandeMapper.partialUpdate(existingDemande, demandeDTO);

                return existingDemande;
            })
            .map(demandeRepository::save)
            .map(demandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DemandeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Demandes");
        return demandeRepository.findAll(pageable).map(demandeMapper::toDto);
    }


    public Page<DemandeDTO> findAllWithEagerRelationships(Pageable pageable) {
        return demandeRepository.findAllWithEagerRelationships(pageable).map(demandeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DemandeDTO> findOne(Long id) {
        log.debug("Request to get Demande : {}", id);
        return demandeRepository.findOneWithEagerRelationships(id).map(demandeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Demande : {}", id);
        demandeRepository.deleteById(id);
    }

    @Override
    public Demande saveAndAssignToClient(Demande demandeDTO, Long clientId) {
        log.debug("Request to save Demande and assign to Client: {}", demandeDTO);
       // Demande demande = demandeMapper.toEntity(demandeDTO);

        // Fetch the Client from the database
        Client client = clientRepository.findById(clientId).get();
        if (client!=null) {
            demandeDTO.setClient(client);
            demandeRepository.save(demandeDTO);
        } else {
            throw new IllegalArgumentException("Client with id " + clientId + " not found.");
        }

        return demandeDTO;
    }

    @Override
    public Page<Demande> findAllDemande(Pageable pageable) {
        return demandeRepository.findAll(pageable);
    }

    @Override
    public Demande getById(Long id) {
        log.debug("Request to get Demande : {}", id);
        return demandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Demande with id " + id + " not found."));

    }

    @Override
    public Demande updateAndAssignToClient(Long demandeId, Long clientId, DemandeDTO updatedDemandeDTO) {
        log.debug("Request to update Demande with ID {} and assign to Client with ID {}", demandeId, clientId);

        // Fetch the existing demand from the database
        Demande existingDemande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new IllegalArgumentException("Demande with id " + demandeId + " not found."));

        // Fetch the client from the database
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client with id " + clientId + " not found."));

        // Update the demand with new information
        Demande updatedDemande = demandeMapper.toEntity(updatedDemandeDTO);
        updatedDemande.setId(demandeId); // Ensure the ID is set to the correct value

        // Assign the demand to the fetched client
        updatedDemande.setClient(client);

        // Save the updated demand
        return demandeRepository.save(updatedDemande);
    }


}
