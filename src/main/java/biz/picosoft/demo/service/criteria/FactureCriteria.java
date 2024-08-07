package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Facture} entity. This class is used
 * in {@link biz.picosoft.demo.controller.FactureResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /factures?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class FactureCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter dateFacture;

    private StringFilter description;

    private StringFilter serviceFournis;

    private LongFilter pvId;

    private Boolean distinct;

    public FactureCriteria() {}

    public FactureCriteria(FactureCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.dateFacture = other.dateFacture == null ? null : other.dateFacture.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.serviceFournis = other.serviceFournis == null ? null : other.serviceFournis.copy();
        this.pvId = other.pvId == null ? null : other.pvId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public FactureCriteria copy() {
        return new FactureCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public InstantFilter getDateFacture() {
        return dateFacture;
    }

    public InstantFilter dateFacture() {
        if (dateFacture == null) {
            dateFacture = new InstantFilter();
        }
        return dateFacture;
    }

    public void setDateFacture(InstantFilter dateFacture) {
        this.dateFacture = dateFacture;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getServiceFournis() {
        return serviceFournis;
    }

    public StringFilter serviceFournis() {
        if (serviceFournis == null) {
            serviceFournis = new StringFilter();
        }
        return serviceFournis;
    }

    public void setServiceFournis(StringFilter serviceFournis) {
        this.serviceFournis = serviceFournis;
    }

    public LongFilter getPvId() {
        return pvId;
    }

    public LongFilter pvId() {
        if (pvId == null) {
            pvId = new LongFilter();
        }
        return pvId;
    }

    public void setPvId(LongFilter pvId) {
        this.pvId = pvId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FactureCriteria that = (FactureCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(dateFacture, that.dateFacture) &&
            Objects.equals(description, that.description) &&
            Objects.equals(serviceFournis, that.serviceFournis) &&
            Objects.equals(pvId, that.pvId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateFacture, description, serviceFournis, pvId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FactureCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (dateFacture != null ? "dateFacture=" + dateFacture + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (serviceFournis != null ? "serviceFournis=" + serviceFournis + ", " : "") +
            (pvId != null ? "pvId=" + pvId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
