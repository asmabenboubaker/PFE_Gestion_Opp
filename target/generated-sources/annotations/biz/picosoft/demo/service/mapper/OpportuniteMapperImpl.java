package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T14:34:05+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OpportuniteMapperImpl implements OpportuniteMapper {

    @Override
    public Opportunite toEntity(OpportuniteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Opportunite opportunite = new Opportunite();

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
}
