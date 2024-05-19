package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T13:48:16+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DemandeOutputMapperImpl extends DemandeOutputMapper {

    @Override
    public List<Demande> toEntity(List<DemandeOutputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Demande> list = new ArrayList<Demande>( dtoList.size() );
        for ( DemandeOutputDTO demandeOutputDTO : dtoList ) {
            list.add( toEntity( demandeOutputDTO ) );
        }

        return list;
    }

    @Override
    public List<DemandeOutputDTO> toDto(List<Demande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DemandeOutputDTO> list = new ArrayList<DemandeOutputDTO>( entityList.size() );
        for ( Demande demande : entityList ) {
            list.add( toDto( demande ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Demande entity, DemandeOutputDTO dto) {
        if ( dto == null ) {
            return;
        }

        entity.setCreateOpp( dto.isCreateOpp() );
        if ( dto.getSource() != null ) {
            entity.setSource( dto.getSource() );
        }
        if ( dto.getCommentaires() != null ) {
            entity.setCommentaires( dto.getCommentaires() );
        }
        if ( dto.getDeadline() != null ) {
            entity.setDeadline( dto.getDeadline() );
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
    public Demande toEntity(DemandeOutputDTO demandeOutputDTO) {
        if ( demandeOutputDTO == null ) {
            return null;
        }

        Demande demande = new Demande();

        demande.setCreateOpp( demandeOutputDTO.isCreateOpp() );
        demande.setSource( demandeOutputDTO.getSource() );
        demande.setCommentaires( demandeOutputDTO.getCommentaires() );
        demande.setDeadline( demandeOutputDTO.getDeadline() );
        demande.setAssignee( demandeOutputDTO.getAssignee() );
        demande.setEndProcess( demandeOutputDTO.getEndProcess() );
        demande.setId( demandeOutputDTO.getId() );
        demande.setStatus( demandeOutputDTO.getStatus() );
        demande.setActivityName( demandeOutputDTO.getActivityName() );
        demande.setSecuriteLevel( demandeOutputDTO.getSecuriteLevel() );
        demande.setWfProcessID( demandeOutputDTO.getWfProcessID() );
        demande.setStatutDemande( demandeOutputDTO.getStatutDemande() );
        demande.setDescription( demandeOutputDTO.getDescription() );
        demande.setNom( demandeOutputDTO.getNom() );
        demande.setDateDeCreation( demandeOutputDTO.getDateDeCreation() );
        demande.setStatut( demandeOutputDTO.getStatut() );
        demande.domaines( domaineDTOSetToDomaineSet( demandeOutputDTO.getDomaines() ) );
        demande.client( clientDTOToClient1( demandeOutputDTO.getClient() ) );

        return demande;
    }

    @Override
    public DemandeOutputDTO toDto(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeOutputDTO demandeOutputDTO = new DemandeOutputDTO();

        demandeOutputDTO.setDeadline( demande.getDeadline() );
        demandeOutputDTO.setSource( demande.getSource() );
        demandeOutputDTO.setCommentaires( demande.getCommentaires() );
        demandeOutputDTO.setCreateOpp( demande.isCreateOpp() );
        demandeOutputDTO.setWfProcessID( demande.getWfProcessID() );
        demandeOutputDTO.setActivityName( demande.getActivityName() );
        demandeOutputDTO.setEndProcess( demande.getEndProcess() );
        demandeOutputDTO.setAssignee( demande.getAssignee() );
        demandeOutputDTO.setStatus( demande.getStatus() );
        demandeOutputDTO.setSecuriteLevel( demande.getSecuriteLevel() );
        demandeOutputDTO.setId( demande.getId() );
        demandeOutputDTO.setStatutDemande( demande.getStatutDemande() );
        demandeOutputDTO.setDescription( demande.getDescription() );
        demandeOutputDTO.setNom( demande.getNom() );
        demandeOutputDTO.setDateDeCreation( demande.getDateDeCreation() );
        demandeOutputDTO.setStatut( demande.getStatut() );
        demandeOutputDTO.setDomaines( domaineSetToDomaineDTOSet( demande.getDomaines() ) );
        demandeOutputDTO.setClient( clientToClientDTO( demande.getClient() ) );

        return demandeOutputDTO;
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
