package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.ProjetDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T11:56:32+0200",
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

        projet.setBudget( dto.getBudget() );
        projet.setObjectif( dto.getObjectif() );
        projet.setLieu( dto.getLieu() );
        projet.setType( dto.getType() );
        projet.setPriorite( dto.getPriorite() );
        projet.setCommentaires( dto.getCommentaires() );
        projet.setDerniereMiseAJour( dto.getDerniereMiseAJour() );
        projet.setLienJira( dto.getLienJira() );
        projet.setIdJira( dto.getIdJira() );
        projet.setId( dto.getId() );
        projet.setNom( dto.getNom() );
        projet.setDateDebut( dto.getDateDebut() );
        projet.setDateFin( dto.getDateFin() );
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

        projetDTO.setBudget( entity.getBudget() );
        projetDTO.setObjectif( entity.getObjectif() );
        projetDTO.setLieu( entity.getLieu() );
        projetDTO.setType( entity.getType() );
        projetDTO.setPriorite( entity.getPriorite() );
        projetDTO.setCommentaires( entity.getCommentaires() );
        projetDTO.setDerniereMiseAJour( entity.getDerniereMiseAJour() );
        projetDTO.setLienJira( entity.getLienJira() );
        projetDTO.setIdJira( entity.getIdJira() );
        projetDTO.setId( entity.getId() );
        projetDTO.setNom( entity.getNom() );
        projetDTO.setDateDebut( entity.getDateDebut() );
        projetDTO.setDateFin( entity.getDateFin() );
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

        entity.setBudget( dto.getBudget() );
        if ( dto.getObjectif() != null ) {
            entity.setObjectif( dto.getObjectif() );
        }
        if ( dto.getLieu() != null ) {
            entity.setLieu( dto.getLieu() );
        }
        if ( dto.getType() != null ) {
            entity.setType( dto.getType() );
        }
        entity.setPriorite( dto.getPriorite() );
        if ( dto.getCommentaires() != null ) {
            entity.setCommentaires( dto.getCommentaires() );
        }
        if ( dto.getDerniereMiseAJour() != null ) {
            entity.setDerniereMiseAJour( dto.getDerniereMiseAJour() );
        }
        if ( dto.getLienJira() != null ) {
            entity.setLienJira( dto.getLienJira() );
        }
        if ( dto.getIdJira() != null ) {
            entity.setIdJira( dto.getIdJira() );
        }
        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getNom() != null ) {
            entity.setNom( dto.getNom() );
        }
        if ( dto.getDateDebut() != null ) {
            entity.setDateDebut( dto.getDateDebut() );
        }
        if ( dto.getDateFin() != null ) {
            entity.setDateFin( dto.getDateFin() );
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
