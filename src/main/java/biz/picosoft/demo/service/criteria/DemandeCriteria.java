package biz.picosoft.demo.service.criteria;

import biz.picosoft.demo.domain.enumeration.StatutDemande;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Demande} entity. This class is used
 * in {@link biz.picosoft.demo.controller.DemandeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /demandes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class DemandeCriteria implements Serializable, Criteria {

    /**
     * Class for filtering StatutDemande
     */
    public static class StatutDemandeFilter extends Filter<StatutDemande> {

        public StatutDemandeFilter() {}

        public StatutDemandeFilter(StatutDemandeFilter filter) {
            super(filter);
        }

        @Override
        public StatutDemandeFilter copy() {
            return new StatutDemandeFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter statutDemande;

    private StringFilter description;

    private StringFilter nom;
    private StringFilter activityName;

    private LocalDateFilter dateDeCreation;

    private StatutDemandeFilter statut;

    private LongFilter opportuniteId;

    private LongFilter domaineId;

    private LongFilter clientId;

    private Boolean distinct;

    public DemandeCriteria() {}

    public DemandeCriteria(DemandeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.statutDemande = other.statutDemande == null ? null : other.statutDemande.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.nom = other.nom == null ? null : other.nom.copy();
        this.activityName = other.activityName == null ? null : other.activityName.copy();
        this.dateDeCreation = other.dateDeCreation == null ? null : other.dateDeCreation.copy();
        this.statut = other.statut == null ? null : other.statut.copy();
        this.opportuniteId = other.opportuniteId == null ? null : other.opportuniteId.copy();
        this.domaineId = other.domaineId == null ? null : other.domaineId.copy();
        this.clientId = other.clientId == null ? null : other.clientId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public DemandeCriteria copy() {
        return new DemandeCriteria(this);
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

    public StringFilter getStatutDemande() {
        return statutDemande;
    }

    public StringFilter statutDemande() {
        if (statutDemande == null) {
            statutDemande = new StringFilter();
        }
        return statutDemande;
    }

    public void setStatutDemande(StringFilter statutDemande) {
        this.statutDemande = statutDemande;
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


    public StringFilter getActivityName() {
        return activityName;
    }

    public void setActivityName(StringFilter activityName) {
        this.activityName = activityName;
    }

    public void setNom(StringFilter nom) {
        this.nom = nom;
    }

    public LocalDateFilter getDateDeCreation() {
        return dateDeCreation;
    }

    public LocalDateFilter dateDeCreation() {
        if (dateDeCreation == null) {
            dateDeCreation = new LocalDateFilter();
        }
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDateFilter dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public StatutDemandeFilter getStatut() {
        return statut;
    }

    public StatutDemandeFilter statut() {
        if (statut == null) {
            statut = new StatutDemandeFilter();
        }
        return statut;
    }

    public void setStatut(StatutDemandeFilter statut) {
        this.statut = statut;
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

    public LongFilter getDomaineId() {
        return domaineId;
    }

    public LongFilter domaineId() {
        if (domaineId == null) {
            domaineId = new LongFilter();
        }
        return domaineId;
    }

    public void setDomaineId(LongFilter domaineId) {
        this.domaineId = domaineId;
    }

    public LongFilter getClientId() {
        return clientId;
    }

    public LongFilter clientId() {
        if (clientId == null) {
            clientId = new LongFilter();
        }
        return clientId;
    }

    public void setClientId(LongFilter clientId) {
        this.clientId = clientId;
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
        final DemandeCriteria that = (DemandeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(statutDemande, that.statutDemande) &&
            Objects.equals(description, that.description) &&
            Objects.equals(nom, that.nom) &&
            Objects.equals(dateDeCreation, that.dateDeCreation) &&
            Objects.equals(statut, that.statut) &&
            Objects.equals(opportuniteId, that.opportuniteId) &&
            Objects.equals(domaineId, that.domaineId) &&
            Objects.equals(clientId, that.clientId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statutDemande, description, nom, dateDeCreation, statut, opportuniteId, domaineId, clientId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DemandeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (statutDemande != null ? "statutDemande=" + statutDemande + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (nom != null ? "nom=" + nom + ", " : "") +
            (dateDeCreation != null ? "dateDeCreation=" + dateDeCreation + ", " : "") +
            (statut != null ? "statut=" + statut + ", " : "") +
            (opportuniteId != null ? "opportuniteId=" + opportuniteId + ", " : "") +
            (domaineId != null ? "domaineId=" + domaineId + ", " : "") +
            (clientId != null ? "clientId=" + clientId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
