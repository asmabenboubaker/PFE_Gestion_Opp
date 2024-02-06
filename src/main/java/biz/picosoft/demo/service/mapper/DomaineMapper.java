package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.DomaineDTO;

import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Domaine} and its DTO {@link DomaineDTO}.
 */
@Mapper(componentModel = "spring")
public interface DomaineMapper extends EntityMapper<DomaineDTO, Domaine> {}
