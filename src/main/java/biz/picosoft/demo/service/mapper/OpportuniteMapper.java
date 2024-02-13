package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Opportunite} and its DTO {@link OpportuniteDTO}.
 */
@Mapper(componentModel = "spring")
public interface OpportuniteMapper extends EntityMapper<OpportuniteDTO, Opportunite> {
    @Mapping(target = "demande", source = "demande", qualifiedByName = "demandeId")
    OpportuniteDTO toDto(Opportunite s);

    @Named("demandeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DemandeDTO toDtoDemandeId(Demande demande);
}
