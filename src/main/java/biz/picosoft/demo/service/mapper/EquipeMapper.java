package biz.picosoft.demo.service.mapper;


import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.service.dto.EquipeDTO;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipeMapper extends EntityMapper<EquipeDTO, Equipe>{
}
