package biz.picosoft.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity

@Table(name = "article",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nom;
    private String description;
    private int quantite;
    //prixUnitaire;
    private double prixUnitaire;
    // prixTotal;
    private double prixTotal;
    @ManyToOne
    @JoinColumn(name = "offre_de_prix_id")
    private Offre offreDePrix;

    public Offre getOffreDePrix() {
        return offreDePrix;
    }

    public void setOffreDePrix(Offre offreDePrix) {
        this.offreDePrix = offreDePrix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getQuantite() == article.getQuantite() && Double.compare(getPrixUnitaire(), article.getPrixUnitaire()) == 0 && Double.compare(getPrixTotal(), article.getPrixTotal()) == 0 && Objects.equals(getId(), article.getId()) && Objects.equals(getNom(), article.getNom()) && Objects.equals(getDescription(), article.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getDescription(), getQuantite(), getPrixUnitaire(), getPrixTotal());
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", prixTotal=" + prixTotal +
                '}';
    }
}
