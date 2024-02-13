package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Offre} entity. This class is used
 * in {@link biz.picosoft.demo.controller.OffreResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /offres?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class OffreCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private FloatFilter montant;

    private InstantFilter dateOffre;

    private StringFilter description;

    private InstantFilter valideJusquA;

    private LongFilter bondecommandeId;

    private LongFilter opportuniteId;

    private Boolean distinct;

    public OffreCriteria() {}

    public OffreCriteria(OffreCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.montant = other.montant == null ? null : other.montant.copy();
        this.dateOffre = other.dateOffre == null ? null : other.dateOffre.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.valideJusquA = other.valideJusquA == null ? null : other.valideJusquA.copy();
        this.bondecommandeId = other.bondecommandeId == null ? null : other.bondecommandeId.copy();
        this.opportuniteId = other.opportuniteId == null ? null : other.opportuniteId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public OffreCriteria copy() {
        return new OffreCriteria(this);
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

    public FloatFilter getMontant() {
        return montant;
    }

    public FloatFilter montant() {
        if (montant == null) {
            montant = new FloatFilter();
        }
        return montant;
    }

    public void setMontant(FloatFilter montant) {
        this.montant = montant;
    }

    public InstantFilter getDateOffre() {
        return dateOffre;
    }

    public InstantFilter dateOffre() {
        if (dateOffre == null) {
            dateOffre = new InstantFilter();
        }
        return dateOffre;
    }

    public void setDateOffre(InstantFilter dateOffre) {
        this.dateOffre = dateOffre;
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

    public InstantFilter getValideJusquA() {
        return valideJusquA;
    }

    public InstantFilter valideJusquA() {
        if (valideJusquA == null) {
            valideJusquA = new InstantFilter();
        }
        return valideJusquA;
    }

    public void setValideJusquA(InstantFilter valideJusquA) {
        this.valideJusquA = valideJusquA;
    }

    public LongFilter getBondecommandeId() {
        return bondecommandeId;
    }

    public LongFilter bondecommandeId() {
        if (bondecommandeId == null) {
            bondecommandeId = new LongFilter();
        }
        return bondecommandeId;
    }

    public void setBondecommandeId(LongFilter bondecommandeId) {
        this.bondecommandeId = bondecommandeId;
    }

    public LongFilter getOpportuniteId() {
        return opportuniteId;
    }

    public LongFilter opportuniteId() {
        if (opportuniteId == null) {
            opportuniteId = new LongFilter();
        }
        return opportuniteId;
    }

    public void setOpportuniteId(LongFilter opportuniteId) {
        this.opportuniteId = opportuniteId;
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
        final OffreCriteria that = (OffreCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(montant, that.montant) &&
            Objects.equals(dateOffre, that.dateOffre) &&
            Objects.equals(description, that.description) &&
            Objects.equals(valideJusquA, that.valideJusquA) &&
            Objects.equals(bondecommandeId, that.bondecommandeId) &&
            Objects.equals(opportuniteId, that.opportuniteId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant, dateOffre, description, valideJusquA, bondecommandeId, opportuniteId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OffreCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (montant != null ? "montant=" + montant + ", " : "") +
            (dateOffre != null ? "dateOffre=" + dateOffre + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (valideJusquA != null ? "valideJusquA=" + valideJusquA + ", " : "") +
            (bondecommandeId != null ? "bondecommandeId=" + bondecommandeId + ", " : "") +
            (opportuniteId != null ? "opportuniteId=" + opportuniteId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
