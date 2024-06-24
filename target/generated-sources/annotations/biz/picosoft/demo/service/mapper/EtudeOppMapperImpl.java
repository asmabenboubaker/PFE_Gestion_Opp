package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T21:20:49+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class EtudeOppMapperImpl implements EtudeOppMapper {

    @Override
    public EtudeOpp toEntity(EtudeOppDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EtudeOpp etudeOpp = new EtudeOpp();

        etudeOpp.setOpportunite( dto.getOpportunite() );
        etudeOpp.setId( dto.getId() );
        etudeOpp.setSpecialite( dto.getSpecialite() );
        etudeOpp.setNbreHours( dto.getNbreHours() );
        etudeOpp.setComplexite( dto.getComplexite() );
        etudeOpp.setNature( dto.getNature() );
        etudeOpp.setDescription( dto.getDescription() );
        etudeOpp.setResponsableEtude( dto.getResponsableEtude() );
        etudeOpp.setDateDebut( dto.getDateDebut() );

        return etudeOpp;
    }

    @Override
    public EtudeOppDTO toDto(EtudeOpp entity) {
        if ( entity == null ) {
            return null;
        }

        EtudeOppDTO etudeOppDTO = new EtudeOppDTO();

        etudeOppDTO.setId( entity.getId() );
        etudeOppDTO.setNature( entity.getNature() );
        etudeOppDTO.setDescription( entity.getDescription() );
        etudeOppDTO.setSpecialite( entity.getSpecialite() );
        etudeOppDTO.setNbreHours( entity.getNbreHours() );
        etudeOppDTO.setResponsableEtude( entity.getResponsableEtude() );
        etudeOppDTO.setDateDebut( entity.getDateDebut() );
        etudeOppDTO.setComplexite( entity.getComplexite() );
        etudeOppDTO.setOpportunite( entity.getOpportunite() );

        return etudeOppDTO;
    }

    @Override
    public List<EtudeOpp> toEntity(List<EtudeOppDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EtudeOpp> list = new ArrayList<EtudeOpp>( dtoList.size() );
        for ( EtudeOppDTO etudeOppDTO : dtoList ) {
            list.add( toEntity( etudeOppDTO ) );
        }

        return list;
    }

    @Override
    public List<EtudeOppDTO> toDto(List<EtudeOpp> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EtudeOppDTO> list = new ArrayList<EtudeOppDTO>( entityList.size() );
        for ( EtudeOpp etudeOpp : entityList ) {
            list.add( toDto( etudeOpp ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(EtudeOpp entity, EtudeOppDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getOpportunite() != null ) {
            entity.setOpportunite( dto.getOpportunite() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getSpecialite() != null ) {
            entity.setSpecialite( dto.getSpecialite() );
        }
        if ( dto.getNbreHours() != null ) {
            entity.setNbreHours( dto.getNbreHours() );
        }
        if ( dto.getComplexite() != null ) {
            entity.setComplexite( dto.getComplexite() );
        }
        if ( dto.getNature() != null ) {
            entity.setNature( dto.getNature() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getResponsableEtude() != null ) {
            entity.setResponsableEtude( dto.getResponsableEtude() );
        }
        if ( dto.getDateDebut() != null ) {
            entity.setDateDebut( dto.getDateDebut() );
        }
    }
}
