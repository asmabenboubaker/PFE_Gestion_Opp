package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.DemandeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Demande} and its DTO {@link DemandeDTO}.
 */
@Named("demandeMap")
@Mapper(componentModel = "spring", uses = {})
public abstract class DemandeMap implements EntityMapper<DemandeDTO, Demande>{
    public abstract  DemandeDTO toDto(Demande demande);

    public abstract  Demande toEntity(DemandeDTO demandeDTO);

}
