package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutDemande;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import java.util.HashSet;
import java.util.Set;

/**
 * A Demande.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "demande",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @Column(name = "description")
    private String description;

    @Column(name = "nom")
    private String nom;
   //add deadline att

    @Column(name = "deadline")
    private LocalDate deadline;
    @Column(name = "source")
    private String source;
    @Column(name = "createOpp")

    private Boolean createOpp;

    public boolean isCreateOpp() {
        return createOpp != null && createOpp.booleanValue();
    }

    public void setCreateOpp(boolean createOpp) {
        this.createOpp = createOpp;
    }

    @Column(name = "commentaires")
    private String commentaires;
    public LocalDate getDeadline() {
        return deadline;
    }
// add Source de la demande


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }


    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Column(name = "date_de_creation")
    private ZonedDateTime dateDeCreation;

    @Column(name = "demande_number")
    private String demandeNumber;
//    @OneToMany(mappedBy = "demande", cascade = CascadeType.ALL, orphanRemoval = true)
//  // @JsonIgnoreProperties(value = "demande", allowSetters = true)
// @JsonIgnore
//    private Set<FileModel> images = new HashSet<>();

//    public Set<FileModel> getImages() {
//        return this.images;
//    }

//    public void setImages(Set<FileModel> images) {
//        if (this.images == null) {
//            this.images = new HashSet<>();
//        }
//        if (images != null) {
//            this.images.clear();
//            this.images.addAll(images);
//        }
//    }
    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutDemande statut;

    @OneToMany(mappedBy = "demande")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Opportunite> opportunites = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
        name = "rel_demande__domaine",
        joinColumns = @JoinColumn(name = "demande_id"),
        inverseJoinColumns = @JoinColumn(name = "domaine_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<Domaine> domaines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "demandes" }, allowSetters = true)
    private Client client;



    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Boolean getEndProcess() {
        return endProcess;
    }
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setEndProcess(Boolean endProcess) {
        this.endProcess = endProcess;
    }
    public Long getId() {
        return this.id;
    }

    public Demande id(Long id) {
        this.setId(id);
        return this;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getSecuriteLevel() {
        return securiteLevel;
    }

    public void setSecuriteLevel(Integer securiteLevel) {
        this.securiteLevel = securiteLevel;
    }
    public String getWfProcessID() {
        return wfProcessID;
    }

    public void setWfProcessID(String wfProcessID) {
        this.wfProcessID = wfProcessID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatutDemande() {
        return this.statutDemande;
    }

    public Demande statutDemande(String statutDemande) {
        this.setStatutDemande(statutDemande);
        return this;
    }

    public void setStatutDemande(String statutDemande) {
        this.statutDemande = statutDemande;
    }

    public String getDescription() {
        return this.description;
    }

    public Demande description(String description) {
        this.setDescription(description);
        return this;
    }
    public String getDemandeNumber() {
        return demandeNumber;
    }

    public void setDemandeNumber(String DemandeNumber) {
        this.demandeNumber = DemandeNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public Demande nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ZonedDateTime getDateDeCreation() {
        return this.dateDeCreation;
    }

    public Demande dateDeCreation(ZonedDateTime dateDeCreation) {
        this.setDateDeCreation(dateDeCreation);
        return this;
    }

    public void setDateDeCreation(ZonedDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public StatutDemande getStatut() {
        return this.statut;
    }

    public Demande statut(StatutDemande statut) {
        this.setStatut(statut);
        return this;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public Set<Opportunite> getOpportunites() {
        return this.opportunites;
    }

    public void setOpportunites(Set<Opportunite> opportunites) {
        if (this.opportunites != null) {
            this.opportunites.forEach(i -> i.setDemande(null));
        }
        if (opportunites != null) {
            opportunites.forEach(i -> i.setDemande(this));
        }
        this.opportunites = opportunites;
    }

    public Demande opportunites(Set<Opportunite> opportunites) {
        this.setOpportunites(opportunites);
        return this;
    }

    public Demande addOpportunite(Opportunite opportunite) {
        this.opportunites.add(opportunite);
        opportunite.setDemande(this);
        return this;
    }

    public Demande removeOpportunite(Opportunite opportunite) {
        this.opportunites.remove(opportunite);
        opportunite.setDemande(null);
        return this;
    }
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Set<Domaine> getDomaines() {
        return this.domaines;
    }

    public void setDomaines(Set<Domaine> domaines) {
        this.domaines = domaines;
    }

    public Demande domaines(Set<Domaine> domaines) {
        this.setDomaines(domaines);
        return this;
    }

//    public Demande addDomaine(Domaine domaine) {
//        this.domaines.add(domaine);
//        domaine.getDemandes().add(this);
//        return this;
//    }
//
//    public Demande removeDomaine(Domaine domaine) {
//        this.domaines.remove(domaine);
//        domaine.getDemandes().remove(this);
//        return this;
//    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Demande client(Client client) {
        this.setClient(client);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Demande)) {
            return false;
        }
        return id != null && id.equals(((Demande) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }
    public Boolean isExcludeFromView() {
        return excludeFromView;
    }

    public void setExcludeFromView(Boolean excludeFromView) {
        this.excludeFromView = excludeFromView;
    }

    public Long getNumberOfattachments() {
        return numberOfattachments;
    }

    public void setNumberOfattachments(Long numberOfattachments) {
        this.numberOfattachments = numberOfattachments;
    }
    // prettier-ignore
    @Override
    public String toString() {
        return "Demande{" +
            "id=" + getId() +
            ", statutDemande='" + getStatutDemande() + "'" +
            ", description='" + getDescription() + "'" +
            ", nom='" + getNom() + "'" +
            ", dateDeCreation='" + getDateDeCreation() + "'" +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
