package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Demande_;
import biz.picosoft.demo.domain.Domaine;
import biz.picosoft.demo.domain.Domaine_;
import biz.picosoft.demo.repository.DomaineRepository;
import biz.picosoft.demo.service.criteria.DomaineCriteria;
import biz.picosoft.demo.service.dto.DomaineDTO;
import biz.picosoft.demo.service.mapper.DomaineMapper;

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
 * Service for executing complex queries for {@link Domaine} entities in the database.
 * The main input is a {@link DomaineCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link DomaineDTO} or a {@link Page} of {@link DomaineDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class DomaineQueryService extends QueryService<Domaine> {

    private final Logger log = LoggerFactory.getLogger(DomaineQueryService.class);

    private final DomaineRepository domaineRepository;

    private final DomaineMapper domaineMapper;

    public DomaineQueryService(DomaineRepository domaineRepository, DomaineMapper domaineMapper) {
        this.domaineRepository = domaineRepository;
        this.domaineMapper = domaineMapper;
    }

    /**
     * Return a {@link List} of {@link DomaineDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<DomaineDTO> findByCriteria(DomaineCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Domaine> specification = createSpecification(criteria);
        return domaineMapper.toDto(domaineRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link DomaineDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<DomaineDTO> findByCriteria(DomaineCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Domaine> specification = createSpecification(criteria);
        return domaineRepository.findAll(specification, page).map(domaineMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(DomaineCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Domaine> specification = createSpecification(criteria);
        return domaineRepository.count(specification);
    }

    /**
     * Function to convert {@link DomaineCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Domaine> createSpecification(DomaineCriteria criteria) {
        Specification<Domaine> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Domaine_.id));
            }
            if (criteria.getNom() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNom(), Domaine_.nom));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Domaine_.description));
            }
            if (criteria.getDemandeId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getDemandeId(), root -> root.join(Domaine_.demandes, JoinType.LEFT).get(Demande_.id))
                    );
            }
        }
        return specification;
    }
}
