package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.OffreDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Offre} and its DTO {@link OffreDTO}.
 */
@Mapper(componentModel = "spring")
public interface OffreMapper extends EntityMapper<OffreDTO, Offre> {
    @Mapping(target = "opportunite", source = "opportunite", qualifiedByName = "opportuniteId")
    OffreDTO toDto(Offre s);

    @Named("opportuniteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OpportuniteDTO toDtoOpportuniteId(Opportunite opportunite);
}
