package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutOffre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Offre.
 */
@Entity
@Table(name = "offre",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Offre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany(mappedBy = "offreDePrix", cascade = CascadeType.ALL)
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Column(name = "montant")
    private Float montant;
    @Column(name = "createBC")
    private Boolean createBC;
//return createOpp != null && createOpp.booleanValue();

    public Boolean getCreateBC() {
        return createBC != null && createBC.booleanValue();
    }

    public void setCreateBC(Boolean createBC) {
        this.createBC = createBC;
    }

    @Column(name = "date_offre")
    private LocalDate dateOffre;

    @Column(name = "description")
    private String description;

    @Column(name = "valide_jusqu_a")
    private LocalDate valideJusquA;

    @OneToMany(mappedBy = "offre")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "offre", "projet" }, allowSetters = true)
    private Set<BonDeCommande> bondecommandes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "offres", "demande" }, allowSetters = true)
    private Opportunite opportunite;

    // process

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
    @Column(name = "securite_level")
    private Integer securiteLevel;
    @Column(name = "assignee")
    private String assignee;

    @Column(name = "end_process")
    private Boolean endProcess;
    @Column(name = "mode_paiement")
    private String modePaiement;
    @Column(name = "date_livraison")
    private LocalDate dateLivraison;
    @Column(name = "statut_offre")
    @Enumerated(EnumType.STRING)
    private StatutOffre statutOffre;

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public StatutOffre getStatutOffre() {
        return statutOffre;
    }

    public void setStatutOffre(StatutOffre statutOffre) {
        this.statutOffre = statutOffre;
    }

    @Column(name = "offre_number")
    private String offreNumber;

    public String getOffreNumber() {
        return offreNumber;
    }

    public void setOffreNumber(String offreNumber) {
        this.offreNumber = offreNumber;
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

    public Boolean getExcludeFromView() {
        return excludeFromView;
    }

    public void setExcludeFromView(Boolean excludeFromView) {
        this.excludeFromView = excludeFromView;
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



// jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Offre id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontant() {
        return this.montant;
    }

    public Offre montant(Float montant) {
        this.setMontant(montant);
        return this;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public LocalDate getDateOffre() {
        return this.dateOffre;
    }

    public Offre dateOffre(LocalDate dateOffre) {
        this.setDateOffre(dateOffre);
        return this;
    }

    public void setDateOffre(LocalDate dateOffre) {
        this.dateOffre = dateOffre;
    }

    public String getDescription() {
        return this.description;
    }

    public Offre description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getValideJusquA() {
        return this.valideJusquA;
    }

    public Offre valideJusquA(LocalDate valideJusquA) {
        this.setValideJusquA(valideJusquA);
        return this;
    }

    public void setValideJusquA(LocalDate valideJusquA) {
        this.valideJusquA = valideJusquA;
    }

    public Set<BonDeCommande> getBondecommandes() {
        return this.bondecommandes;
    }

    public void setBondecommandes(Set<BonDeCommande> bonDeCommandes) {
        if (this.bondecommandes != null) {
            this.bondecommandes.forEach(i -> i.setOffre(null));
        }
        if (bonDeCommandes != null) {
            bonDeCommandes.forEach(i -> i.setOffre(this));
        }
        this.bondecommandes = bonDeCommandes;
    }

    public Offre bondecommandes(Set<BonDeCommande> bonDeCommandes) {
        this.setBondecommandes(bonDeCommandes);
        return this;
    }

    public Offre addBondecommande(BonDeCommande bonDeCommande) {
        this.bondecommandes.add(bonDeCommande);
        bonDeCommande.setOffre(this);
        return this;
    }

    public Offre removeBondecommande(BonDeCommande bonDeCommande) {
        this.bondecommandes.remove(bonDeCommande);
        bonDeCommande.setOffre(null);
        return this;
    }

    public Opportunite getOpportunite() {
        return this.opportunite;
    }

    public void setOpportunite(Opportunite opportunite) {
        this.opportunite = opportunite;
    }

    public Offre opportunite(Opportunite opportunite) {
        this.setOpportunite(opportunite);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Offre)) {
            return false;
        }
        return id != null && id.equals(((Offre) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Offre{" +
            "id=" + getId() +
            ", montant=" + getMontant() +
            ", dateOffre='" + getDateOffre() + "'" +
            ", description='" + getDescription() + "'" +
            ", valideJusquA='" + getValideJusquA() + "'" +
            "}";
    }
}
