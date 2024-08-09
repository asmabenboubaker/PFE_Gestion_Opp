package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.BCInputDTO;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.OffreDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;
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
public class BCInputMapperImpl extends BCInputMapper {

    @Override
    public List<BonDeCommande> toEntity(List<BCInputDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BonDeCommande> list = new ArrayList<BonDeCommande>( dtoList.size() );
        for ( BCInputDTO bCInputDTO : dtoList ) {
            list.add( toEntity( bCInputDTO ) );
        }

        return list;
    }

    @Override
    public List<BCInputDTO> toDto(List<BonDeCommande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BCInputDTO> list = new ArrayList<BCInputDTO>( entityList.size() );
        for ( BonDeCommande bonDeCommande : entityList ) {
            list.add( toDto( bonDeCommande ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(BonDeCommande entity, BCInputDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getDatedelivraison() != null ) {
            entity.setDatedelivraison( dto.getDatedelivraison() );
        }
        if ( dto.getServicecommande() != null ) {
            entity.setServicecommande( dto.getServicecommande() );
        }
        if ( dto.getMethodedepaiement() != null ) {
            entity.setMethodedepaiement( dto.getMethodedepaiement() );
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
        if ( dto.getAssignee() != null ) {
            entity.setAssignee( dto.getAssignee() );
        }
        if ( dto.getEndProcess() != null ) {
            entity.setEndProcess( dto.getEndProcess() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getMontantTotal() != null ) {
            entity.setMontantTotal( dto.getMontantTotal() );
        }
        if ( dto.getDateCommande() != null ) {
            entity.setDateCommande( dto.getDateCommande() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getStatut() != null ) {
            entity.setStatut( dto.getStatut() );
        }
        if ( dto.getOffre() != null ) {
            if ( entity.getOffre() == null ) {
                entity.offre( new Offre() );
            }
            offreDTOToOffre( dto.getOffre(), entity.getOffre() );
        }
        if ( dto.getProjet() != null ) {
            if ( entity.getProjet() == null ) {
                entity.projet( new Projet() );
            }
            projetDTOToProjet( dto.getProjet(), entity.getProjet() );
        }
    }

    @Override
    public BonDeCommande toEntity(BCInputDTO bcInputDTO) {
        if ( bcInputDTO == null ) {
            return null;
        }

        BonDeCommande bonDeCommande = new BonDeCommande();

        bonDeCommande.setDatedelivraison( bcInputDTO.getDatedelivraison() );
        bonDeCommande.setServicecommande( bcInputDTO.getServicecommande() );
        bonDeCommande.setMethodedepaiement( bcInputDTO.getMethodedepaiement() );
        bonDeCommande.setActivityName( bcInputDTO.getActivityName() );
        bonDeCommande.setStatus( bcInputDTO.getStatus() );
        bonDeCommande.setWfProcessID( bcInputDTO.getWfProcessID() );
        bonDeCommande.setAssignee( bcInputDTO.getAssignee() );
        bonDeCommande.setEndProcess( bcInputDTO.getEndProcess() );
        bonDeCommande.setId( bcInputDTO.getId() );
        bonDeCommande.setMontantTotal( bcInputDTO.getMontantTotal() );
        bonDeCommande.setDateCommande( bcInputDTO.getDateCommande() );
        bonDeCommande.setDescription( bcInputDTO.getDescription() );
        bonDeCommande.setStatut( bcInputDTO.getStatut() );
        bonDeCommande.offre( offreDTOToOffre1( bcInputDTO.getOffre() ) );
        bonDeCommande.projet( projetDTOToProjet1( bcInputDTO.getProjet() ) );

        return bonDeCommande;
    }

    @Override
    public BCInputDTO toDto(BonDeCommande bc) {
        if ( bc == null ) {
            return null;
        }

        BCInputDTO bCInputDTO = new BCInputDTO();

        bCInputDTO.setDatedelivraison( bc.getDatedelivraison() );
        bCInputDTO.setServicecommande( bc.getServicecommande() );
        bCInputDTO.setMethodedepaiement( bc.getMethodedepaiement() );
        bCInputDTO.setActivityName( bc.getActivityName() );
        bCInputDTO.setEndProcess( bc.getEndProcess() );
        bCInputDTO.setWfProcessID( bc.getWfProcessID() );
        bCInputDTO.setAssignee( bc.getAssignee() );
        bCInputDTO.setStatus( bc.getStatus() );
        bCInputDTO.setId( bc.getId() );
        bCInputDTO.setMontantTotal( bc.getMontantTotal() );
        bCInputDTO.setDateCommande( bc.getDateCommande() );
        bCInputDTO.setDescription( bc.getDescription() );
        bCInputDTO.setStatut( bc.getStatut() );
        bCInputDTO.setOffre( offreToOffreDTO( bc.getOffre() ) );
        bCInputDTO.setProjet( projetToProjetDTO( bc.getProjet() ) );

        return bCInputDTO;
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

    protected void offreDTOToOffre(OffreDTO offreDTO, Offre mappingTarget) {
        if ( offreDTO == null ) {
            return;
        }

        if ( mappingTarget.getArticles() != null ) {
            List<Article> list = offreDTO.getArticles();
            if ( list != null ) {
                mappingTarget.getArticles().clear();
                mappingTarget.getArticles().addAll( list );
            }
        }
        else {
            List<Article> list = offreDTO.getArticles();
            if ( list != null ) {
                mappingTarget.setArticles( new ArrayList<Article>( list ) );
            }
        }
        if ( offreDTO.getModePaiement() != null ) {
            mappingTarget.setModePaiement( offreDTO.getModePaiement() );
        }
        if ( offreDTO.getDateLivraison() != null ) {
            mappingTarget.setDateLivraison( offreDTO.getDateLivraison() );
        }
        if ( offreDTO.getStatutOffre() != null ) {
            mappingTarget.setStatutOffre( offreDTO.getStatutOffre() );
        }
        if ( offreDTO.getActivityName() != null ) {
            mappingTarget.setActivityName( offreDTO.getActivityName() );
        }
        if ( offreDTO.getStatus() != null ) {
            mappingTarget.setStatus( offreDTO.getStatus() );
        }
        if ( offreDTO.getWfProcessID() != null ) {
            mappingTarget.setWfProcessID( offreDTO.getWfProcessID() );
        }
        if ( offreDTO.getSecuriteLevel() != null ) {
            mappingTarget.setSecuriteLevel( offreDTO.getSecuriteLevel() );
        }
        if ( offreDTO.getAssignee() != null ) {
            mappingTarget.setAssignee( offreDTO.getAssignee() );
        }
        if ( offreDTO.getEndProcess() != null ) {
            mappingTarget.setEndProcess( offreDTO.getEndProcess() );
        }
        if ( offreDTO.getId() != null ) {
            mappingTarget.setId( offreDTO.getId() );
        }
        if ( offreDTO.getMontant() != null ) {
            mappingTarget.setMontant( offreDTO.getMontant() );
        }
        if ( offreDTO.getDateOffre() != null ) {
            mappingTarget.setDateOffre( offreDTO.getDateOffre() );
        }
        if ( offreDTO.getDescription() != null ) {
            mappingTarget.setDescription( offreDTO.getDescription() );
        }
        if ( offreDTO.getValideJusquA() != null ) {
            mappingTarget.setValideJusquA( offreDTO.getValideJusquA() );
        }
        if ( offreDTO.getOpportunite() != null ) {
            if ( mappingTarget.getOpportunite() == null ) {
                mappingTarget.opportunite( new Opportunite() );
            }
            opportuniteDTOToOpportunite( offreDTO.getOpportunite(), mappingTarget.getOpportunite() );
        }
    }

    protected void projetDTOToProjet(ProjetDTO projetDTO, Projet mappingTarget) {
        if ( projetDTO == null ) {
            return;
        }

        mappingTarget.setBudget( projetDTO.getBudget() );
        if ( projetDTO.getObjectif() != null ) {
            mappingTarget.setObjectif( projetDTO.getObjectif() );
        }
        if ( projetDTO.getLieu() != null ) {
            mappingTarget.setLieu( projetDTO.getLieu() );
        }
        if ( projetDTO.getType() != null ) {
            mappingTarget.setType( projetDTO.getType() );
        }
        mappingTarget.setPriorite( projetDTO.getPriorite() );
        if ( projetDTO.getCommentaires() != null ) {
            mappingTarget.setCommentaires( projetDTO.getCommentaires() );
        }
        if ( projetDTO.getDerniereMiseAJour() != null ) {
            mappingTarget.setDerniereMiseAJour( projetDTO.getDerniereMiseAJour() );
        }
        if ( projetDTO.getLienJira() != null ) {
            mappingTarget.setLienJira( projetDTO.getLienJira() );
        }
        if ( projetDTO.getIdJira() != null ) {
            mappingTarget.setIdJira( projetDTO.getIdJira() );
        }
        if ( projetDTO.getId() != null ) {
            mappingTarget.setId( projetDTO.getId() );
        }
        if ( projetDTO.getNom() != null ) {
            mappingTarget.setNom( projetDTO.getNom() );
        }
        if ( projetDTO.getDateDebut() != null ) {
            mappingTarget.setDateDebut( projetDTO.getDateDebut() );
        }
        if ( projetDTO.getDateFin() != null ) {
            mappingTarget.setDateFin( projetDTO.getDateFin() );
        }
        if ( projetDTO.getResponsable() != null ) {
            mappingTarget.setResponsable( projetDTO.getResponsable() );
        }
        if ( projetDTO.getDescription() != null ) {
            mappingTarget.setDescription( projetDTO.getDescription() );
        }
        if ( projetDTO.getParticipants() != null ) {
            mappingTarget.setParticipants( projetDTO.getParticipants() );
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

    protected Offre offreDTOToOffre1(OffreDTO offreDTO) {
        if ( offreDTO == null ) {
            return null;
        }

        Offre offre = new Offre();

        List<Article> list = offreDTO.getArticles();
        if ( list != null ) {
            offre.setArticles( new ArrayList<Article>( list ) );
        }
        offre.setModePaiement( offreDTO.getModePaiement() );
        offre.setDateLivraison( offreDTO.getDateLivraison() );
        offre.setStatutOffre( offreDTO.getStatutOffre() );
        offre.setActivityName( offreDTO.getActivityName() );
        offre.setStatus( offreDTO.getStatus() );
        offre.setWfProcessID( offreDTO.getWfProcessID() );
        offre.setSecuriteLevel( offreDTO.getSecuriteLevel() );
        offre.setAssignee( offreDTO.getAssignee() );
        offre.setEndProcess( offreDTO.getEndProcess() );
        offre.setId( offreDTO.getId() );
        offre.setMontant( offreDTO.getMontant() );
        offre.setDateOffre( offreDTO.getDateOffre() );
        offre.setDescription( offreDTO.getDescription() );
        offre.setValideJusquA( offreDTO.getValideJusquA() );
        offre.opportunite( opportuniteDTOToOpportunite1( offreDTO.getOpportunite() ) );

        return offre;
    }

    protected Projet projetDTOToProjet1(ProjetDTO projetDTO) {
        if ( projetDTO == null ) {
            return null;
        }

        Projet projet = new Projet();

        projet.setBudget( projetDTO.getBudget() );
        projet.setObjectif( projetDTO.getObjectif() );
        projet.setLieu( projetDTO.getLieu() );
        projet.setType( projetDTO.getType() );
        projet.setPriorite( projetDTO.getPriorite() );
        projet.setCommentaires( projetDTO.getCommentaires() );
        projet.setDerniereMiseAJour( projetDTO.getDerniereMiseAJour() );
        projet.setLienJira( projetDTO.getLienJira() );
        projet.setIdJira( projetDTO.getIdJira() );
        projet.setId( projetDTO.getId() );
        projet.setNom( projetDTO.getNom() );
        projet.setDateDebut( projetDTO.getDateDebut() );
        projet.setDateFin( projetDTO.getDateFin() );
        projet.setResponsable( projetDTO.getResponsable() );
        projet.setDescription( projetDTO.getDescription() );
        projet.setParticipants( projetDTO.getParticipants() );

        return projet;
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

    protected OffreDTO offreToOffreDTO(Offre offre) {
        if ( offre == null ) {
            return null;
        }

        OffreDTO offreDTO = new OffreDTO();

        List<Article> list = offre.getArticles();
        if ( list != null ) {
            offreDTO.setArticles( new ArrayList<Article>( list ) );
        }
        offreDTO.setModePaiement( offre.getModePaiement() );
        offreDTO.setDateLivraison( offre.getDateLivraison() );
        offreDTO.setStatutOffre( offre.getStatutOffre() );
        offreDTO.setActivityName( offre.getActivityName() );
        offreDTO.setEndProcess( offre.getEndProcess() );
        offreDTO.setWfProcessID( offre.getWfProcessID() );
        offreDTO.setAssignee( offre.getAssignee() );
        offreDTO.setStatus( offre.getStatus() );
        offreDTO.setSecuriteLevel( offre.getSecuriteLevel() );
        offreDTO.setId( offre.getId() );
        offreDTO.setMontant( offre.getMontant() );
        offreDTO.setDateOffre( offre.getDateOffre() );
        offreDTO.setDescription( offre.getDescription() );
        offreDTO.setValideJusquA( offre.getValideJusquA() );
        offreDTO.setOpportunite( opportuniteToOpportuniteDTO( offre.getOpportunite() ) );

        return offreDTO;
    }

    protected ProjetDTO projetToProjetDTO(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setBudget( projet.getBudget() );
        projetDTO.setObjectif( projet.getObjectif() );
        projetDTO.setLieu( projet.getLieu() );
        projetDTO.setType( projet.getType() );
        projetDTO.setPriorite( projet.getPriorite() );
        projetDTO.setCommentaires( projet.getCommentaires() );
        projetDTO.setDerniereMiseAJour( projet.getDerniereMiseAJour() );
        projetDTO.setLienJira( projet.getLienJira() );
        projetDTO.setIdJira( projet.getIdJira() );
        projetDTO.setId( projet.getId() );
        projetDTO.setNom( projet.getNom() );
        projetDTO.setDateDebut( projet.getDateDebut() );
        projetDTO.setDateFin( projet.getDateFin() );
        projetDTO.setResponsable( projet.getResponsable() );
        projetDTO.setDescription( projet.getDescription() );
        projetDTO.setParticipants( projet.getParticipants() );

        return projetDTO;
    }
}
