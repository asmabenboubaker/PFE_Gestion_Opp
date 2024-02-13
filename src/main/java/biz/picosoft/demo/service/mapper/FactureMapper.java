package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.domain.PV;
import biz.picosoft.demo.service.dto.FactureDTO;
import biz.picosoft.demo.service.dto.PVDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Facture} and its DTO {@link FactureDTO}.
 */
@Mapper(componentModel = "spring")
public interface FactureMapper extends EntityMapper<FactureDTO, Facture> {
    @Mapping(target = "pv", source = "pv", qualifiedByName = "pVId")
    FactureDTO toDto(Facture s);

    @Named("pVId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PVDTO toDtoPVId(PV pV);
}
