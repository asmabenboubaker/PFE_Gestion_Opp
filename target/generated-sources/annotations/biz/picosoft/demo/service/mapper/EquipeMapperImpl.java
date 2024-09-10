package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.service.dto.EquipeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-10T18:19:15+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class EquipeMapperImpl implements EquipeMapper {

    @Override
    public Equipe toEntity(EquipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Equipe equipe = new Equipe();

        equipe.setId( dto.getId() );
        equipe.setNom( dto.getNom() );
        equipe.setDescription( dto.getDescription() );
        equipe.setChef( dto.getChef() );
        equipe.setEmail( dto.getEmail() );
        equipe.setTelephone( dto.getTelephone() );

        return equipe;
    }

    @Override
    public EquipeDTO toDto(Equipe entity) {
        if ( entity == null ) {
            return null;
        }

        EquipeDTO equipeDTO = new EquipeDTO();

        equipeDTO.setId( entity.getId() );
        equipeDTO.setNom( entity.getNom() );
        equipeDTO.setDescription( entity.getDescription() );
        equipeDTO.setChef( entity.getChef() );
        equipeDTO.setEmail( entity.getEmail() );
        equipeDTO.setTelephone( entity.getTelephone() );

        return equipeDTO;
    }

    @Override
    public List<Equipe> toEntity(List<EquipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Equipe> list = new ArrayList<Equipe>( dtoList.size() );
        for ( EquipeDTO equipeDTO : dtoList ) {
            list.add( toEntity( equipeDTO ) );
        }

        return list;
    }

    @Override
    public List<EquipeDTO> toDto(List<Equipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EquipeDTO> list = new ArrayList<EquipeDTO>( entityList.size() );
        for ( Equipe equipe : entityList ) {
            list.add( toDto( equipe ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Equipe entity, EquipeDTO dto) {
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
        if ( dto.getChef() != null ) {
            entity.setChef( dto.getChef() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getTelephone() != null ) {
            entity.setTelephone( dto.getTelephone() );
        }
    }
}
