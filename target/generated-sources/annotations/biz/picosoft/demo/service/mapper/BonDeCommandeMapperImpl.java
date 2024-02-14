package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
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
    date = "2024-02-13T11:17:46+0100",
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

        demande.setId( demandeDTO.getId() );
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

    protected Offre offreDTOToOffre(OffreDTO offreDTO) {
        if ( offreDTO == null ) {
            return null;
        }

        Offre offre = new Offre();

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

        projet.setId( projetDTO.getId() );
        projet.setNom( projetDTO.getNom() );
        if ( projetDTO.getDateDebut() != null ) {
            projet.setDateDebut( projetDTO.getDateDebut().toInstant() );
        }
        if ( projetDTO.getDateFin() != null ) {
            projet.setDateFin( projetDTO.getDateFin().toInstant() );
        }
        projet.setResponsable( projetDTO.getResponsable() );
        projet.setDescription( projetDTO.getDescription() );
        projet.setParticipants( projetDTO.getParticipants() );

        return projet;
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

        if ( demandeDTO.getId() != null ) {
            mappingTarget.setId( demandeDTO.getId() );
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

    protected void offreDTOToOffre1(OffreDTO offreDTO, Offre mappingTarget) {
        if ( offreDTO == null ) {
            return;
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

        if ( projetDTO.getId() != null ) {
            mappingTarget.setId( projetDTO.getId() );
        }
        if ( projetDTO.getNom() != null ) {
            mappingTarget.setNom( projetDTO.getNom() );
        }
        if ( projetDTO.getDateDebut() != null ) {
            mappingTarget.setDateDebut( projetDTO.getDateDebut().toInstant() );
        }
        if ( projetDTO.getDateFin() != null ) {
            mappingTarget.setDateFin( projetDTO.getDateFin().toInstant() );
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
