package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-14T13:59:03+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class OpportuniteMapperImpl implements OpportuniteMapper {

    @Override
    public Opportunite toEntity(OpportuniteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

        opportunite.setNomDepartement( dto.getNomDepartement() );
        opportunite.setSidDepartement( dto.getSidDepartement() );
        Set<Equipe> set = dto.getEquipes();
        if ( set != null ) {
            opportunite.setEquipes( new HashSet<Equipe>( set ) );
        }
        Set<EtudeOpp> set1 = dto.getEtudeOpps();
        if ( set1 != null ) {
            opportunite.setEtudeOpps( new HashSet<EtudeOpp>( set1 ) );
        }
        opportunite.setId( dto.getId() );
        opportunite.setDescription( dto.getDescription() );
        opportunite.setNom( dto.getNom() );
        opportunite.setCreatedBy( dto.getCreatedBy() );
        opportunite.setCreateAt( dto.getCreateAt() );
        opportunite.setMontantEstime( dto.getMontantEstime() );
        opportunite.demande( demandeDTOToDemande( dto.getDemande() ) );

        return opportunite;
    }

    @Override
    public List<Opportunite> toEntity(List<OpportuniteDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Opportunite> list = new ArrayList<Opportunite>( dtoList.size() );
        for ( OpportuniteDTO opportuniteDTO : dtoList ) {
            list.add( toEntity( opportuniteDTO ) );
        }

        return list;
    }

    @Override
    public List<OpportuniteDTO> toDto(List<Opportunite> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OpportuniteDTO> list = new ArrayList<OpportuniteDTO>( entityList.size() );
        for ( Opportunite opportunite : entityList ) {
            list.add( toDto( opportunite ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Opportunite entity, OpportuniteDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getNomDepartement() != null ) {
            entity.setNomDepartement( dto.getNomDepartement() );
        }
        if ( dto.getSidDepartement() != null ) {
            entity.setSidDepartement( dto.getSidDepartement() );
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
        if ( entity.getEtudeOpps() != null ) {
            Set<EtudeOpp> set1 = dto.getEtudeOpps();
            if ( set1 != null ) {
                entity.getEtudeOpps().clear();
                entity.getEtudeOpps().addAll( set1 );
            }
        }
        else {
            Set<EtudeOpp> set1 = dto.getEtudeOpps();
            if ( set1 != null ) {
                entity.setEtudeOpps( new HashSet<EtudeOpp>( set1 ) );
            }
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
            demandeDTOToDemande1( dto.getDemande(), entity.getDemande() );
        }
    }

    @Override
    public OpportuniteDTO toDto(Opportunite s) {
        if ( s == null ) {
            return null;
        }

        OpportuniteDTO opportuniteDTO = new OpportuniteDTO();

        opportuniteDTO.setDemande( toDtoDemandeId( s.getDemande() ) );
        Set<Equipe> set = s.getEquipes();
        if ( set != null ) {
            opportuniteDTO.setEquipes( new HashSet<Equipe>( set ) );
        }
        Set<EtudeOpp> set1 = s.getEtudeOpps();
        if ( set1 != null ) {
            opportuniteDTO.setEtudeOpps( new HashSet<EtudeOpp>( set1 ) );
        }
        opportuniteDTO.setNomDepartement( s.getNomDepartement() );
        opportuniteDTO.setSidDepartement( s.getSidDepartement() );
        opportuniteDTO.setId( s.getId() );
        opportuniteDTO.setDescription( s.getDescription() );
        opportuniteDTO.setNom( s.getNom() );
        opportuniteDTO.setCreatedBy( s.getCreatedBy() );
        opportuniteDTO.setCreateAt( s.getCreateAt() );
        opportuniteDTO.setMontantEstime( s.getMontantEstime() );

        return opportuniteDTO;
    }

    @Override
    public DemandeDTO toDtoDemandeId(Demande demande) {
        if ( demande == null ) {
            return null;
        }

        DemandeDTO demandeDTO = new DemandeDTO();

        demandeDTO.setId( demande.getId() );

        return demandeDTO;
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
}
