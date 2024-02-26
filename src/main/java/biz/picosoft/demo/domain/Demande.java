package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutDemande;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * A Demande.
 */
@Entity
@Table(name = "demande",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "statut_demande")
    private String statutDemande;

    @Column(name = "description")
    private String description;

    @Column(name = "nom")
    private String nom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_de_creation")
    private LocalDate dateDeCreation;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutDemande statut;

    @OneToMany(mappedBy = "demande")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "offres", "demande" }, allowSetters = true)
    private Set<Opportunite> opportunites = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "rel_demande__domaine",
        joinColumns = @JoinColumn(name = "demande_id"),
        inverseJoinColumns = @JoinColumn(name = "domaine_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "demandes" }, allowSetters = true)
    private Set<Domaine> domaines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "demandes" }, allowSetters = true)
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Demande id(Long id) {
        this.setId(id);
        return this;
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

    public LocalDate getDateDeCreation() {
        return this.dateDeCreation;
    }

    public Demande dateDeCreation(LocalDate dateDeCreation) {
        this.setDateDeCreation(dateDeCreation);
        return this;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
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

    public Demande addDomaine(Domaine domaine) {
        this.domaines.add(domaine);
        domaine.getDemandes().add(this);
        return this;
    }

    public Demande removeDomaine(Domaine domaine) {
        this.domaines.remove(domaine);
        domaine.getDemandes().remove(this);
        return this;
    }

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
