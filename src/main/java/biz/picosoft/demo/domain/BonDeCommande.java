package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutBC;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A BonDeCommande.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bon_de_commande",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BonDeCommande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "montant_total")
    private Float montantTotal;

    @Column(name = "date_commande")
    private ZonedDateTime dateCommande;

    @Column(name = "description")
    private String description;



    public Boolean getExcludeFromView() {
        return excludeFromView;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutBC statut;

    @Size(min = 0, max = 50)
    @Column(name = "identifiant", length = 50, nullable = true)
    private String identifiant;
    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "number_of_attachments")
    private Long numberOfattachments = 0L;
    @Column(name = "exclude_from_view")
    private Boolean excludeFromView = true;
    @Column(name = "status")
    private String status;
    @Column(name = "wf_process_id")
    private String wfProcessID;
    @Column(name = "statut_demande")
    private String statutDemande;
    @Column(name = "securite_level")
    private Integer securiteLevel;
    @Column(name = "assignee")
    private String assignee;

    @Column(name = "end_process")
    private Boolean endProcess;
    @Column(name = "demande_number")
    private String demandeNumber;


    private LocalDate datedelivraison;

    private String servicecommande;

    private String methodedepaiement;

    public LocalDate getDatedelivraison() {
        return datedelivraison;
    }

    public void setDatedelivraison(LocalDate datedelivraison) {
        this.datedelivraison = datedelivraison;
    }

    public String getServicecommande() {
        return servicecommande;
    }

    public void setServicecommande(String servicecommande) {
        this.servicecommande = servicecommande;
    }

    public String getMethodedepaiement() {
        return methodedepaiement;
    }

    public void setMethodedepaiement(String methodedepaiement) {
        this.methodedepaiement = methodedepaiement;
    }

    public Boolean isExcludeFromView() {
        return excludeFromView;
    }

    public void setExcludeFromView(Boolean excludeFromView) {
        this.excludeFromView = excludeFromView;
    }


    public String getDemandeNumber() {
        return demandeNumber;
    }

    public void setDemandeNumber(String demandeNumber) {
        this.demandeNumber = demandeNumber;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getNumberOfattachments() {
        return numberOfattachments;
    }

    public void setNumberOfattachments(Long numberOfattachments) {
        this.numberOfattachments = numberOfattachments;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWfProcessID() {
        return wfProcessID;
    }

    public void setWfProcessID(String wfProcessID) {
        this.wfProcessID = wfProcessID;
    }

    public String getStatutDemande() {
        return statutDemande;
    }

    public void setStatutDemande(String statutDemande) {
        this.statutDemande = statutDemande;
    }

    public Integer getSecuriteLevel() {
        return securiteLevel;
    }

    public void setSecuriteLevel(Integer securiteLevel) {
        this.securiteLevel = securiteLevel;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Boolean getEndProcess() {
        return endProcess;
    }

    public void setEndProcess(Boolean endProcess) {
        this.endProcess = endProcess;
    }

    @ManyToOne
    @JsonIgnoreProperties(value = { "bondecommandes", "opportunite" }, allowSetters = true)
    private Offre offre;

    @ManyToOne
    @JsonIgnoreProperties(value = { "bondecommandes", "pvs" }, allowSetters = true)
    private Projet projet;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BonDeCommande id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontantTotal() {
        return this.montantTotal;
    }

    public BonDeCommande montantTotal(Float montantTotal) {
        this.setMontantTotal(montantTotal);
        return this;
    }

    public void setMontantTotal(Float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ZonedDateTime getDateCommande() {
        return this.dateCommande;
    }

    public BonDeCommande dateCommande(ZonedDateTime dateCommande) {
        this.setDateCommande(dateCommande);
        return this;
    }

    public void setDateCommande(ZonedDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDescription() {
        return this.description;
    }

    public BonDeCommande description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutBC getStatut() {
        return this.statut;
    }

    public BonDeCommande statut(StatutBC statut) {
        this.setStatut(statut);
        return this;
    }

    public void setStatut(StatutBC statut) {
        this.statut = statut;
    }

    public Offre getOffre() {
        return this.offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public BonDeCommande offre(Offre offre) {
        this.setOffre(offre);
        return this;
    }

    public Projet getProjet() {
        return this.projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public BonDeCommande projet(Projet projet) {
        this.setProjet(projet);
        return this;
    }

    @Override
    public String toString() {
        return "BonDeCommande{" +
                "id=" + id +
                ", montantTotal=" + montantTotal +
                ", dateCommande=" + dateCommande +
                ", description='" + description + '\'' +

                ", statut=" + statut +
                ", identifiant='" + identifiant + '\'' +
                ", activityName='" + activityName + '\'' +
                ", numberOfattachments=" + numberOfattachments +
                ", excludeFromView=" + excludeFromView +
                ", status='" + status + '\'' +
                ", wfProcessID='" + wfProcessID + '\'' +
                ", statutDemande='" + statutDemande + '\'' +
                ", securiteLevel=" + securiteLevel +
                ", assignee='" + assignee + '\'' +
                ", endProcess=" + endProcess +
                ", demandeNumber='" + demandeNumber + '\'' +
                ", offre=" + offre +
                ", projet=" + projet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonDeCommande that = (BonDeCommande) o;
        return Objects.equals(id, that.id) && Objects.equals(montantTotal, that.montantTotal) && Objects.equals(dateCommande, that.dateCommande) && Objects.equals(description, that.description) && statut == that.statut && Objects.equals(identifiant, that.identifiant) && Objects.equals(activityName, that.activityName) && Objects.equals(numberOfattachments, that.numberOfattachments) && Objects.equals(excludeFromView, that.excludeFromView) && Objects.equals(status, that.status) && Objects.equals(wfProcessID, that.wfProcessID) && Objects.equals(statutDemande, that.statutDemande) && Objects.equals(securiteLevel, that.securiteLevel) && Objects.equals(assignee, that.assignee) && Objects.equals(endProcess, that.endProcess) && Objects.equals(demandeNumber, that.demandeNumber) && Objects.equals(offre, that.offre) && Objects.equals(projet, that.projet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montantTotal, dateCommande, description, statut, identifiant, activityName, numberOfattachments, excludeFromView, status, wfProcessID, statutDemande, securiteLevel, assignee, endProcess, demandeNumber, offre, projet);
    }
}
