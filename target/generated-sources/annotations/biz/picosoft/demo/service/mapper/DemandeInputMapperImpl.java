package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-19T16:17:29+0200",
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
            Set<Domaine> set = dto.getDomaines();
            if ( set != null ) {
                entity.getDomaines().clear();
                entity.getDomaines().addAll( set );
            }
        }
        else {
            Set<Domaine> set = dto.getDomaines();
            if ( set != null ) {
                entity.domaines( new HashSet<Domaine>( set ) );
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

        demande.setCreateOpp( demandeInputDTO.isCreateOpp() );
        demande.setSource( demandeInputDTO.getSource() );
        demande.setCommentaires( demandeInputDTO.getCommentaires() );
        demande.setDeadline( demandeInputDTO.getDeadline() );
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
        Set<Domaine> set = demandeInputDTO.getDomaines();
        if ( set != null ) {
            demande.domaines( new HashSet<Domaine>( set ) );
        }
        demande.client( clientDTOToClient1( demandeInputDTO.getClient() ) );

        return demande;
    }

    @Override
    public DemandeInputDTO toDto(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeInputDTO demandeInputDTO = new DemandeInputDTO();

        demandeInputDTO.setCreateOpp( demande.isCreateOpp() );
        demandeInputDTO.setDeadline( demande.getDeadline() );
        demandeInputDTO.setSource( demande.getSource() );
        demandeInputDTO.setCommentaires( demande.getCommentaires() );
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
        Set<Domaine> set = demande.getDomaines();
        if ( set != null ) {
            demandeInputDTO.setDomaines( new HashSet<Domaine>( set ) );
        }
        demandeInputDTO.setClient( clientToClientDTO( demande.getClient() ) );

        return demandeInputDTO;
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
