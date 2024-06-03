package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.Client;
import biz.picosoft.demo.domain.Demande;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.service.dto.ClientDTO;
import biz.picosoft.demo.service.dto.DemandeDTO;

import biz.picosoft.demo.service.dto.DomaineDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity {@link Demande} and its DTO {@link DemandeDTO}.
 */
@Mapper(componentModel = "spring")
public interface DemandeMapper extends EntityMapper<DemandeDTO, Demande> {

    @Mapping(target = "client", source = "client", qualifiedByName = "clientId")
    DemandeDTO toDto(Demande s);


    Demande toEntity(DemandeDTO demandeDTO);

    @Named("domaineId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DomaineDTO toDtoDomaineId(Domaine domaine);

    @Named("domaineIdSet")
    default Set<DomaineDTO> toDtoDomaineIdSet(Set<Domaine> domaine) {
        return domaine.stream().map(this::toDtoDomaineId).collect(Collectors.toSet());
    }

    @Named("clientId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ClientDTO toDtoClientId(Client client);
}
