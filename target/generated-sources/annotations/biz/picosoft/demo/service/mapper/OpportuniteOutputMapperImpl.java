package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.OpportuniteOutputDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T14:51:52+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OpportuniteOutputMapperImpl extends OpportuniteOutputMapper {

    @Override
    public List<Opportunite> toEntity(List<OpportuniteOutputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Opportunite> list = new ArrayList<Opportunite>( dtoList.size() );
        for ( OpportuniteOutputDTO opportuniteOutputDTO : dtoList ) {
            list.add( toEntity( opportuniteOutputDTO ) );
        }

        return list;
    }

    @Override
    public List<OpportuniteOutputDTO> toDto(List<Opportunite> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OpportuniteOutputDTO> list = new ArrayList<OpportuniteOutputDTO>( entityList.size() );
        for ( Opportunite opportunite : entityList ) {
            list.add( toDto( opportunite ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Opportunite entity, OpportuniteOutputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getNomDepartement() != null ) {
            entity.setNomDepartement( dto.getNomDepartement() );
        }
        if ( dto.getSidDepartement() != null ) {
            entity.setSidDepartement( dto.getSidDepartement() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( entity.getEquipes() != null ) {
            Set<Equipe> set = dto.getEquipes();
            if ( set != null ) {
                entity.getEquipes().clear();
                entity.getEquipes().addAll( set );
            }
        }
        else {
            Set<Equipe> set = dto.getEquipes();
            if ( set != null ) {
                entity.setEquipes( new HashSet<Equipe>( set ) );
            }
        }
        if ( dto.getActivityName() != null ) {
            entity.setActivityName( dto.getActivityName() );
        }
        if ( dto.getWfProcessID() != null ) {
            entity.setWfProcessID( dto.getWfProcessID() );
        }
        if ( dto.getSecuriteLevel() != null ) {
            entity.setSecuriteLevel( dto.getSecuriteLevel() );
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
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getCreatedBy() != null ) {
            entity.setCreatedBy( dto.getCreatedBy() );
        }
        if ( dto.getCreateAt() != null ) {
            entity.setCreateAt( dto.getCreateAt() );
        }
        if ( dto.getMontantEstime() != null ) {
            entity.setMontantEstime( dto.getMontantEstime() );
        }
        if ( dto.getDemande() != null ) {
            if ( entity.getDemande() == null ) {
                entity.demande( new Demande() );
            }
            demandeDTOToDemande( dto.getDemande(), entity.getDemande() );
        }
    }

    @Override
    public Opportunite toEntity(OpportuniteOutputDTO oppOutputDTO) {
        if ( oppOutputDTO == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

        opportunite.setNomDepartement( oppOutputDTO.getNomDepartement() );
        opportunite.setSidDepartement( oppOutputDTO.getSidDepartement() );
        opportunite.setStatus( oppOutputDTO.getStatus() );
        Set<Equipe> set = oppOutputDTO.getEquipes();
        if ( set != null ) {
            opportunite.setEquipes( new HashSet<Equipe>( set ) );
        }
        opportunite.setActivityName( oppOutputDTO.getActivityName() );
        opportunite.setWfProcessID( oppOutputDTO.getWfProcessID() );
        opportunite.setSecuriteLevel( oppOutputDTO.getSecuriteLevel() );
        opportunite.setAssignee( oppOutputDTO.getAssignee() );
        opportunite.setEndProcess( oppOutputDTO.getEndProcess() );
        opportunite.setId( oppOutputDTO.getId() );
        opportunite.setDescription( oppOutputDTO.getDescription() );
        opportunite.setNom( oppOutputDTO.getNom() );
        opportunite.setCreatedBy( oppOutputDTO.getCreatedBy() );
        opportunite.setCreateAt( oppOutputDTO.getCreateAt() );
        opportunite.setMontantEstime( oppOutputDTO.getMontantEstime() );
        opportunite.demande( demandeDTOToDemande1( oppOutputDTO.getDemande() ) );

        return opportunite;
    }

    @Override
    public OpportuniteOutputDTO toDto(Opportunite opp) {
        if ( opp == null ) {
            return null;
        }

        OpportuniteOutputDTO opportuniteOutputDTO = new OpportuniteOutputDTO();

        opportuniteOutputDTO.setNomDepartement( opp.getNomDepartement() );
        opportuniteOutputDTO.setSidDepartement( opp.getSidDepartement() );
        Set<Equipe> set = opp.getEquipes();
        if ( set != null ) {
            opportuniteOutputDTO.setEquipes( new HashSet<Equipe>( set ) );
        }
        opportuniteOutputDTO.setId( opp.getId() );
        opportuniteOutputDTO.setDescription( opp.getDescription() );
        opportuniteOutputDTO.setNom( opp.getNom() );
        opportuniteOutputDTO.setCreatedBy( opp.getCreatedBy() );
        opportuniteOutputDTO.setCreateAt( opp.getCreateAt() );
        opportuniteOutputDTO.setMontantEstime( opp.getMontantEstime() );
        opportuniteOutputDTO.setDemande( demandeToDemandeDTO( opp.getDemande() ) );
        opportuniteOutputDTO.setActivityName( opp.getActivityName() );
        opportuniteOutputDTO.setEndProcess( opp.getEndProcess() );
        opportuniteOutputDTO.setWfProcessID( opp.getWfProcessID() );
        opportuniteOutputDTO.setAssignee( opp.getAssignee() );
        opportuniteOutputDTO.setStatus( opp.getStatus() );
        opportuniteOutputDTO.setSecuriteLevel( opp.getSecuriteLevel() );

        return opportuniteOutputDTO;
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

    protected void demandeDTOToDemande(DemandeDTO demandeDTO, Demande mappingTarget) {
        if ( demandeDTO == null ) {
            return;
        }

        mappingTarget.setCreateOpp( demandeDTO.isCreateOpp() );
        if ( demandeDTO.getSource() != null ) {
            mappingTarget.setSource( demandeDTO.getSource() );
        }
        if ( demandeDTO.getCommentaires() != null ) {
            mappingTarget.setCommentaires( demandeDTO.getCommentaires() );
        }
        if ( demandeDTO.getDeadline() != null ) {
            mappingTarget.setDeadline( demandeDTO.getDeadline() );
        }
        if ( demandeDTO.getAssignee() != null ) {
            mappingTarget.setAssignee( demandeDTO.getAssignee() );
        }
        if ( demandeDTO.getEndProcess() != null ) {
            mappingTarget.setEndProcess( demandeDTO.getEndProcess() );
        }
        if ( demandeDTO.getId() != null ) {
            mappingTarget.setId( demandeDTO.getId() );
        }
        if ( demandeDTO.getStatus() != null ) {
            mappingTarget.setStatus( demandeDTO.getStatus() );
        }
        if ( demandeDTO.getActivityName() != null ) {
            mappingTarget.setActivityName( demandeDTO.getActivityName() );
        }
        if ( demandeDTO.getSecuriteLevel() != null ) {
            mappingTarget.setSecuriteLevel( demandeDTO.getSecuriteLevel() );
        }
        if ( demandeDTO.getWfProcessID() != null ) {
            mappingTarget.setWfProcessID( demandeDTO.getWfProcessID() );
        }
        if ( demandeDTO.getStatutDemande() != null ) {
            mappingTarget.setStatutDemande( demandeDTO.getStatutDemande() );
        }
        if ( demandeDTO.getDescription() != null ) {
            mappingTarget.setDescription( demandeDTO.getDescription() );
        }
        if ( demandeDTO.getNom() != null ) {
            mappingTarget.setNom( demandeDTO.getNom() );
        }
        if ( demandeDTO.getDateDeCreation() != null ) {
            mappingTarget.setDateDeCreation( demandeDTO.getDateDeCreation() );
        }
        if ( demandeDTO.getStatut() != null ) {
            mappingTarget.setStatut( demandeDTO.getStatut() );
        }
        if ( mappingTarget.getDomaines() != null ) {
            Set<Domaine> set = demandeDTO.getDomaines();
            if ( set != null ) {
                mappingTarget.getDomaines().clear();
                mappingTarget.getDomaines().addAll( set );
            }
        }
        else {
            Set<Domaine> set = demandeDTO.getDomaines();
            if ( set != null ) {
                mappingTarget.domaines( new HashSet<Domaine>( set ) );
            }
        }
        if ( demandeDTO.getClient() != null ) {
            if ( mappingTarget.getClient() == null ) {
                mappingTarget.client( new Client() );
            }
            clientDTOToClient( demandeDTO.getClient(), mappingTarget.getClient() );
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

    protected Demande demandeDTOToDemande1(DemandeDTO demandeDTO) {
        if ( demandeDTO == null ) {
            return null;
        }

        Demande demande = new Demande();

        demande.setCreateOpp( demandeDTO.isCreateOpp() );
        demande.setSource( demandeDTO.getSource() );
        demande.setCommentaires( demandeDTO.getCommentaires() );
        demande.setDeadline( demandeDTO.getDeadline() );
        demande.setAssignee( demandeDTO.getAssignee() );
        demande.setEndProcess( demandeDTO.getEndProcess() );
        demande.setId( demandeDTO.getId() );
        demande.setStatus( demandeDTO.getStatus() );
        demande.setActivityName( demandeDTO.getActivityName() );
        demande.setSecuriteLevel( demandeDTO.getSecuriteLevel() );
        demande.setWfProcessID( demandeDTO.getWfProcessID() );
        demande.setStatutDemande( demandeDTO.getStatutDemande() );
        demande.setDescription( demandeDTO.getDescription() );
        demande.setNom( demandeDTO.getNom() );
        demande.setDateDeCreation( demandeDTO.getDateDeCreation() );
        demande.setStatut( demandeDTO.getStatut() );
        Set<Domaine> set = demandeDTO.getDomaines();
        if ( set != null ) {
            demande.domaines( new HashSet<Domaine>( set ) );
        }
        demande.client( clientDTOToClient1( demandeDTO.getClient() ) );

        return demande;
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

    protected DemandeDTO demandeToDemandeDTO(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeDTO demandeDTO = new DemandeDTO();

        demandeDTO.setCreateOpp( demande.isCreateOpp() );
        demandeDTO.setDeadline( demande.getDeadline() );
        demandeDTO.setSource( demande.getSource() );
        demandeDTO.setCommentaires( demande.getCommentaires() );
        demandeDTO.setWfProcessID( demande.getWfProcessID() );
        demandeDTO.setActivityName( demande.getActivityName() );
        demandeDTO.setEndProcess( demande.getEndProcess() );
        demandeDTO.setAssignee( demande.getAssignee() );
        demandeDTO.setStatus( demande.getStatus() );
        demandeDTO.setSecuriteLevel( demande.getSecuriteLevel() );
        demandeDTO.setId( demande.getId() );
        demandeDTO.setStatutDemande( demande.getStatutDemande() );
        demandeDTO.setDescription( demande.getDescription() );
        demandeDTO.setNom( demande.getNom() );
        demandeDTO.setDateDeCreation( demande.getDateDeCreation() );
        demandeDTO.setStatut( demande.getStatut() );
        Set<Domaine> set = demande.getDomaines();
        if ( set != null ) {
            demandeDTO.setDomaines( new HashSet<Domaine>( set ) );
        }
        demandeDTO.setClient( clientToClientDTO( demande.getClient() ) );

        return demandeDTO;
    }
}
