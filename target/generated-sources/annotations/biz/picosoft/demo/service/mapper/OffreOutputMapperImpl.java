package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.OffreOutputDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T14:16:38+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OffreOutputMapperImpl extends OffreOutputMapper {

    @Override
    public List<Offre> toEntity(List<OffreOutputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Offre> list = new ArrayList<Offre>( dtoList.size() );
        for ( OffreOutputDTO offreOutputDTO : dtoList ) {
            list.add( toEntity( offreOutputDTO ) );
        }

        return list;
    }

    @Override
    public List<OffreOutputDTO> toDto(List<Offre> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OffreOutputDTO> list = new ArrayList<OffreOutputDTO>( entityList.size() );
        for ( Offre offre : entityList ) {
            list.add( toDto( offre ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Offre entity, OffreOutputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( entity.getArticles() != null ) {
            List<Article> list = dto.getArticles();
            if ( list != null ) {
                entity.getArticles().clear();
                entity.getArticles().addAll( list );
            }
        }
        else {
            List<Article> list = dto.getArticles();
            if ( list != null ) {
                entity.setArticles( new ArrayList<Article>( list ) );
            }
        }
        if ( dto.getModePaiement() != null ) {
            entity.setModePaiement( dto.getModePaiement() );
        }
        if ( dto.getDateLivraison() != null ) {
            entity.setDateLivraison( dto.getDateLivraison() );
        }
        if ( dto.getStatutOffre() != null ) {
            entity.setStatutOffre( dto.getStatutOffre() );
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
            opportuniteDTOToOpportunite( dto.getOpportunite(), entity.getOpportunite() );
        }
    }

    @Override
    public Offre toEntity(OffreOutputDTO oofreOutputDTO) {
        if ( oofreOutputDTO == null ) {
            return null;
        }

        Offre offre = new Offre();

        List<Article> list = oofreOutputDTO.getArticles();
        if ( list != null ) {
            offre.setArticles( new ArrayList<Article>( list ) );
        }
        offre.setModePaiement( oofreOutputDTO.getModePaiement() );
        offre.setDateLivraison( oofreOutputDTO.getDateLivraison() );
        offre.setStatutOffre( oofreOutputDTO.getStatutOffre() );
        offre.setActivityName( oofreOutputDTO.getActivityName() );
        offre.setStatus( oofreOutputDTO.getStatus() );
        offre.setWfProcessID( oofreOutputDTO.getWfProcessID() );
        offre.setSecuriteLevel( oofreOutputDTO.getSecuriteLevel() );
        offre.setAssignee( oofreOutputDTO.getAssignee() );
        offre.setEndProcess( oofreOutputDTO.getEndProcess() );
        offre.setId( oofreOutputDTO.getId() );
        offre.setMontant( oofreOutputDTO.getMontant() );
        offre.setDateOffre( oofreOutputDTO.getDateOffre() );
        offre.setDescription( oofreOutputDTO.getDescription() );
        offre.setValideJusquA( oofreOutputDTO.getValideJusquA() );
        offre.opportunite( opportuniteDTOToOpportunite1( oofreOutputDTO.getOpportunite() ) );

        return offre;
    }

    @Override
    public OffreOutputDTO toDto(Offre offre) {
        if ( offre == null ) {
            return null;
        }

        OffreOutputDTO offreOutputDTO = new OffreOutputDTO();

        List<Article> list = offre.getArticles();
        if ( list != null ) {
            offreOutputDTO.setArticles( new ArrayList<Article>( list ) );
        }
        offreOutputDTO.setModePaiement( offre.getModePaiement() );
        offreOutputDTO.setDateLivraison( offre.getDateLivraison() );
        offreOutputDTO.setStatutOffre( offre.getStatutOffre() );
        offreOutputDTO.setActivityName( offre.getActivityName() );
        offreOutputDTO.setEndProcess( offre.getEndProcess() );
        offreOutputDTO.setWfProcessID( offre.getWfProcessID() );
        offreOutputDTO.setAssignee( offre.getAssignee() );
        offreOutputDTO.setStatus( offre.getStatus() );
        offreOutputDTO.setSecuriteLevel( offre.getSecuriteLevel() );
        offreOutputDTO.setId( offre.getId() );
        offreOutputDTO.setMontant( offre.getMontant() );
        offreOutputDTO.setDateOffre( offre.getDateOffre() );
        offreOutputDTO.setDescription( offre.getDescription() );
        offreOutputDTO.setValideJusquA( offre.getValideJusquA() );
        offreOutputDTO.setOpportunite( opportuniteToOpportuniteDTO( offre.getOpportunite() ) );

        return offreOutputDTO;
    }

    protected void clientDTOToClient(ClientDTO clientDTO, Client mappingTarget) {
        if ( clientDTO == null ) {
            return;
        }

        if ( clientDTO.getPays() != null ) {
            mappingTarget.setPays( clientDTO.getPays() );
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

    protected void opportuniteDTOToOpportunite(OpportuniteDTO opportuniteDTO, Opportunite mappingTarget) {
        if ( opportuniteDTO == null ) {
            return;
        }

        if ( opportuniteDTO.getNomDepartement() != null ) {
            mappingTarget.setNomDepartement( opportuniteDTO.getNomDepartement() );
        }
        if ( opportuniteDTO.getSidDepartement() != null ) {
            mappingTarget.setSidDepartement( opportuniteDTO.getSidDepartement() );
        }
        if ( mappingTarget.getEquipes() != null ) {
            Set<Equipe> set = opportuniteDTO.getEquipes();
            if ( set != null ) {
                mappingTarget.getEquipes().clear();
                mappingTarget.getEquipes().addAll( set );
            }
        }
        else {
            Set<Equipe> set = opportuniteDTO.getEquipes();
            if ( set != null ) {
                mappingTarget.setEquipes( new HashSet<Equipe>( set ) );
            }
        }
        if ( mappingTarget.getEtudeOpps() != null ) {
            Set<EtudeOpp> set1 = opportuniteDTO.getEtudeOpps();
            if ( set1 != null ) {
                mappingTarget.getEtudeOpps().clear();
                mappingTarget.getEtudeOpps().addAll( set1 );
            }
        }
        else {
            Set<EtudeOpp> set1 = opportuniteDTO.getEtudeOpps();
            if ( set1 != null ) {
                mappingTarget.setEtudeOpps( new HashSet<EtudeOpp>( set1 ) );
            }
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
            demandeDTOToDemande( opportuniteDTO.getDemande(), mappingTarget.getDemande() );
        }
    }

    protected Client clientDTOToClient1(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setPays( clientDTO.getPays() );
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

    protected Opportunite opportuniteDTOToOpportunite1(OpportuniteDTO opportuniteDTO) {
        if ( opportuniteDTO == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

        opportunite.setNomDepartement( opportuniteDTO.getNomDepartement() );
        opportunite.setSidDepartement( opportuniteDTO.getSidDepartement() );
        Set<Equipe> set = opportuniteDTO.getEquipes();
        if ( set != null ) {
            opportunite.setEquipes( new HashSet<Equipe>( set ) );
        }
        Set<EtudeOpp> set1 = opportuniteDTO.getEtudeOpps();
        if ( set1 != null ) {
            opportunite.setEtudeOpps( new HashSet<EtudeOpp>( set1 ) );
        }
        opportunite.setId( opportuniteDTO.getId() );
        opportunite.setDescription( opportuniteDTO.getDescription() );
        opportunite.setNom( opportuniteDTO.getNom() );
        opportunite.setCreatedBy( opportuniteDTO.getCreatedBy() );
        opportunite.setCreateAt( opportuniteDTO.getCreateAt() );
        opportunite.setMontantEstime( opportuniteDTO.getMontantEstime() );
        opportunite.demande( demandeDTOToDemande1( opportuniteDTO.getDemande() ) );

        return opportunite;
    }

    protected ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setPays( client.getPays() );
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

    protected OpportuniteDTO opportuniteToOpportuniteDTO(Opportunite opportunite) {
        if ( opportunite == null ) {
            return null;
        }

        OpportuniteDTO opportuniteDTO = new OpportuniteDTO();

        Set<EtudeOpp> set = opportunite.getEtudeOpps();
        if ( set != null ) {
            opportuniteDTO.setEtudeOpps( new HashSet<EtudeOpp>( set ) );
        }
        opportuniteDTO.setNomDepartement( opportunite.getNomDepartement() );
        opportuniteDTO.setSidDepartement( opportunite.getSidDepartement() );
        Set<Equipe> set1 = opportunite.getEquipes();
        if ( set1 != null ) {
            opportuniteDTO.setEquipes( new HashSet<Equipe>( set1 ) );
        }
        opportuniteDTO.setId( opportunite.getId() );
        opportuniteDTO.setDescription( opportunite.getDescription() );
        opportuniteDTO.setNom( opportunite.getNom() );
        opportuniteDTO.setCreatedBy( opportunite.getCreatedBy() );
        opportuniteDTO.setCreateAt( opportunite.getCreateAt() );
        opportuniteDTO.setMontantEstime( opportunite.getMontantEstime() );
        opportuniteDTO.setDemande( demandeToDemandeDTO( opportunite.getDemande() ) );

        return opportuniteDTO;
    }
}
