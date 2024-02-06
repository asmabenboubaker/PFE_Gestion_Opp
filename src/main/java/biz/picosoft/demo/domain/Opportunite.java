package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "nom")
    private String nom;

    @Column(name = "created_by")
    private Instant createdBy;

    @Column(name = "create_at")
    private Instant createAt;

    @Column(name = "montant_estime")
    private Float montantEstime;

    @OneToMany(mappedBy = "opportunite")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "bondecommandes", "opportunite" }, allowSetters = true)
    private Set<Offre> offres = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "opportunites", "domaines", "client" }, allowSetters = true)
    private Demande demande;

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

    public Instant getCreatedBy() {
        return this.createdBy;
    }

    public Opportunite createdBy(Instant createdBy) {
        this.setCreatedBy(createdBy);
        return this;
    }

    public void setCreatedBy(Instant createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreateAt() {
        return this.createAt;
    }

    public Opportunite createAt(Instant createAt) {
        this.setCreateAt(createAt);
        return this;
    }

    public void setCreateAt(Instant createAt) {
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Opportunite)) {
            return false;
        }
        return id != null && id.equals(((Opportunite) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Opportunite{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", nom='" + getNom() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", montantEstime=" + getMontantEstime() +
            "}";
    }
}
