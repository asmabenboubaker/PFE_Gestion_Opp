package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Projet.
 */
@Entity
@Table(name = "projet",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_debut")
    private ZonedDateTime dateDebut;

    @Column(name = "date_fin")
    private ZonedDateTime dateFin;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "description")
    private String description;

    @Column(name = "participants")
    private String participants;

    @ManyToMany
    @JoinTable(
            name = "equipe_projet",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private Set<Equipe> equipes;

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "offre", "projet" }, allowSetters = true)
    private Set<BonDeCommande> bondecommandes = new HashSet<>();

    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "factures", "projet" }, allowSetters = true)
    private Set<PV> pvs = new HashSet<>();
    @Column(name = "budget")
    private float budget;
    @Column(name = "objectif")
    private String objectif;
    @Column(name = "lieu")
    private String lieu;
    @Column(name = "type")
    private String type;
    @Column(name = "priorite")
    private int priorite;
    @Column(name = "commentaires")
    private String commentaires;
    @Column(name = "derniere_mise_a_jour")
    private ZonedDateTime derniereMiseAJour;
    @Column(name = "lien_jira")
    private String lienJira;
    @Column(name = "id_jira")
    private String idJira;
    @Column(name = "Jira_Project",nullable = false )
    @NotNull
    private boolean JiraProject;

    public boolean isJiraProject() {
        return JiraProject;
    }

    public void setJiraProject(boolean jiraProject) {
        JiraProject = jiraProject;
    }
    // jhipster-needle-entity-add-field - JHipster will add fields here

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public ZonedDateTime getDerniereMiseAJour() {
        return derniereMiseAJour;
    }

    public void setDerniereMiseAJour(ZonedDateTime derniereMiseAJour) {
        this.derniereMiseAJour = derniereMiseAJour;
    }

    public String getLienJira() {
        return lienJira;
    }

    public void setLienJira(String lienJira) {
        this.lienJira = lienJira;
    }

    public String getIdJira() {
        return idJira;
    }

    public void setIdJira(String idJira) {
        this.idJira = idJira;
    }

    public Long getId() {
        return this.id;
    }

    public Projet id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public Projet nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ZonedDateTime getDateDebut() {
        return this.dateDebut;
    }

    public Projet dateDebut(ZonedDateTime dateDebut) {
        this.setDateDebut(dateDebut);
        return this;
    }

    public void setDateDebut(ZonedDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public ZonedDateTime getDateFin() {
        return this.dateFin;
    }

    public Projet dateFin(ZonedDateTime dateFin) {
        this.setDateFin(dateFin);
        return this;
    }

    public void setDateFin(ZonedDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public String getResponsable() {
        return this.responsable;
    }

    public Projet responsable(String responsable) {
        this.setResponsable(responsable);
        return this;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return this.description;
    }

    public Projet description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParticipants() {
        return this.participants;
    }

    public Projet participants(String participants) {
        this.setParticipants(participants);
        return this;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Set<BonDeCommande> getBondecommandes() {
        return this.bondecommandes;
    }

    public void setBondecommandes(Set<BonDeCommande> bonDeCommandes) {
        if (this.bondecommandes != null) {
            this.bondecommandes.forEach(i -> i.setProjet(null));
        }
        if (bonDeCommandes != null) {
            bonDeCommandes.forEach(i -> i.setProjet(this));
        }
        this.bondecommandes = bonDeCommandes;
    }

    public Projet bondecommandes(Set<BonDeCommande> bonDeCommandes) {
        this.setBondecommandes(bonDeCommandes);
        return this;
    }

    public Projet addBondecommande(BonDeCommande bonDeCommande) {
        this.bondecommandes.add(bonDeCommande);
        bonDeCommande.setProjet(this);
        return this;
    }

    public Projet removeBondecommande(BonDeCommande bonDeCommande) {
        this.bondecommandes.remove(bonDeCommande);
        bonDeCommande.setProjet(null);
        return this;
    }

    public Set<PV> getPvs() {
        return this.pvs;
    }

    public void setPvs(Set<PV> pVS) {
        if (this.pvs != null) {
            this.pvs.forEach(i -> i.setProjet(null));
        }
        if (pVS != null) {
            pVS.forEach(i -> i.setProjet(this));
        }
        this.pvs = pVS;
    }

    public Projet pvs(Set<PV> pVS) {
        this.setPvs(pVS);
        return this;
    }

    public Projet addPv(PV pV) {
        this.pvs.add(pV);
        pV.setProjet(this);
        return this;
    }

    public Projet removePv(PV pV) {
        this.pvs.remove(pV);
        pV.setProjet(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Projet)) {
            return false;
        }
        return id != null && id.equals(((Projet) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Projet{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            ", responsable='" + getResponsable() + "'" +
            ", description='" + getDescription() + "'" +
            ", participants='" + getParticipants() + "'" +
            "}";
    }
}
