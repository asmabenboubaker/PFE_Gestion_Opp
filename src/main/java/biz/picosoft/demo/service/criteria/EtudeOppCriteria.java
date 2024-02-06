package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.EtudeOpp} entity. This class is used
 * in {@link biz.picosoft.demo.controller.EtudeOppResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /etude-opps?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class EtudeOppCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nomEquipe;

    private StringFilter membres;

    private StringFilter specialite;

    private LongFilter nbreHours;

    private StringFilter evaluation;

    private StringFilter complexite;

    private Boolean distinct;

    public EtudeOppCriteria() {}

    public EtudeOppCriteria(EtudeOppCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nomEquipe = other.nomEquipe == null ? null : other.nomEquipe.copy();
        this.membres = other.membres == null ? null : other.membres.copy();
        this.specialite = other.specialite == null ? null : other.specialite.copy();
        this.nbreHours = other.nbreHours == null ? null : other.nbreHours.copy();
        this.evaluation = other.evaluation == null ? null : other.evaluation.copy();
        this.complexite = other.complexite == null ? null : other.complexite.copy();
        this.distinct = other.distinct;
    }

    @Override
    public EtudeOppCriteria copy() {
        return new EtudeOppCriteria(this);
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

    public StringFilter getNomEquipe() {
        return nomEquipe;
    }

    public StringFilter nomEquipe() {
        if (nomEquipe == null) {
            nomEquipe = new StringFilter();
        }
        return nomEquipe;
    }

    public void setNomEquipe(StringFilter nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public StringFilter getMembres() {
        return membres;
    }

    public StringFilter membres() {
        if (membres == null) {
            membres = new StringFilter();
        }
        return membres;
    }

    public void setMembres(StringFilter membres) {
        this.membres = membres;
    }

    public StringFilter getSpecialite() {
        return specialite;
    }

    public StringFilter specialite() {
        if (specialite == null) {
            specialite = new StringFilter();
        }
        return specialite;
    }

    public void setSpecialite(StringFilter specialite) {
        this.specialite = specialite;
    }

    public LongFilter getNbreHours() {
        return nbreHours;
    }

    public LongFilter nbreHours() {
        if (nbreHours == null) {
            nbreHours = new LongFilter();
        }
        return nbreHours;
    }

    public void setNbreHours(LongFilter nbreHours) {
        this.nbreHours = nbreHours;
    }

    public StringFilter getEvaluation() {
        return evaluation;
    }

    public StringFilter evaluation() {
        if (evaluation == null) {
            evaluation = new StringFilter();
        }
        return evaluation;
    }

    public void setEvaluation(StringFilter evaluation) {
        this.evaluation = evaluation;
    }

    public StringFilter getComplexite() {
        return complexite;
    }

    public StringFilter complexite() {
        if (complexite == null) {
            complexite = new StringFilter();
        }
        return complexite;
    }

    public void setComplexite(StringFilter complexite) {
        this.complexite = complexite;
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
        final EtudeOppCriteria that = (EtudeOppCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nomEquipe, that.nomEquipe) &&
            Objects.equals(membres, that.membres) &&
            Objects.equals(specialite, that.specialite) &&
            Objects.equals(nbreHours, that.nbreHours) &&
            Objects.equals(evaluation, that.evaluation) &&
            Objects.equals(complexite, that.complexite) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomEquipe, membres, specialite, nbreHours, evaluation, complexite, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EtudeOppCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nomEquipe != null ? "nomEquipe=" + nomEquipe + ", " : "") +
            (membres != null ? "membres=" + membres + ", " : "") +
            (specialite != null ? "specialite=" + specialite + ", " : "") +
            (nbreHours != null ? "nbreHours=" + nbreHours + ", " : "") +
            (evaluation != null ? "evaluation=" + evaluation + ", " : "") +
            (complexite != null ? "complexite=" + complexite + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
