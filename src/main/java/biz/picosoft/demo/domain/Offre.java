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
 * A Offre.
 */
@Entity
@Table(name = "offre",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Offre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "montant")
    private Float montant;

    @Column(name = "date_offre")
    private Instant dateOffre;

    @Column(name = "description")
    private String description;

    @Column(name = "valide_jusqu_a")
    private Instant valideJusquA;

    @OneToMany(mappedBy = "offre")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "offre", "projet" }, allowSetters = true)
    private Set<BonDeCommande> bondecommandes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "offres", "demande" }, allowSetters = true)
    private Opportunite opportunite;

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

    public Instant getDateOffre() {
        return this.dateOffre;
    }

    public Offre dateOffre(Instant dateOffre) {
        this.setDateOffre(dateOffre);
        return this;
    }

    public void setDateOffre(Instant dateOffre) {
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

    public Instant getValideJusquA() {
        return this.valideJusquA;
    }

    public Offre valideJusquA(Instant valideJusquA) {
        this.setValideJusquA(valideJusquA);
        return this;
    }

    public void setValideJusquA(Instant valideJusquA) {
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
