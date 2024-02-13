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
 * Criteria class for the {@link biz.picosoft.demo.domain.Projet} entity. This class is used
 * in {@link biz.picosoft.demo.controller.ProjetResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /projets?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class ProjetCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nom;

    private InstantFilter dateDebut;

    private InstantFilter dateFin;

    private StringFilter responsable;

    private StringFilter description;

    private StringFilter participants;

    private LongFilter bondecommandeId;

    private LongFilter pvId;

    private Boolean distinct;

    public ProjetCriteria() {}

    public ProjetCriteria(ProjetCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nom = other.nom == null ? null : other.nom.copy();
        this.dateDebut = other.dateDebut == null ? null : other.dateDebut.copy();
        this.dateFin = other.dateFin == null ? null : other.dateFin.copy();
        this.responsable = other.responsable == null ? null : other.responsable.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.participants = other.participants == null ? null : other.participants.copy();
        this.bondecommandeId = other.bondecommandeId == null ? null : other.bondecommandeId.copy();
        this.pvId = other.pvId == null ? null : other.pvId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ProjetCriteria copy() {
        return new ProjetCriteria(this);
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

    public InstantFilter getDateDebut() {
        return dateDebut;
    }

    public InstantFilter dateDebut() {
        if (dateDebut == null) {
            dateDebut = new InstantFilter();
        }
        return dateDebut;
    }

    public void setDateDebut(InstantFilter dateDebut) {
        this.dateDebut = dateDebut;
    }

    public InstantFilter getDateFin() {
        return dateFin;
    }

    public InstantFilter dateFin() {
        if (dateFin == null) {
            dateFin = new InstantFilter();
        }
        return dateFin;
    }

    public void setDateFin(InstantFilter dateFin) {
        this.dateFin = dateFin;
    }

    public StringFilter getResponsable() {
        return responsable;
    }

    public StringFilter responsable() {
        if (responsable == null) {
            responsable = new StringFilter();
        }
        return responsable;
    }

    public void setResponsable(StringFilter responsable) {
        this.responsable = responsable;
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

    public StringFilter getParticipants() {
        return participants;
    }

    public StringFilter participants() {
        if (participants == null) {
            participants = new StringFilter();
        }
        return participants;
    }

    public void setParticipants(StringFilter participants) {
        this.participants = participants;
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
        final ProjetCriteria that = (ProjetCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nom, that.nom) &&
            Objects.equals(dateDebut, that.dateDebut) &&
            Objects.equals(dateFin, that.dateFin) &&
            Objects.equals(responsable, that.responsable) &&
            Objects.equals(description, that.description) &&
            Objects.equals(participants, that.participants) &&
            Objects.equals(bondecommandeId, that.bondecommandeId) &&
            Objects.equals(pvId, that.pvId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, dateDebut, dateFin, responsable, description, participants, bondecommandeId, pvId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProjetCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nom != null ? "nom=" + nom + ", " : "") +
            (dateDebut != null ? "dateDebut=" + dateDebut + ", " : "") +
            (dateFin != null ? "dateFin=" + dateFin + ", " : "") +
            (responsable != null ? "responsable=" + responsable + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (participants != null ? "participants=" + participants + ", " : "") +
            (bondecommandeId != null ? "bondecommandeId=" + bondecommandeId + ", " : "") +
            (pvId != null ? "pvId=" + pvId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
