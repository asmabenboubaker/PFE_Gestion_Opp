package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.service.dto.DemandeInputDTO;
import biz.picosoft.demo.service.dto.OpportuniteInputDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public abstract class OpportuniteInputMapper implements EntityMapper<OpportuniteInputDTO, Opportunite> {

    public abstract Opportunite toEntity(OpportuniteInputDTO oppInputDTO);

    public abstract OpportuniteInputDTO toDto(Opportunite opp);


}
