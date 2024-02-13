package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.service.dto.EtudeOppDTO;

import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link EtudeOpp} and its DTO {@link EtudeOppDTO}.
 */
@Mapper(componentModel = "spring")
public interface EtudeOppMapper extends EntityMapper<EtudeOppDTO, EtudeOpp> {}
