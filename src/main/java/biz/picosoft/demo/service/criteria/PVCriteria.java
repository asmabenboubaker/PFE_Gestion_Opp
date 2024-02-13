package biz.picosoft.demo.service.criteria;


import biz.picosoft.demo.domain.enumeration.StatutProjet;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.PV} entity. This class is used
 * in {@link biz.picosoft.demo.controller.PVResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /pvs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class PVCriteria implements Serializable, Criteria {

    /**
     * Class for filtering StatutProjet
     */
    public static class StatutProjetFilter extends Filter<StatutProjet> {

        public StatutProjetFilter() {}

        public StatutProjetFilter(StatutProjetFilter filter) {
            super(filter);
        }

        @Override
        public StatutProjetFilter copy() {
            return new StatutProjetFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter datePV;

    private StringFilter contenu;

    private StringFilter participants;

    private StatutProjetFilter statut;

    private LongFilter factureId;

    private LongFilter projetId;

    private Boolean distinct;

    public PVCriteria() {}

    public PVCriteria(PVCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.datePV = other.datePV == null ? null : other.datePV.copy();
        this.contenu = other.contenu == null ? null : other.contenu.copy();
        this.participants = other.participants == null ? null : other.participants.copy();
        this.statut = other.statut == null ? null : other.statut.copy();
        this.factureId = other.factureId == null ? null : other.factureId.copy();
        this.projetId = other.projetId == null ? null : other.projetId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public PVCriteria copy() {
        return new PVCriteria(this);
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

    public InstantFilter getDatePV() {
        return datePV;
    }

    public InstantFilter datePV() {
        if (datePV == null) {
            datePV = new InstantFilter();
        }
        return datePV;
    }

    public void setDatePV(InstantFilter datePV) {
        this.datePV = datePV;
    }

    public StringFilter getContenu() {
        return contenu;
    }

    public StringFilter contenu() {
        if (contenu == null) {
            contenu = new StringFilter();
        }
        return contenu;
    }

    public void setContenu(StringFilter contenu) {
        this.contenu = contenu;
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

    public StatutProjetFilter getStatut() {
        return statut;
    }

    public StatutProjetFilter statut() {
        if (statut == null) {
            statut = new StatutProjetFilter();
        }
        return statut;
    }

    public void setStatut(StatutProjetFilter statut) {
        this.statut = statut;
    }

    public LongFilter getFactureId() {
        return factureId;
    }

    public LongFilter factureId() {
        if (factureId == null) {
            factureId = new LongFilter();
        }
        return factureId;
    }

    public void setFactureId(LongFilter factureId) {
        this.factureId = factureId;
    }

    public LongFilter getProjetId() {
        return projetId;
    }

    public LongFilter projetId() {
        if (projetId == null) {
            projetId = new LongFilter();
        }
        return projetId;
    }

    public void setProjetId(LongFilter projetId) {
        this.projetId = projetId;
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
        final PVCriteria that = (PVCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(datePV, that.datePV) &&
            Objects.equals(contenu, that.contenu) &&
            Objects.equals(participants, that.participants) &&
            Objects.equals(statut, that.statut) &&
            Objects.equals(factureId, that.factureId) &&
            Objects.equals(projetId, that.projetId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePV, contenu, participants, statut, factureId, projetId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PVCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (datePV != null ? "datePV=" + datePV + ", " : "") +
            (contenu != null ? "contenu=" + contenu + ", " : "") +
            (participants != null ? "participants=" + participants + ", " : "") +
            (statut != null ? "statut=" + statut + ", " : "") +
            (factureId != null ? "factureId=" + factureId + ", " : "") +
            (projetId != null ? "projetId=" + projetId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
