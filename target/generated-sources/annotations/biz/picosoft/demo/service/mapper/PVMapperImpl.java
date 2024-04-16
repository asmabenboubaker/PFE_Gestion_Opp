package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T13:06:12+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PVMapperImpl implements PVMapper {

    @Override
    public PV toEntity(PVDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PV pV = new PV();

        pV.setId( dto.getId() );
        if ( dto.getDatePV() != null ) {
            pV.setDatePV( dto.getDatePV().toInstant() );
        }
        pV.setContenu( dto.getContenu() );
        pV.setParticipants( dto.getParticipants() );
        pV.setStatut( dto.getStatut() );
        pV.projet( projetDTOToProjet( dto.getProjet() ) );

        return pV;
    }

    @Override
    public List<PV> toEntity(List<PVDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PV> list = new ArrayList<PV>( dtoList.size() );
        for ( PVDTO pVDTO : dtoList ) {
            list.add( toEntity( pVDTO ) );
        }

        return list;
    }

    @Override
    public List<PVDTO> toDto(List<PV> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PVDTO> list = new ArrayList<PVDTO>( entityList.size() );
        for ( PV pV : entityList ) {
            list.add( toDto( pV ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(PV entity, PVDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getDatePV() != null ) {
            entity.setDatePV( dto.getDatePV().toInstant() );
        }
        if ( dto.getContenu() != null ) {
            entity.setContenu( dto.getContenu() );
        }
        if ( dto.getParticipants() != null ) {
            entity.setParticipants( dto.getParticipants() );
        }
        if ( dto.getStatut() != null ) {
            entity.setStatut( dto.getStatut() );
        }
        if ( dto.getProjet() != null ) {
            if ( entity.getProjet() == null ) {
                entity.projet( new Projet() );
            }
            projetDTOToProjet1( dto.getProjet(), entity.getProjet() );
        }
    }

    @Override
    public PVDTO toDto(PV s) {
        if ( s == null ) {
            return null;
        }

        PVDTO pVDTO = new PVDTO();

        pVDTO.setProjet( toDtoProjetId( s.getProjet() ) );
        pVDTO.setId( s.getId() );
        if ( s.getDatePV() != null ) {
            pVDTO.setDatePV( Date.from( s.getDatePV() ) );
        }
        pVDTO.setContenu( s.getContenu() );
        pVDTO.setParticipants( s.getParticipants() );
        pVDTO.setStatut( s.getStatut() );

        return pVDTO;
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
