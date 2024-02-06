package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Demande_;
import biz.picosoft.demo.domain.Offre_;
import biz.picosoft.demo.domain.Opportunite;
import biz.picosoft.demo.domain.Opportunite_;
import biz.picosoft.demo.repository.OpportuniteRepository;
import biz.picosoft.demo.service.criteria.OpportuniteCriteria;
import biz.picosoft.demo.service.dto.OpportuniteDTO;
import biz.picosoft.demo.service.mapper.OpportuniteMapper;

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
 * Service for executing complex queries for {@link Opportunite} entities in the database.
 * The main input is a {@link OpportuniteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link OpportuniteDTO} or a {@link Page} of {@link OpportuniteDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class OpportuniteQueryService extends QueryService<Opportunite> {

    private final Logger log = LoggerFactory.getLogger(OpportuniteQueryService.class);

    private final OpportuniteRepository opportuniteRepository;

    private final OpportuniteMapper opportuniteMapper;

    public OpportuniteQueryService(OpportuniteRepository opportuniteRepository, OpportuniteMapper opportuniteMapper) {
        this.opportuniteRepository = opportuniteRepository;
        this.opportuniteMapper = opportuniteMapper;
    }

    /**
     * Return a {@link List} of {@link OpportuniteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<OpportuniteDTO> findByCriteria(OpportuniteCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Opportunite> specification = createSpecification(criteria);
        return opportuniteMapper.toDto(opportuniteRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link OpportuniteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<OpportuniteDTO> findByCriteria(OpportuniteCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Opportunite> specification = createSpecification(criteria);
        return opportuniteRepository.findAll(specification, page).map(opportuniteMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(OpportuniteCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Opportunite> specification = createSpecification(criteria);
        return opportuniteRepository.count(specification);
    }

    /**
     * Function to convert {@link OpportuniteCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Opportunite> createSpecification(OpportuniteCriteria criteria) {
        Specification<Opportunite> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Opportunite_.id));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Opportunite_.description));
            }
            if (criteria.getNom() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNom(), Opportunite_.nom));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), Opportunite_.createdBy));
            }
            if (criteria.getCreateAt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreateAt(), Opportunite_.createAt));
            }
            if (criteria.getMontantEstime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMontantEstime(), Opportunite_.montantEstime));
            }
            if (criteria.getOffreId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getOffreId(), root -> root.join(Opportunite_.offres, JoinType.LEFT).get(Offre_.id))
                    );
            }
            if (criteria.getDemandeId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getDemandeId(), root -> root.join(Opportunite_.demande, JoinType.LEFT).get(Demande_.id))
                    );
            }
        }
        return specification;
    }
}
