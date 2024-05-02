package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutBC;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * A BonDeCommande.
 */
@Entity
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

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BonDeCommande)) {
            return false;
        }
        return id != null && id.equals(((BonDeCommande) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BonDeCommande{" +
            "id=" + getId() +
            ", montantTotal=" + getMontantTotal() +
            ", dateCommande='" + getDateCommande() + "'" +
            ", description='" + getDescription() + "'" +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
