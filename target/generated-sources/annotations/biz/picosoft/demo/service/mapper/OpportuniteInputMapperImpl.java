package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.dto.OpportuniteInputDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T11:33:08+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OpportuniteInputMapperImpl extends OpportuniteInputMapper {

    @Override
    public List<Opportunite> toEntity(List<OpportuniteInputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Opportunite> list = new ArrayList<Opportunite>( dtoList.size() );
        for ( OpportuniteInputDTO opportuniteInputDTO : dtoList ) {
            list.add( toEntity( opportuniteInputDTO ) );
        }

        return list;
    }

    @Override
    public List<OpportuniteInputDTO> toDto(List<Opportunite> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OpportuniteInputDTO> list = new ArrayList<OpportuniteInputDTO>( entityList.size() );
        for ( Opportunite opportunite : entityList ) {
            list.add( toDto( opportunite ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Opportunite entity, OpportuniteInputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
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
    public Opportunite toEntity(OpportuniteInputDTO oppInputDTO) {
        if ( oppInputDTO == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

        opportunite.setStatus( oppInputDTO.getStatus() );
        opportunite.setActivityName( oppInputDTO.getActivityName() );
        opportunite.setWfProcessID( oppInputDTO.getWfProcessID() );
        opportunite.setSecuriteLevel( oppInputDTO.getSecuriteLevel() );
        opportunite.setAssignee( oppInputDTO.getAssignee() );
        opportunite.setEndProcess( oppInputDTO.getEndProcess() );
        opportunite.setId( oppInputDTO.getId() );
        opportunite.setDescription( oppInputDTO.getDescription() );
        opportunite.setNom( oppInputDTO.getNom() );
        opportunite.setCreatedBy( oppInputDTO.getCreatedBy() );
        opportunite.setCreateAt( oppInputDTO.getCreateAt() );
        opportunite.setMontantEstime( oppInputDTO.getMontantEstime() );
        opportunite.demande( demandeDTOToDemande1( oppInputDTO.getDemande() ) );

        return opportunite;
    }

    @Override
    public OpportuniteInputDTO toDto(Opportunite opp) {
        if ( opp == null ) {
            return null;
        }

        OpportuniteInputDTO opportuniteInputDTO = new OpportuniteInputDTO();

        opportuniteInputDTO.setId( opp.getId() );
        opportuniteInputDTO.setDescription( opp.getDescription() );
        opportuniteInputDTO.setNom( opp.getNom() );
        opportuniteInputDTO.setCreatedBy( opp.getCreatedBy() );
        opportuniteInputDTO.setCreateAt( opp.getCreateAt() );
        opportuniteInputDTO.setMontantEstime( opp.getMontantEstime() );
        opportuniteInputDTO.setDemande( demandeToDemandeDTO( opp.getDemande() ) );
        opportuniteInputDTO.setActivityName( opp.getActivityName() );
        opportuniteInputDTO.setEndProcess( opp.getEndProcess() );
        opportuniteInputDTO.setWfProcessID( opp.getWfProcessID() );
        opportuniteInputDTO.setAssignee( opp.getAssignee() );
        opportuniteInputDTO.setStatus( opp.getStatus() );
        opportuniteInputDTO.setSecuriteLevel( opp.getSecuriteLevel() );

        return opportuniteInputDTO;
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

    protected void demandeDTOToDemande(DemandeDTO demandeDTO, Demande mappingTarget) {
        if ( demandeDTO == null ) {
            return;
        }

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
            Set<Domaine> set = domaineDTOSetToDomaineSet( demandeDTO.getDomaines() );
            if ( set != null ) {
                mappingTarget.getDomaines().clear();
                mappingTarget.getDomaines().addAll( set );
            }
        }
        else {
            Set<Domaine> set = domaineDTOSetToDomaineSet( demandeDTO.getDomaines() );
            if ( set != null ) {
                mappingTarget.domaines( set );
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
        demande.domaines( domaineDTOSetToDomaineSet( demandeDTO.getDomaines() ) );
        demande.client( clientDTOToClient1( demandeDTO.getClient() ) );

        return demande;
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

    protected DemandeDTO demandeToDemandeDTO(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeDTO demandeDTO = new DemandeDTO();

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
        demandeDTO.setDomaines( domaineSetToDomaineDTOSet( demande.getDomaines() ) );
        demandeDTO.setClient( clientToClientDTO( demande.getClient() ) );

        return demandeDTO;
    }
}
