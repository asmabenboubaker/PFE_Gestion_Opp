package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public abstract class DemandeInputMapper implements EntityMapper<DemandeInputDTO, Demande>{

    public abstract Demande toEntity(DemandeInputDTO demandeInputDTO);


    public abstract DemandeInputDTO toDto(Demande demande);

}
