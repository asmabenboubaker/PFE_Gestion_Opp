package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.ProjetDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-07T15:17:25+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Override
    public Projet toEntity(ProjetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Projet projet = new Projet();

        projet.setId( dto.getId() );
        projet.setNom( dto.getNom() );
        if ( dto.getDateDebut() != null ) {
            projet.setDateDebut( dto.getDateDebut().toInstant() );
        }
        if ( dto.getDateFin() != null ) {
            projet.setDateFin( dto.getDateFin().toInstant() );
        }
        projet.setResponsable( dto.getResponsable() );
        projet.setDescription( dto.getDescription() );
        projet.setParticipants( dto.getParticipants() );

        return projet;
    }

    @Override
    public ProjetDTO toDto(Projet entity) {
        if ( entity == null ) {
            return null;
        }

        ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setId( entity.getId() );
        projetDTO.setNom( entity.getNom() );
        if ( entity.getDateDebut() != null ) {
            projetDTO.setDateDebut( Date.from( entity.getDateDebut() ) );
        }
        if ( entity.getDateFin() != null ) {
            projetDTO.setDateFin( Date.from( entity.getDateFin() ) );
        }
        projetDTO.setResponsable( entity.getResponsable() );
        projetDTO.setDescription( entity.getDescription() );
        projetDTO.setParticipants( entity.getParticipants() );

        return projetDTO;
    }

    @Override
    public List<Projet> toEntity(List<ProjetDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Projet> list = new ArrayList<Projet>( dtoList.size() );
        for ( ProjetDTO projetDTO : dtoList ) {
            list.add( toEntity( projetDTO ) );
        }

        return list;
    }

    @Override
    public List<ProjetDTO> toDto(List<Projet> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProjetDTO> list = new ArrayList<ProjetDTO>( entityList.size() );
        for ( Projet projet : entityList ) {
            list.add( toDto( projet ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Projet entity, ProjetDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getDateDebut() != null ) {
            entity.setDateDebut( dto.getDateDebut().toInstant() );
        }
        if ( dto.getDateFin() != null ) {
            entity.setDateFin( dto.getDateFin().toInstant() );
        }
        if ( dto.getResponsable() != null ) {
            entity.setResponsable( dto.getResponsable() );
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getParticipants() != null ) {
            entity.setParticipants( dto.getParticipants() );
        }
    }
}
