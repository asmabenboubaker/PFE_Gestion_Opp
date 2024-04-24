package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.dto.OffreInputDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-23T23:56:14+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OffreInputMapperImpl extends OffreInputMapper {

    @Override
    public Offre toEntity(OffreInputDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Offre offre = new Offre();

        offre.setActivityName( dto.getActivityName() );
        offre.setStatus( dto.getStatus() );
        offre.setWfProcessID( dto.getWfProcessID() );
        offre.setSecuriteLevel( dto.getSecuriteLevel() );
        offre.setAssignee( dto.getAssignee() );
        offre.setEndProcess( dto.getEndProcess() );
        offre.setId( dto.getId() );
        offre.setMontant( dto.getMontant() );
        offre.setDateOffre( dto.getDateOffre() );
        offre.setDescription( dto.getDescription() );
        offre.setValideJusquA( dto.getValideJusquA() );
        offre.opportunite( opportuniteDTOToOpportunite( dto.getOpportunite() ) );

        return offre;
    }

    @Override
    public OffreInputDTO toDto(Offre entity) {
        if ( entity == null ) {
            return null;
        }

        OffreInputDTO offreInputDTO = new OffreInputDTO();

        offreInputDTO.setActivityName( entity.getActivityName() );
        offreInputDTO.setEndProcess( entity.getEndProcess() );
        offreInputDTO.setWfProcessID( entity.getWfProcessID() );
        offreInputDTO.setAssignee( entity.getAssignee() );
        offreInputDTO.setStatus( entity.getStatus() );
        offreInputDTO.setSecuriteLevel( entity.getSecuriteLevel() );
        offreInputDTO.setId( entity.getId() );
        offreInputDTO.setMontant( entity.getMontant() );
        offreInputDTO.setDateOffre( entity.getDateOffre() );
        offreInputDTO.setDescription( entity.getDescription() );
        offreInputDTO.setValideJusquA( entity.getValideJusquA() );
        offreInputDTO.setOpportunite( opportuniteToOpportuniteDTO( entity.getOpportunite() ) );

        return offreInputDTO;
    }

    @Override
    public List<Offre> toEntity(List<OffreInputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Offre> list = new ArrayList<Offre>( dtoList.size() );
        for ( OffreInputDTO offreInputDTO : dtoList ) {
            list.add( toEntity( offreInputDTO ) );
        }

        return list;
    }

    @Override
    public List<OffreInputDTO> toDto(List<Offre> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OffreInputDTO> list = new ArrayList<OffreInputDTO>( entityList.size() );
        for ( Offre offre : entityList ) {
            list.add( toDto( offre ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Offre entity, OffreInputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getActivityName() != null ) {
            entity.setActivityName( dto.getActivityName() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
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
        if ( dto.getMontant() != null ) {
            entity.setMontant( dto.getMontant() );
        }
        if ( dto.getDateOffre() != null ) {
            entity.setDateOffre( dto.getDateOffre() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getValideJusquA() != null ) {
            entity.setValideJusquA( dto.getValideJusquA() );
        }
        if ( dto.getOpportunite() != null ) {
            if ( entity.getOpportunite() == null ) {
                entity.opportunite( new Opportunite() );
            }
            opportuniteDTOToOpportunite1( dto.getOpportunite(), entity.getOpportunite() );
        }
    }

    @Override
    public Demande toEntity(DemandeInputDTO demandeInputDTO) {
        if ( demandeInputDTO == null ) {
            return null;
        }

        Demande demande = new Demande();

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
        demande.domaines( domaineDTOSetToDomaineSet( demandeInputDTO.getDomaines() ) );
        demande.client( clientDTOToClient( demandeInputDTO.getClient() ) );

        return demande;
    }

    @Override
    public DemandeInputDTO toDto(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeInputDTO demandeInputDTO = new DemandeInputDTO();

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

    protected Client clientDTOToClient(ClientDTO clientDTO) {
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

    protected Demande demandeDTOToDemande(DemandeDTO demandeDTO) {
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
        demande.client( clientDTOToClient( demandeDTO.getClient() ) );

        return demande;
    }

    protected Opportunite opportuniteDTOToOpportunite(OpportuniteDTO opportuniteDTO) {
        if ( opportuniteDTO == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

        opportunite.setId( opportuniteDTO.getId() );
        opportunite.setDescription( opportuniteDTO.getDescription() );
        opportunite.setNom( opportuniteDTO.getNom() );
        opportunite.setCreatedBy( opportuniteDTO.getCreatedBy() );
        opportunite.setCreateAt( opportuniteDTO.getCreateAt() );
        opportunite.setMontantEstime( opportuniteDTO.getMontantEstime() );
        opportunite.demande( demandeDTOToDemande( opportuniteDTO.getDemande() ) );

        return opportunite;
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

    protected OpportuniteDTO opportuniteToOpportuniteDTO(Opportunite opportunite) {
        if ( opportunite == null ) {
            return null;
        }

        OpportuniteDTO opportuniteDTO = new OpportuniteDTO();

        opportuniteDTO.setId( opportunite.getId() );
        opportuniteDTO.setDescription( opportunite.getDescription() );
        opportuniteDTO.setNom( opportunite.getNom() );
        opportuniteDTO.setCreatedBy( opportunite.getCreatedBy() );
        opportuniteDTO.setCreateAt( opportunite.getCreateAt() );
        opportuniteDTO.setMontantEstime( opportunite.getMontantEstime() );
        opportuniteDTO.setDemande( demandeToDemandeDTO( opportunite.getDemande() ) );

        return opportuniteDTO;
    }

    protected void clientDTOToClient1(ClientDTO clientDTO, Client mappingTarget) {
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

    protected void demandeDTOToDemande1(DemandeDTO demandeDTO, Demande mappingTarget) {
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
            clientDTOToClient1( demandeDTO.getClient(), mappingTarget.getClient() );
        }
    }

    protected void opportuniteDTOToOpportunite1(OpportuniteDTO opportuniteDTO, Opportunite mappingTarget) {
        if ( opportuniteDTO == null ) {
            return;
        }

        if ( opportuniteDTO.getId() != null ) {
            mappingTarget.setId( opportuniteDTO.getId() );
        }
        if ( opportuniteDTO.getDescription() != null ) {
            mappingTarget.setDescription( opportuniteDTO.getDescription() );
        }
        if ( opportuniteDTO.getNom() != null ) {
            mappingTarget.setNom( opportuniteDTO.getNom() );
        }
        if ( opportuniteDTO.getCreatedBy() != null ) {
            mappingTarget.setCreatedBy( opportuniteDTO.getCreatedBy() );
        }
        if ( opportuniteDTO.getCreateAt() != null ) {
            mappingTarget.setCreateAt( opportuniteDTO.getCreateAt() );
        }
        if ( opportuniteDTO.getMontantEstime() != null ) {
            mappingTarget.setMontantEstime( opportuniteDTO.getMontantEstime() );
        }
        if ( opportuniteDTO.getDemande() != null ) {
            if ( mappingTarget.getDemande() == null ) {
                mappingTarget.demande( new Demande() );
            }
            demandeDTOToDemande1( opportuniteDTO.getDemande(), mappingTarget.getDemande() );
        }
    }
}