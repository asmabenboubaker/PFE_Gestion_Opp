package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T12:16:03+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DemandeInputMapperImpl extends DemandeInputMapper {

    @Override
    public List<Demande> toEntity(List<DemandeInputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Demande> list = new ArrayList<Demande>( dtoList.size() );
        for ( DemandeInputDTO demandeInputDTO : dtoList ) {
            list.add( toEntity( demandeInputDTO ) );
        }

        return list;
    }

    @Override
    public List<DemandeInputDTO> toDto(List<Demande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DemandeInputDTO> list = new ArrayList<DemandeInputDTO>( entityList.size() );
        for ( Demande demande : entityList ) {
            list.add( toDto( demande ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Demande entity, DemandeInputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAssignee() != null ) {
            entity.setAssignee( dto.getAssignee() );
        }
        if ( dto.getEndProcess() != null ) {
            entity.setEndProcess( dto.getEndProcess() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getActivityName() != null ) {
            entity.setActivityName( dto.getActivityName() );
        }
        if ( dto.getSecuriteLevel() != null ) {
            entity.setSecuriteLevel( dto.getSecuriteLevel() );
        }
        if ( dto.getWfProcessID() != null ) {
            entity.setWfProcessID( dto.getWfProcessID() );
        }
        if ( dto.getStatutDemande() != null ) {
            entity.setStatutDemande( dto.getStatutDemande() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getDateDeCreation() != null ) {
            entity.setDateDeCreation( dto.getDateDeCreation() );
        }
        if ( dto.getStatut() != null ) {
            entity.setStatut( dto.getStatut() );
        }
        if ( entity.getDomaines() != null ) {
            Set<Domaine> set = domaineDTOSetToDomaineSet( dto.getDomaines() );
            if ( set != null ) {
                entity.getDomaines().clear();
                entity.getDomaines().addAll( set );
            }
        }
        else {
            Set<Domaine> set = domaineDTOSetToDomaineSet( dto.getDomaines() );
            if ( set != null ) {
                entity.domaines( set );
            }
        }
        if ( dto.getClient() != null ) {
            if ( entity.getClient() == null ) {
                entity.client( new Client() );
            }
            clientDTOToClient( dto.getClient(), entity.getClient() );
        }
    }

    @Override
    public Demande toEntity(DemandeInputDTO demandeInputDTO) {
        if ( demandeInputDTO == null ) {
            return null;
        }

        Demande demande = new Demande();

        demande.setAssignee( demandeInputDTO.getAssignee() );
        demande.setEndProcess( demandeInputDTO.getEndProcess() );
        demande.setId( demandeInputDTO.getId() );
        demande.setStatus( demandeInputDTO.getStatus() );
        demande.setActivityName( demandeInputDTO.getActivityName() );
        demande.setSecuriteLevel( demandeInputDTO.getSecuriteLevel() );
        demande.setWfProcessID( demandeInputDTO.getWfProcessID() );
        demande.setStatutDemande( demandeInputDTO.getStatutDemande() );
        demande.setDescription( demandeInputDTO.getDescription() );
        demande.setNom( demandeInputDTO.getNom() );
        demande.setDateDeCreation( demandeInputDTO.getDateDeCreation() );
        demande.setStatut( demandeInputDTO.getStatut() );
        demande.domaines( domaineDTOSetToDomaineSet( demandeInputDTO.getDomaines() ) );
        demande.client( clientDTOToClient1( demandeInputDTO.getClient() ) );

        return demande;
    }

    @Override
    public DemandeInputDTO toDto(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeInputDTO demandeInputDTO = new DemandeInputDTO();

        demandeInputDTO.setWfProcessID( demande.getWfProcessID() );
        demandeInputDTO.setActivityName( demande.getActivityName() );
        demandeInputDTO.setEndProcess( demande.getEndProcess() );
        demandeInputDTO.setAssignee( demande.getAssignee() );
        demandeInputDTO.setStatus( demande.getStatus() );
        demandeInputDTO.setSecuriteLevel( demande.getSecuriteLevel() );
        demandeInputDTO.setId( demande.getId() );
        demandeInputDTO.setStatutDemande( demande.getStatutDemande() );
        demandeInputDTO.setDescription( demande.getDescription() );
        demandeInputDTO.setNom( demande.getNom() );
        demandeInputDTO.setDateDeCreation( demande.getDateDeCreation() );
        demandeInputDTO.setStatut( demande.getStatut() );
        demandeInputDTO.setDomaines( domaineSetToDomaineDTOSet( demande.getDomaines() ) );
        demandeInputDTO.setClient( clientToClientDTO( demande.getClient() ) );

        return demandeInputDTO;
    }

    protected Domaine domaineDTOToDomaine(DomaineDTO domaineDTO) {
        if ( domaineDTO == null ) {
            return null;
        }

        Domaine domaine = new Domaine();

        domaine.setId( domaineDTO.getId() );
        domaine.setNom( domaineDTO.getNom() );
        domaine.setDescription( domaineDTO.getDescription() );

        return domaine;
    }

    protected Set<Domaine> domaineDTOSetToDomaineSet(Set<DomaineDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Domaine> set1 = new HashSet<Domaine>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DomaineDTO domaineDTO : set ) {
            set1.add( domaineDTOToDomaine( domaineDTO ) );
        }

        return set1;
    }

    protected void clientDTOToClient(ClientDTO clientDTO, Client mappingTarget) {
        if ( clientDTO == null ) {
            return;
        }

        if ( clientDTO.getId() != null ) {
            mappingTarget.setId( clientDTO.getId() );
        }
        if ( clientDTO.getAdresse() != null ) {
            mappingTarget.setAdresse( clientDTO.getAdresse() );
        }
        if ( clientDTO.getTelephne() != null ) {
            mappingTarget.setTelephne( clientDTO.getTelephne() );
        }
        if ( clientDTO.getEmail() != null ) {
            mappingTarget.setEmail( clientDTO.getEmail() );
        }
        if ( clientDTO.getDescription() != null ) {
            mappingTarget.setDescription( clientDTO.getDescription() );
        }
        if ( clientDTO.getNom() != null ) {
            mappingTarget.setNom( clientDTO.getNom() );
        }
        if ( clientDTO.getDateInscription() != null ) {
            mappingTarget.setDateInscription( clientDTO.getDateInscription() );
        }
        if ( clientDTO.getTypeClient() != null ) {
            mappingTarget.setTypeClient( clientDTO.getTypeClient() );
        }
        if ( clientDTO.getNotes() != null ) {
            mappingTarget.setNotes( clientDTO.getNotes() );
        }
    }

    protected Client clientDTOToClient1(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setAdresse( clientDTO.getAdresse() );
        client.setTelephne( clientDTO.getTelephne() );
        client.setEmail( clientDTO.getEmail() );
        client.setDescription( clientDTO.getDescription() );
        client.setNom( clientDTO.getNom() );
        client.setDateInscription( clientDTO.getDateInscription() );
        client.setTypeClient( clientDTO.getTypeClient() );
        client.setNotes( clientDTO.getNotes() );

        return client;
    }

    protected DomaineDTO domaineToDomaineDTO(Domaine domaine) {
        if ( domaine == null ) {
            return null;
        }

        DomaineDTO domaineDTO = new DomaineDTO();

        domaineDTO.setId( domaine.getId() );
        domaineDTO.setNom( domaine.getNom() );
        domaineDTO.setDescription( domaine.getDescription() );

        return domaineDTO;
    }

    protected Set<DomaineDTO> domaineSetToDomaineDTOSet(Set<Domaine> set) {
        if ( set == null ) {
            return null;
        }

        Set<DomaineDTO> set1 = new HashSet<DomaineDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Domaine domaine : set ) {
            set1.add( domaineToDomaineDTO( domaine ) );
        }

        return set1;
    }

    protected ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setAdresse( client.getAdresse() );
        clientDTO.setTelephne( client.getTelephne() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setDescription( client.getDescription() );
        clientDTO.setNom( client.getNom() );
        clientDTO.setDateInscription( client.getDateInscription() );
        clientDTO.setTypeClient( client.getTypeClient() );
        clientDTO.setNotes( client.getNotes() );

        return clientDTO;
    }
}
