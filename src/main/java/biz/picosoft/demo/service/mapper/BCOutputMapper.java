package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.BCOutputDTO;
import biz.picosoft.demo.service.dto.DemandeOutputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class BCOutputMapper implements EntityMapper<BCOutputDTO, BonDeCommande>{

    public abstract BonDeCommande toEntity(BCOutputDTO BCOutputDTO);
    public abstract BCOutputDTO toDto(BonDeCommande bc);

    BonDeCommande fromId(Long id) {
        if (id == null) {
            return null;
        }
        BonDeCommande requestCase = new BonDeCommande();
        requestCase.setId(id);
        return requestCase;
    }
}
