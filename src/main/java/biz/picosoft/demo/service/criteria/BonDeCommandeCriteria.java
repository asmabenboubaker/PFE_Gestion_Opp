package biz.picosoft.demo.service.criteria;


import biz.picosoft.demo.domain.enumeration.StatutBC;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.BonDeCommande} entity. This class is used
 * in {@link biz.picosoft.demo.controller.BonDeCommandeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /bon-de-commandes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class BonDeCommandeCriteria implements Serializable, Criteria {

    /**
     * Class for filtering StatutBC
     */
    public static class StatutBCFilter extends Filter<StatutBC> {

        public StatutBCFilter() {}

        public StatutBCFilter(StatutBCFilter filter) {
            super(filter);
        }

        @Override
        public StatutBCFilter copy() {
            return new StatutBCFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private FloatFilter montantTotal;

    private ZonedDateTimeFilter dateCommande;

    private StringFilter description;

    private StatutBCFilter statut;

    private LongFilter offreId;

    private LongFilter projetId;

    private Boolean distinct;
    // add private LocalDate Datedelivraison;
    //private String Servicecommande;
    //private String Methodedepaiement;


    public StringFilter getServicecommande() {
        return servicecommande;
    }

    public void setServicecommande(StringFilter servicecommande) {
        this.servicecommande = servicecommande;
    }

    public StringFilter getMethodedepaiement() {
        return methodedepaiement;
    }

    public void setMethodedepaiement(StringFilter methodedepaiement) {
        this.methodedepaiement = methodedepaiement;
    }

    public LocalDateFilter getDatedelivraison() {
        return datedelivraison;
    }

    public void setDatedelivraison(LocalDateFilter datedelivraison) {
        this.datedelivraison = datedelivraison;
    }

    private StringFilter servicecommande;
    private StringFilter methodedepaiement;
    private LocalDateFilter datedelivraison;
    public BonDeCommandeCriteria() {}

    public BonDeCommandeCriteria(BonDeCommandeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.montantTotal = other.montantTotal == null ? null : other.montantTotal.copy();
        this.dateCommande = other.dateCommande == null ? null : other.dateCommande.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.statut = other.statut == null ? null : other.statut.copy();
        this.offreId = other.offreId == null ? null : other.offreId.copy();
        this.projetId = other.projetId == null ? null : other.projetId.copy();
        this.distinct = other.distinct;
        this.servicecommande = other.servicecommande == null ? null : other.servicecommande.copy();
        this.methodedepaiement = other.methodedepaiement == null ? null : other.methodedepaiement.copy();
        this.datedelivraison = other.datedelivraison == null ? null : other.datedelivraison.copy();
    }

    @Override
    public BonDeCommandeCriteria copy() {
        return new BonDeCommandeCriteria(this);
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

    public FloatFilter getMontantTotal() {
        return montantTotal;
    }

    public FloatFilter montantTotal() {
        if (montantTotal == null) {
            montantTotal = new FloatFilter();
        }
        return montantTotal;
    }

    public void setMontantTotal(FloatFilter montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ZonedDateTimeFilter getDateCommande() {
        return dateCommande;
    }

    public ZonedDateTimeFilter dateCommande() {
        if (dateCommande == null) {
            dateCommande = new ZonedDateTimeFilter();
        }
        return dateCommande;
    }

    public void setDateCommande(ZonedDateTimeFilter dateCommande) {
        this.dateCommande = dateCommande;
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

    public StatutBCFilter getStatut() {
        return statut;
    }

    public StatutBCFilter statut() {
        if (statut == null) {
            statut = new StatutBCFilter();
        }
        return statut;
    }

    public void setStatut(StatutBCFilter statut) {
        this.statut = statut;
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
        final BonDeCommandeCriteria that = (BonDeCommandeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(montantTotal, that.montantTotal) &&
            Objects.equals(dateCommande, that.dateCommande) &&
            Objects.equals(description, that.description) &&
            Objects.equals(statut, that.statut) &&
            Objects.equals(offreId, that.offreId) &&
            Objects.equals(projetId, that.projetId) &&
            Objects.equals(distinct, that.distinct) &&

            Objects.equals(servicecommande, that.servicecommande) &&
            Objects.equals(methodedepaiement, that.methodedepaiement) &&
            Objects.equals(datedelivraison, that.datedelivraison)



        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montantTotal, dateCommande, description, statut, offreId, projetId, distinct, servicecommande, methodedepaiement, datedelivraison);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BonDeCommandeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (montantTotal != null ? "montantTotal=" + montantTotal + ", " : "") +
            (dateCommande != null ? "dateCommande=" + dateCommande + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (statut != null ? "statut=" + statut + ", " : "") +
            (offreId != null ? "offreId=" + offreId + ", " : "") +
            (projetId != null ? "projetId=" + projetId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
//            (Servicecommande != null ? "Servicecommande=" + Servicecommande + ", " : "") +
//            (Methodedepaiement != null ? "Methodedepaiement=" + Methodedepaiement + ", " : "") +
//            (Datedelivraison != null ? "Datedelivraison=" + Datedelivraison + ", " : "") +
                (servicecommande != null ? "servicecommande=" + servicecommande + ", " : "") +
                (methodedepaiement != null ? "methodedepaiement=" + methodedepaiement + ", " : "") +
                (datedelivraison != null ? "datedelivraison=" + datedelivraison + ", " : "") +
            "}";
    }
}
