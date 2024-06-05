package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.EtudeOpp_;
import biz.picosoft.demo.repository.EtudeOppRepository;
import biz.picosoft.demo.service.criteria.EtudeOppCriteria;
import biz.picosoft.demo.service.dto.EtudeOppDTO;
import biz.picosoft.demo.service.mapper.EtudeOppMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import java.util.List;

/**
 * Service for executing complex queries for {@link EtudeOpp} entities in the database.
 * The main input is a {@link EtudeOppCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link EtudeOppDTO} or a {@link Page} of {@link EtudeOppDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EtudeOppQueryService extends QueryService<EtudeOpp> {

    private final Logger log = LoggerFactory.getLogger(EtudeOppQueryService.class);

    private final EtudeOppRepository etudeOppRepository;

    private final EtudeOppMapper etudeOppMapper;

    public EtudeOppQueryService(EtudeOppRepository etudeOppRepository, EtudeOppMapper etudeOppMapper) {
        this.etudeOppRepository = etudeOppRepository;
        this.etudeOppMapper = etudeOppMapper;
    }

    /**
     * Return a {@link List} of {@link EtudeOppDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<EtudeOppDTO> findByCriteria(EtudeOppCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<EtudeOpp> specification = createSpecification(criteria);
        return etudeOppMapper.toDto(etudeOppRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link EtudeOppDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<EtudeOppDTO> findByCriteria(EtudeOppCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<EtudeOpp> specification = createSpecification(criteria);
        return etudeOppRepository.findAll(specification, page).map(etudeOppMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EtudeOppCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<EtudeOpp> specification = createSpecification(criteria);
        return etudeOppRepository.count(specification);
    }

    /**
     * Function to convert {@link EtudeOppCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<EtudeOpp> createSpecification(EtudeOppCriteria criteria) {
        Specification<EtudeOpp> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), EtudeOpp_.id));
            }
            if (criteria.getNature() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNature(), EtudeOpp_.nature));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), EtudeOpp_.description));
            }
            if (criteria.getSpecialite() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSpecialite(), EtudeOpp_.specialite));
            }
            if (criteria.getNbreHours() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNbreHours(), EtudeOpp_.nbreHours));
            }
            if (criteria.getResponsableEtude() != null) {
                specification = specification.and(buildStringSpecification(criteria.getResponsableEtude(), EtudeOpp_.responsableEtude));
            }
            // datedebut
            if (criteria.getDateDebut() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateDebut(), EtudeOpp_.dateDebut));
            }
            if (criteria.getComplexite() != null) {
                specification = specification.and(buildStringSpecification(criteria.getComplexite(), EtudeOpp_.complexite));
            }
        }
        return specification;
    }
}
