package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.LocalDateFilter;
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

    private StringFilter nature;;

    private StringFilter description;;

    private StringFilter specialite;

    private LongFilter nbreHours;

    private StringFilter responsableEtude;
    //dateDebut;
    private LocalDateFilter dateDebut;

    private StringFilter complexite;

    private Boolean distinct;

    public EtudeOppCriteria() {}

    public EtudeOppCriteria(EtudeOppCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nature = other.nature == null ? null : other.nature.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.specialite = other.specialite == null ? null : other.specialite.copy();
        this.nbreHours = other.nbreHours == null ? null : other.nbreHours.copy();
        this.responsableEtude = other.responsableEtude == null ? null : other.responsableEtude.copy();
        this.complexite = other.complexite == null ? null : other.complexite.copy();
        // date
        this.dateDebut = other.dateDebut == null ? null : other.dateDebut.copy();
        this.distinct = other.distinct;
    }

    @Override
    public EtudeOppCriteria copy() {
        return new EtudeOppCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNature() {
        return nature;
    }

    public void setNature(StringFilter nature) {
        this.nature = nature;
    }

    public StringFilter getDescription() {
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getSpecialite() {
        return specialite;
    }

    public void setSpecialite(StringFilter specialite) {
        this.specialite = specialite;
    }

    public LongFilter getNbreHours() {
        return nbreHours;
    }

    public void setNbreHours(LongFilter nbreHours) {
        this.nbreHours = nbreHours;
    }

    public StringFilter getResponsableEtude() {
        return responsableEtude;
    }

    public void setResponsableEtude(StringFilter responsableEtude) {
        this.responsableEtude = responsableEtude;
    }

    public LocalDateFilter getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateFilter dateDebut) {
        this.dateDebut = dateDebut;
    }

    public StringFilter getComplexite() {
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
    public String toString() {
        return "EtudeOppCriteria{" +
                "id=" + id +
                ", nature=" + nature +
                ", description=" + description +
                ", specialite=" + specialite +
                ", nbreHours=" + nbreHours +
                ", responsableEtude=" + responsableEtude +
                ", dateDebut=" + dateDebut +
                ", complexite=" + complexite +
                ", distinct=" + distinct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudeOppCriteria)) return false;
        EtudeOppCriteria that = (EtudeOppCriteria) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNature(), that.getNature()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getSpecialite(), that.getSpecialite()) && Objects.equals(getNbreHours(), that.getNbreHours()) && Objects.equals(getResponsableEtude(), that.getResponsableEtude()) && Objects.equals(getDateDebut(), that.getDateDebut()) && Objects.equals(getComplexite(), that.getComplexite()) && Objects.equals(getDistinct(), that.getDistinct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNature(), getDescription(), getSpecialite(), getNbreHours(), getResponsableEtude(), getDateDebut(), getComplexite(), getDistinct());
    }
}
