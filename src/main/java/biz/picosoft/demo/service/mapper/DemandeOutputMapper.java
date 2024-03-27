package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class DemandeOutputMapper  implements EntityMapper<DemandeOutputDTO, Demande> {
    public abstract Demande toEntity(DemandeOutputDTO demandeOutputDTO);
    public abstract DemandeOutputDTO toDto(Demande demande);

    Demande fromId(Long id) {
        if (id == null) {
            return null;
        }
        Demande requestCase = new Demande();
        requestCase.setId(id);
        return requestCase;
    }
}
