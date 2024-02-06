package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Domaine} entity. This class is used
 * in {@link biz.picosoft.demo.controller.DomaineResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /domaines?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class DomaineCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nom;

    private StringFilter description;

    private LongFilter demandeId;

    private Boolean distinct;

    public DomaineCriteria() {}

    public DomaineCriteria(DomaineCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nom = other.nom == null ? null : other.nom.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.demandeId = other.demandeId == null ? null : other.demandeId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public DomaineCriteria copy() {
        return new DomaineCriteria(this);
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
        final DomaineCriteria that = (DomaineCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nom, that.nom) &&
            Objects.equals(description, that.description) &&
            Objects.equals(demandeId, that.demandeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, demandeId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DomaineCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nom != null ? "nom=" + nom + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (demandeId != null ? "demandeId=" + demandeId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
