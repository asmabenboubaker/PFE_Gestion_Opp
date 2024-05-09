package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.DomaineDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T22:48:22+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DomaineMapperImpl implements DomaineMapper {

    @Override
    public Domaine toEntity(DomaineDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Domaine domaine = new Domaine();

        domaine.setId( dto.getId() );
        domaine.setNom( dto.getNom() );
        domaine.setDescription( dto.getDescription() );

        return domaine;
    }

    @Override
    public DomaineDTO toDto(Domaine entity) {
        if ( entity == null ) {
            return null;
        }

        DomaineDTO domaineDTO = new DomaineDTO();

        domaineDTO.setId( entity.getId() );
        domaineDTO.setNom( entity.getNom() );
        domaineDTO.setDescription( entity.getDescription() );

        return domaineDTO;
    }

    @Override
    public List<Domaine> toEntity(List<DomaineDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Domaine> list = new ArrayList<Domaine>( dtoList.size() );
        for ( DomaineDTO domaineDTO : dtoList ) {
            list.add( toEntity( domaineDTO ) );
        }

        return list;
    }

    @Override
    public List<DomaineDTO> toDto(List<Domaine> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DomaineDTO> list = new ArrayList<DomaineDTO>( entityList.size() );
        for ( Domaine domaine : entityList ) {
            list.add( toDto( domaine ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Domaine entity, DomaineDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
    }
}
