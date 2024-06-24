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
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
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
    date = "2024-06-24T21:20:49+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BonDeCommandeMapperImpl implements BonDeCommandeMapper {

    @Override
    public BonDeCommande toEntity(BonDeCommandeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BonDeCommande bonDeCommande = new BonDeCommande();

        bonDeCommande.setDatedelivraison( dto.getDatedelivraison() );
        bonDeCommande.setServicecommande( dto.getServicecommande() );
        bonDeCommande.setMethodedepaiement( dto.getMethodedepaiement() );
        bonDeCommande.setActivityName( dto.getActivityName() );
        bonDeCommande.setStatus( dto.getStatus() );
        bonDeCommande.setWfProcessID( dto.getWfProcessID() );
        bonDeCommande.setAssignee( dto.getAssignee() );
        bonDeCommande.setEndProcess( dto.getEndProcess() );
        bonDeCommande.setId( dto.getId() );
        bonDeCommande.setMontantTotal( dto.getMontantTotal() );
        bonDeCommande.setDateCommande( dto.getDateCommande() );
        bonDeCommande.setDescription( dto.getDescription() );
        bonDeCommande.setStatut( dto.getStatut() );
        bonDeCommande.offre( offreDTOToOffre( dto.getOffre() ) );
        bonDeCommande.projet( projetDTOToProjet( dto.getProjet() ) );

        return bonDeCommande;
    }

    @Override
    public List<BonDeCommande> toEntity(List<BonDeCommandeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BonDeCommande> list = new ArrayList<BonDeCommande>( dtoList.size() );
        for ( BonDeCommandeDTO bonDeCommandeDTO : dtoList ) {
            list.add( toEntity( bonDeCommandeDTO ) );
        }

        return list;
    }

    @Override
    public List<BonDeCommandeDTO> toDto(List<BonDeCommande> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BonDeCommandeDTO> list = new ArrayList<BonDeCommandeDTO>( entityList.size() );
        for ( BonDeCommande bonDeCommande : entityList ) {
            list.add( toDto( bonDeCommande ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(BonDeCommande entity, BonDeCommandeDTO dto) {
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
            offreDTOToOffre1( dto.getOffre(), entity.getOffre() );
        }
        if ( dto.getProjet() != null ) {
            if ( entity.getProjet() == null ) {
                entity.projet( new Projet() );
            }
            projetDTOToProjet1( dto.getProjet(), entity.getProjet() );
        }
    }

    @Override
    public BonDeCommandeDTO toDto(BonDeCommande s) {
        if ( s == null ) {
            return null;
        }

        BonDeCommandeDTO bonDeCommandeDTO = new BonDeCommandeDTO();

        bonDeCommandeDTO.setOffre( toDtoOffreId( s.getOffre() ) );
        bonDeCommandeDTO.setProjet( toDtoProjetId( s.getProjet() ) );
        bonDeCommandeDTO.setDatedelivraison( s.getDatedelivraison() );
        bonDeCommandeDTO.setServicecommande( s.getServicecommande() );
        bonDeCommandeDTO.setMethodedepaiement( s.getMethodedepaiement() );
        bonDeCommandeDTO.setActivityName( s.getActivityName() );
        bonDeCommandeDTO.setEndProcess( s.getEndProcess() );
        bonDeCommandeDTO.setWfProcessID( s.getWfProcessID() );
        bonDeCommandeDTO.setAssignee( s.getAssignee() );
        bonDeCommandeDTO.setStatus( s.getStatus() );
        bonDeCommandeDTO.setId( s.getId() );
        bonDeCommandeDTO.setMontantTotal( s.getMontantTotal() );
        bonDeCommandeDTO.setDateCommande( s.getDateCommande() );
        bonDeCommandeDTO.setDescription( s.getDescription() );
        bonDeCommandeDTO.setStatut( s.getStatut() );

        return bonDeCommandeDTO;
    }

    @Override
    public OffreDTO toDtoOffreId(Offre offre) {
        if ( offre == null ) {
            return null;
        }

        OffreDTO offreDTO = new OffreDTO();

        offreDTO.setId( offre.getId() );

        return offreDTO;
    }

    @Override
    public ProjetDTO toDtoProjetId(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setId( projet.getId() );

        return projetDTO;
    }

    protected Client clientDTOToClient(ClientDTO clientDTO) {
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

    protected Demande demandeDTOToDemande(DemandeDTO demandeDTO) {
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
        demande.client( clientDTOToClient( demandeDTO.getClient() ) );

        return demande;
    }

    protected Opportunite opportuniteDTOToOpportunite(OpportuniteDTO opportuniteDTO) {
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
        opportunite.demande( demandeDTOToDemande( opportuniteDTO.getDemande() ) );

        return opportunite;
    }

    protected Offre offreDTOToOffre(OffreDTO offreDTO) {
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
        offre.opportunite( opportuniteDTOToOpportunite( offreDTO.getOpportunite() ) );

        return offre;
    }

    protected Projet projetDTOToProjet(ProjetDTO projetDTO) {
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

    protected void clientDTOToClient1(ClientDTO clientDTO, Client mappingTarget) {
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

    protected void demandeDTOToDemande1(DemandeDTO demandeDTO, Demande mappingTarget) {
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
            clientDTOToClient1( demandeDTO.getClient(), mappingTarget.getClient() );
        }
    }

    protected void opportuniteDTOToOpportunite1(OpportuniteDTO opportuniteDTO, Opportunite mappingTarget) {
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
            demandeDTOToDemande1( opportuniteDTO.getDemande(), mappingTarget.getDemande() );
        }
    }

    protected void offreDTOToOffre1(OffreDTO offreDTO, Offre mappingTarget) {
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
            opportuniteDTOToOpportunite1( offreDTO.getOpportunite(), mappingTarget.getOpportunite() );
        }
    }

    protected void projetDTOToProjet1(ProjetDTO projetDTO, Projet mappingTarget) {
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
}
