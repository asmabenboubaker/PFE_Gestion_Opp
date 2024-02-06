package biz.picosoft.demo.service;


import biz.picosoft.demo.domain.Facture;
import biz.picosoft.demo.domain.Facture_;
import biz.picosoft.demo.domain.PV_;
import biz.picosoft.demo.repository.FactureRepository;
import biz.picosoft.demo.service.criteria.FactureCriteria;
import biz.picosoft.demo.service.dto.FactureDTO;
import biz.picosoft.demo.service.mapper.FactureMapper;
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
 * Service for executing complex queries for {@link Facture} entities in the database.
 * The main input is a {@link FactureCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FactureDTO} or a {@link Page} of {@link FactureDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FactureQueryService extends QueryService<Facture> {

    private final Logger log = LoggerFactory.getLogger(FactureQueryService.class);

    private final FactureRepository factureRepository;

    private final FactureMapper factureMapper;

    public FactureQueryService(FactureRepository factureRepository, FactureMapper factureMapper) {
        this.factureRepository = factureRepository;
        this.factureMapper = factureMapper;
    }

    /**
     * Return a {@link List} of {@link FactureDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FactureDTO> findByCriteria(FactureCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Facture> specification = createSpecification(criteria);
        return factureMapper.toDto(factureRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link FactureDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<FactureDTO> findByCriteria(FactureCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Facture> specification = createSpecification(criteria);
        return factureRepository.findAll(specification, page).map(factureMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FactureCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Facture> specification = createSpecification(criteria);
        return factureRepository.count(specification);
    }

    /**
     * Function to convert {@link FactureCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Facture> createSpecification(FactureCriteria criteria) {
        Specification<Facture> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Facture_.id));
            }
            if (criteria.getDateFacture() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateFacture(), Facture_.dateFacture));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Facture_.description));
            }
            if (criteria.getServiceFournis() != null) {
                specification = specification.and(buildStringSpecification(criteria.getServiceFournis(), Facture_.serviceFournis));
            }
            if (criteria.getPvId() != null) {
                specification =
                    specification.and(buildSpecification(criteria.getPvId(), root -> root.join(Facture_.pv, JoinType.LEFT).get(PV_.id)));
            }
        }
        return specification;
    }
}
