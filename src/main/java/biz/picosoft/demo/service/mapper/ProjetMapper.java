package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.ProjetDTO;

import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Projet} and its DTO {@link ProjetDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProjetMapper extends EntityMapper<ProjetDTO, Projet> {}
