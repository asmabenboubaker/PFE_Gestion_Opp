package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.OffreInputDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class OffreInputMapper implements EntityMapper<OffreInputDTO, Offre>{
    public abstract Demande toEntity(DemandeInputDTO demandeInputDTO);
    public abstract DemandeInputDTO toDto(Demande demande);
}
