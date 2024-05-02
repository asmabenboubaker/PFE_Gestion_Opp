package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.BCInputDTO;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class BCInputMapper implements EntityMapper<BCInputDTO, BonDeCommande> {

    public abstract BonDeCommande toEntity(BCInputDTO bcInputDTO);
    public abstract BCInputDTO toDto(BonDeCommande bc);
}
