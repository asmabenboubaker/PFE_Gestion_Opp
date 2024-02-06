package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.BonDeCommande;
import biz.picosoft.demo.domain.BonDeCommande_;
import biz.picosoft.demo.domain.Offre_;
import biz.picosoft.demo.domain.Projet_;
import biz.picosoft.demo.repository.BonDeCommandeRepository;
import biz.picosoft.demo.service.criteria.BonDeCommandeCriteria;
import biz.picosoft.demo.service.dto.BonDeCommandeDTO;
import biz.picosoft.demo.service.mapper.BonDeCommandeMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import javax.persistence.criteria.JoinType;
import java.util.List;

/**
 * Service for executing complex queries for {@link BonDeCommande} entities in the database.
 * The main input is a {@link biz.picosoft.demo.service.criteria.BonDeCommandeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link biz.picosoft.demo.service.dto.BonDeCommandeDTO} or a {@link Page} of {@link biz.picosoft.demo.service.dto.BonDeCommandeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BonDeCommandeQueryService extends QueryService<BonDeCommande> {

    private final Logger log = LoggerFactory.getLogger(BonDeCommandeQueryService.class);

    private final BonDeCommandeRepository bonDeCommandeRepository;

    private final BonDeCommandeMapper bonDeCommandeMapper;

    public BonDeCommandeQueryService(BonDeCommandeRepository bonDeCommandeRepository, BonDeCommandeMapper bonDeCommandeMapper) {
        this.bonDeCommandeRepository = bonDeCommandeRepository;
        this.bonDeCommandeMapper = bonDeCommandeMapper;
    }

    /**
     * Return a {@link List} of {@link biz.picosoft.demo.service.dto.BonDeCommandeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BonDeCommandeDTO> findByCriteria(BonDeCommandeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BonDeCommande> specification = createSpecification(criteria);
        return bonDeCommandeMapper.toDto(bonDeCommandeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BonDeCommandeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BonDeCommandeDTO> findByCriteria(BonDeCommandeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BonDeCommande> specification = createSpecification(criteria);
        return bonDeCommandeRepository.findAll(specification, page).map(bonDeCommandeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BonDeCommandeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<BonDeCommande> specification = createSpecification(criteria);
        return bonDeCommandeRepository.count(specification);
    }

    /**
     * Function to convert {@link BonDeCommandeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BonDeCommande> createSpecification(BonDeCommandeCriteria criteria) {
        Specification<BonDeCommande> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), BonDeCommande_.id));
            }
            if (criteria.getMontantTotal() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMontantTotal(), BonDeCommande_.montantTotal));
            }
            if (criteria.getDateCommande() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateCommande(), BonDeCommande_.dateCommande));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), BonDeCommande_.description));
            }

            if (criteria.getOffreId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getOffreId(), root -> root.join(BonDeCommande_.offre, JoinType.LEFT).get(Offre_.id))
                    );
            }
            if (criteria.getProjetId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProjetId(), root -> root.join(BonDeCommande_.projet, JoinType.LEFT).get(Projet_.id))
                    );
            }
        }
        return specification;
    }
}
