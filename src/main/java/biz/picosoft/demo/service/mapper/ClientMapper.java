package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.service.dto.ClientDTO;

import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {}
