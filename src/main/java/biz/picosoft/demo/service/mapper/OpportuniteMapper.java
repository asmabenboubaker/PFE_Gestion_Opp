package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.DemandeDTO;
import biz.picosoft.demo.service.dto.EquipeDTO;
import biz.picosoft.demo.service.dto.OpportuniteDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity {@link Opportunite} and its DTO {@link OpportuniteDTO}.
 */
@Mapper(componentModel = "spring")
public interface OpportuniteMapper extends EntityMapper<OpportuniteDTO, Opportunite> {
    @Mapping(target = "demande", source = "demande", qualifiedByName = "demandeId")
    @Mapping(target = "equipes", source = "equipes")
    OpportuniteDTO toDto(Opportunite s);

    @Named("demandeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DemandeDTO toDtoDemandeId(Demande demande);
    // add equipes

    @Named("equipesToEquipeDTOs")
    default Set<EquipeDTO> equipesToEquipeDTOs(Set<Equipe> equipes) {
        return equipes.stream()
                .map(this::equipeToEquipeDTO)
                .collect(Collectors.toSet());
    }

    default EquipeDTO equipeToEquipeDTO(Equipe equipe) {
        if (equipe == null) {
            return null;
        }
        EquipeDTO equipeDTO = new EquipeDTO();
        // Map the fields from Equipe to EquipeDTO here
        equipeDTO.setId(equipe.getId());
        // Map other fields similarly
        return equipeDTO;
    }

}
