package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

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

    private LocalDateFilter dateFacture;

    private StringFilter description;
    private BooleanFilter isPaid;

    public BooleanFilter getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(BooleanFilter isPaid) {
        this.isPaid = isPaid;
    }

    private StringFilter serviceFournis;

    private LongFilter pvId;

    private Boolean distinct;

    public FactureCriteria() {}

    public FactureCriteria(FactureCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.dateFacture = other.dateFacture == null ? null : other.dateFacture.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.serviceFournis = other.serviceFournis == null ? null : other.serviceFournis.copy();
        // ispaid
        this.isPaid = other.isPaid == null ? null : other.isPaid.copy();
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

    public LocalDateFilter getDateFacture() {
        return dateFacture;
    }

    public LocalDateFilter dateFacture() {
        if (dateFacture == null) {
            dateFacture = new LocalDateFilter();
        }
        return dateFacture;
    }

    public void setDateFacture(LocalDateFilter dateFacture) {
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
                    //ispaid
            Objects.equals(isPaid, that.isPaid) &&
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
                //ispaid
            (isPaid != null ? "isPaid=" + isPaid + ", " : "") +
            (pvId != null ? "pvId=" + pvId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
