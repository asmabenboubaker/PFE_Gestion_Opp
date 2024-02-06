package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Facture_;
import biz.picosoft.demo.domain.PV;

import biz.picosoft.demo.domain.PV_;
import biz.picosoft.demo.domain.Projet_;
import biz.picosoft.demo.repository.PVRepository;
import biz.picosoft.demo.service.criteria.PVCriteria;
import biz.picosoft.demo.service.dto.PVDTO;
import biz.picosoft.demo.service.mapper.PVMapper;
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
 * Service for executing complex queries for {@link PV} entities in the database.
 * The main input is a {@link PVCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PVDTO} or a {@link Page} of {@link PVDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PVQueryService extends QueryService<PV> {

    private final Logger log = LoggerFactory.getLogger(PVQueryService.class);

    private final PVRepository pVRepository;

    private final PVMapper pVMapper;

    public PVQueryService(PVRepository pVRepository, PVMapper pVMapper) {
        this.pVRepository = pVRepository;
        this.pVMapper = pVMapper;
    }

    /**
     * Return a {@link List} of {@link PVDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PVDTO> findByCriteria(PVCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<PV> specification = createSpecification(criteria);
        return pVMapper.toDto(pVRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PVDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PVDTO> findByCriteria(PVCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<PV> specification = createSpecification(criteria);
        return pVRepository.findAll(specification, page).map(pVMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PVCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<PV> specification = createSpecification(criteria);
        return pVRepository.count(specification);
    }

    /**
     * Function to convert {@link PVCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PV> createSpecification(PVCriteria criteria) {
        Specification<PV> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), PV_.id));
            }
            if (criteria.getDatePV() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDatePV(), PV_.datePV));
            }
            if (criteria.getContenu() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContenu(), PV_.contenu));
            }
            if (criteria.getParticipants() != null) {
                specification = specification.and(buildStringSpecification(criteria.getParticipants(), PV_.participants));
            }

            if (criteria.getFactureId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getFactureId(), root -> root.join(PV_.factures, JoinType.LEFT).get(Facture_.id))
                    );
            }
            if (criteria.getProjetId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProjetId(), root -> root.join(PV_.projet, JoinType.LEFT).get(Projet_.id))
                    );
            }
        }
        return specification;
    }
}
