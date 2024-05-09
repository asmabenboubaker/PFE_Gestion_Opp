package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.FactureDTO;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T22:48:24+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class FactureMapperImpl implements FactureMapper {

    @Override
    public Facture toEntity(FactureDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Facture facture = new Facture();

        facture.setId( dto.getId() );
        facture.setDateFacture( dto.getDateFacture() );
        facture.setDescription( dto.getDescription() );
        facture.setServiceFournis( dto.getServiceFournis() );
        facture.pv( pVDTOToPV( dto.getPv() ) );

        return facture;
    }

    @Override
    public List<Facture> toEntity(List<FactureDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Facture> list = new ArrayList<Facture>( dtoList.size() );
        for ( FactureDTO factureDTO : dtoList ) {
            list.add( toEntity( factureDTO ) );
        }

        return list;
    }

    @Override
    public List<FactureDTO> toDto(List<Facture> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FactureDTO> list = new ArrayList<FactureDTO>( entityList.size() );
        for ( Facture facture : entityList ) {
            list.add( toDto( facture ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Facture entity, FactureDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getDateFacture() != null ) {
            entity.setDateFacture( dto.getDateFacture() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getServiceFournis() != null ) {
            entity.setServiceFournis( dto.getServiceFournis() );
        }
        if ( dto.getPv() != null ) {
            if ( entity.getPv() == null ) {
                entity.pv( new PV() );
            }
            pVDTOToPV1( dto.getPv(), entity.getPv() );
        }
    }

    @Override
    public FactureDTO toDto(Facture s) {
        if ( s == null ) {
            return null;
        }

        FactureDTO factureDTO = new FactureDTO();

        factureDTO.setPv( toDtoPVId( s.getPv() ) );
        factureDTO.setId( s.getId() );
        factureDTO.setDateFacture( s.getDateFacture() );
        factureDTO.setDescription( s.getDescription() );
        factureDTO.setServiceFournis( s.getServiceFournis() );

        return factureDTO;
    }

    @Override
    public PVDTO toDtoPVId(PV pV) {
        if ( pV == null ) {
            return null;
        }

        PVDTO pVDTO = new PVDTO();

        pVDTO.setId( pV.getId() );

        return pVDTO;
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

    protected PV pVDTOToPV(PVDTO pVDTO) {
        if ( pVDTO == null ) {
            return null;
        }

        PV pV = new PV();

        pV.setId( pVDTO.getId() );
        if ( pVDTO.getDatePV() != null ) {
            pV.setDatePV( pVDTO.getDatePV().toInstant() );
        }
        pV.setContenu( pVDTO.getContenu() );
        pV.setParticipants( pVDTO.getParticipants() );
        pV.setStatut( pVDTO.getStatut() );
        pV.projet( projetDTOToProjet( pVDTO.getProjet() ) );

        return pV;
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

    protected void pVDTOToPV1(PVDTO pVDTO, PV mappingTarget) {
        if ( pVDTO == null ) {
            return;
        }

        if ( pVDTO.getId() != null ) {
            mappingTarget.setId( pVDTO.getId() );
        }
        if ( pVDTO.getDatePV() != null ) {
            mappingTarget.setDatePV( pVDTO.getDatePV().toInstant() );
        }
        if ( pVDTO.getContenu() != null ) {
            mappingTarget.setContenu( pVDTO.getContenu() );
        }
        if ( pVDTO.getParticipants() != null ) {
            mappingTarget.setParticipants( pVDTO.getParticipants() );
        }
        if ( pVDTO.getStatut() != null ) {
            mappingTarget.setStatut( pVDTO.getStatut() );
        }
        if ( pVDTO.getProjet() != null ) {
            if ( mappingTarget.getProjet() == null ) {
                mappingTarget.projet( new Projet() );
            }
            projetDTOToProjet1( pVDTO.getProjet(), mappingTarget.getProjet() );
        }
    }
}
