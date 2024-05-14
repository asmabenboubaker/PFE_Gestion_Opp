package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T16:14:39+0200",
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

        etudeOpp.setId( dto.getId() );
        etudeOpp.setNomEquipe( dto.getNomEquipe() );
        etudeOpp.setMembres( dto.getMembres() );
        etudeOpp.setSpecialite( dto.getSpecialite() );
        etudeOpp.setNbreHours( dto.getNbreHours() );
        etudeOpp.setEvaluation( dto.getEvaluation() );
        etudeOpp.setComplexite( dto.getComplexite() );

        return etudeOpp;
    }

    @Override
    public EtudeOppDTO toDto(EtudeOpp entity) {
        if ( entity == null ) {
            return null;
        }

        EtudeOppDTO etudeOppDTO = new EtudeOppDTO();

        etudeOppDTO.setId( entity.getId() );
        etudeOppDTO.setNomEquipe( entity.getNomEquipe() );
        etudeOppDTO.setMembres( entity.getMembres() );
        etudeOppDTO.setSpecialite( entity.getSpecialite() );
        etudeOppDTO.setNbreHours( entity.getNbreHours() );
        etudeOppDTO.setEvaluation( entity.getEvaluation() );
        etudeOppDTO.setComplexite( entity.getComplexite() );

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

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNomEquipe() != null ) {
            entity.setNomEquipe( dto.getNomEquipe() );
        }
        if ( dto.getMembres() != null ) {
            entity.setMembres( dto.getMembres() );
        }
        if ( dto.getSpecialite() != null ) {
            entity.setSpecialite( dto.getSpecialite() );
        }
        if ( dto.getNbreHours() != null ) {
            entity.setNbreHours( dto.getNbreHours() );
        }
        if ( dto.getEvaluation() != null ) {
            entity.setEvaluation( dto.getEvaluation() );
        }
        if ( dto.getComplexite() != null ) {
            entity.setComplexite( dto.getComplexite() );
        }
    }
}
