package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link biz.picosoft.demo.domain.PV} and its DTO {@link biz.picosoft.demo.service.dto.PVDTO}.
 */
@Mapper(componentModel = "spring")
public interface PVMapper extends EntityMapper<PVDTO, PV> {
    @Mapping(target = "projet", source = "projet", qualifiedByName = "projetId")
    PVDTO toDto(PV s);

    @Named("projetId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProjetDTO toDtoProjetId(Projet projet);
}
