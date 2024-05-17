package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Opportunite.
 */
@Entity
@Table(name = "opportunite",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Opportunite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "exclude_from_view")
    private Boolean excludeFromView = true;
    @Column(name = "demande_number")
    private String oppNumber;

    public String getOppNumber() {
        return oppNumber;
    }
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOppNumber(String oppNumber) {
        this.oppNumber = oppNumber;
    }

    @Size(min = 0, max = 50)
    @Column(name = "identifiant", length = 50, nullable = true)
    private String identifiant;
    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "number_of_attachments")
    private Long numberOfattachments = 0L;

    @Column(name = "wf_process_id")
    private String wfProcessID;
    @Column(name = "securite_level")
    private Integer securiteLevel;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "end_process")
    private Boolean endProcess;
    @Column(name = "createoffre")
    private Boolean createoffre;

    public Boolean getCreateoffre() {
        return createoffre != null && createoffre.booleanValue();
    }

    public void setCreateoffre(Boolean createoffre) {
        this.createoffre = createoffre;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "equipe_opp",
            joinColumns = @JoinColumn(name = "opp_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")

    )
    @JsonIgnore
    private Set<Equipe> equipes = new HashSet<>();

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
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
    public Boolean isExcludeFromView() {
        return excludeFromView;
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

    @Column(name = "description")
    private String description;

    @Column(name = "nom")
    private String nom;

    @Column(name = "created_by")
    private ZonedDateTime createdBy;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    @Column(name = "montant_estime")
    private Float montantEstime;

    @OneToMany(mappedBy = "opportunite")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "bondecommandes", "opportunite" }, allowSetters = true)
    private Set<Offre> offres = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "opportunites", "domaines", "client" }, allowSetters = true)
    private Demande demande;
    // relation one to many avec etude
    @OneToMany(mappedBy = "opportunite")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "opportunite" }, allowSetters = true)
    private Set<EtudeOpp> etudeOpps = new HashSet<>();

    public Set<EtudeOpp> getEtudeOpps() {
        return etudeOpps;
    }

    public void setEtudeOpps(Set<EtudeOpp> etudeOpps) {
        this.etudeOpps = etudeOpps;
    }

// jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Opportunite id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public Opportunite description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public Opportunite nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ZonedDateTime getCreatedBy() {
        return this.createdBy;
    }

    public Opportunite createdBy(ZonedDateTime createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(ZonedDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreateAt() {
        return this.createAt;
    }

    public Opportunite createAt(ZonedDateTime createAt) {
        this.setCreateAt(createAt);
        return this;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public Float getMontantEstime() {
        return this.montantEstime;
    }

    public Opportunite montantEstime(Float montantEstime) {
        this.setMontantEstime(montantEstime);
        return this;
    }

    public void setMontantEstime(Float montantEstime) {
        this.montantEstime = montantEstime;
    }

    public Set<Offre> getOffres() {
        return this.offres;
    }

    public void setOffres(Set<Offre> offres) {
        if (this.offres != null) {
            this.offres.forEach(i -> i.setOpportunite(null));
        }
        if (offres != null) {
            offres.forEach(i -> i.setOpportunite(this));
        }
        this.offres = offres;
    }

    public Opportunite offres(Set<Offre> offres) {
        this.setOffres(offres);
        return this;
    }

    public Opportunite addOffre(Offre offre) {
        this.offres.add(offre);
        offre.setOpportunite(this);
        return this;
    }

    public Opportunite removeOffre(Offre offre) {
        this.offres.remove(offre);
        offre.setOpportunite(null);
        return this;
    }

    public Demande getDemande() {
        return this.demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Opportunite demande(Demande demande) {
        this.setDemande(demande);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunite that = (Opportunite) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Opportunite{" +
                "id=" + id +
                ", description='" + description + "'" +
                ", nom='" + nom + "'" +
                ", createdBy='" + createdBy + "'" +
                ", createAt='" + createAt + "'" +
                ", montantEstime=" + montantEstime +
                "}";
    }
}
