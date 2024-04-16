package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Opportunite} entity. This class is used
 * in {@link biz.picosoft.demo.controller.OpportuniteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /opportunites?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class OpportuniteCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter description;

    private StringFilter nom;

    private ZonedDateTimeFilter createdBy;

    private ZonedDateTimeFilter createAt;

    private FloatFilter montantEstime;

    private LongFilter offreId;

    private LongFilter demandeId;

    private Boolean distinct;

    public OpportuniteCriteria() {}

    public OpportuniteCriteria(OpportuniteCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.nom = other.nom == null ? null : other.nom.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createAt = other.createAt == null ? null : other.createAt.copy();
        this.montantEstime = other.montantEstime == null ? null : other.montantEstime.copy();
        this.offreId = other.offreId == null ? null : other.offreId.copy();
        this.demandeId = other.demandeId == null ? null : other.demandeId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public OpportuniteCriteria copy() {
        return new OpportuniteCriteria(this);
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

    public StringFilter getNom() {
        return nom;
    }

    public StringFilter nom() {
        if (nom == null) {
            nom = new StringFilter();
        }
        return nom;
    }

    public void setNom(StringFilter nom) {
        this.nom = nom;
    }

    public ZonedDateTimeFilter getCreatedBy() {
        return createdBy;
    }

    public ZonedDateTimeFilter createdBy() {
        if (createdBy == null) {
            createdBy = new ZonedDateTimeFilter();
        }
        return createdBy;
    }

    public void setCreatedBy(ZonedDateTimeFilter createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTimeFilter getCreateAt() {
        return createAt;
    }

    public ZonedDateTimeFilter createAt() {
        if (createAt == null) {
            createAt = new ZonedDateTimeFilter();
        }
        return createAt;
    }

    public void setCreateAt(ZonedDateTimeFilter createAt) {
        this.createAt = createAt;
    }

    public FloatFilter getMontantEstime() {
        return montantEstime;
    }

    public FloatFilter montantEstime() {
        if (montantEstime == null) {
            montantEstime = new FloatFilter();
        }
        return montantEstime;
    }

    public void setMontantEstime(FloatFilter montantEstime) {
        this.montantEstime = montantEstime;
    }

    public LongFilter getOffreId() {
        return offreId;
    }

    public LongFilter offreId() {
        if (offreId == null) {
            offreId = new LongFilter();
        }
        return offreId;
    }

    public void setOffreId(LongFilter offreId) {
        this.offreId = offreId;
    }

    public LongFilter getDemandeId() {
        return demandeId;
    }

    public LongFilter demandeId() {
        if (demandeId == null) {
            demandeId = new LongFilter();
        }
        return demandeId;
    }

    public void setDemandeId(LongFilter demandeId) {
        this.demandeId = demandeId;
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
        final OpportuniteCriteria that = (OpportuniteCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(description, that.description) &&
            Objects.equals(nom, that.nom) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createAt, that.createAt) &&
            Objects.equals(montantEstime, that.montantEstime) &&
            Objects.equals(offreId, that.offreId) &&
            Objects.equals(demandeId, that.demandeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, nom, createdBy, createAt, montantEstime, offreId, demandeId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OpportuniteCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (nom != null ? "nom=" + nom + ", " : "") +
            (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
            (createAt != null ? "createAt=" + createAt + ", " : "") +
            (montantEstime != null ? "montantEstime=" + montantEstime + ", " : "") +
            (offreId != null ? "offreId=" + offreId + ", " : "") +
            (demandeId != null ? "demandeId=" + demandeId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
