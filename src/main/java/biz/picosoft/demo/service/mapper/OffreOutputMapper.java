package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.service.dto.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {})
public abstract class OffreOutputMapper implements EntityMapper<OffreOutputDTO, Offre>{
    public abstract Offre toEntity(OffreOutputDTO oofreOutputDTO);
    public abstract OffreOutputDTO toDto(Offre offre);

    Offre fromId(Long id) {
        if (id == null) {
            return null;
        }
        Offre requestCase = new Offre();
        requestCase.setId(id);
        return requestCase;
    }
}
