package biz.picosoft.demo.service.mapper;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.dto.OffreDTO;
import biz.picosoft.demo.service.dto.ProjetDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link biz.picosoft.demo.domain.BonDeCommande} and its DTO {@link biz.picosoft.demo.service.dto.BonDeCommandeDTO}.
 */
@Mapper(componentModel = "spring")
public interface BonDeCommandeMapper extends EntityMapper<BonDeCommandeDTO, BonDeCommande> {
    @Mapping(target = "offre", source = "offre", qualifiedByName = "offreId")
    @Mapping(target = "projet", source = "projet", qualifiedByName = "projetId")
    BonDeCommandeDTO toDto(BonDeCommande s);

    @Named("offreId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OffreDTO toDtoOffreId(Offre offre);

    @Named("projetId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProjetDTO toDtoProjetId(Projet projet);
}
