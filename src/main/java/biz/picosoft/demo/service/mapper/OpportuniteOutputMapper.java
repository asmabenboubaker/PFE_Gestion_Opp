package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import biz.picosoft.demo.service.dto.EquipeDTO;
import biz.picosoft.demo.service.dto.OpportuniteOutputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {})
public abstract class OpportuniteOutputMapper implements EntityMapper<OpportuniteOutputDTO, Opportunite> {


    public abstract Opportunite toEntity(OpportuniteOutputDTO oppOutputDTO);

    public abstract OpportuniteOutputDTO toDto(Opportunite opp);

    Opportunite fromId(Long id) {
        if (id == null) {
            return null;
        }
        Opportunite requestCase = new Opportunite();
        requestCase.setId(id);
        return requestCase;
    }
}
