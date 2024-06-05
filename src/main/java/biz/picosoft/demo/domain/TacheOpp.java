package biz.picosoft.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TacheOpp",schema = "opportunite")
public class TacheOpp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String description;
    private String nom;
    private Long nbreHours;
    @ManyToOne
    @JoinColumn(name = "etude_opp_id", referencedColumnName = "id")
    @JsonIgnore
    private EtudeOpp etudeOpp;

    @Override
    public String toString() {
        return "TacheOpp{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", nbreHours=" + nbreHours +
                ", etudeOpp=" + etudeOpp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TacheOpp)) return false;
        TacheOpp tacheOpp = (TacheOpp) o;
        return Objects.equals(getId(), tacheOpp.getId()) && Objects.equals(getDescription(), tacheOpp.getDescription()) && Objects.equals(getNom(), tacheOpp.getNom()) && Objects.equals(getNbreHours(), tacheOpp.getNbreHours()) && Objects.equals(getEtudeOpp(), tacheOpp.getEtudeOpp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getNom(), getNbreHours(), getEtudeOpp());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNbreHours() {
        return nbreHours;
    }

    public void setNbreHours(Long nbreHours) {
        this.nbreHours = nbreHours;
    }

    public EtudeOpp getEtudeOpp() {
        return etudeOpp;
    }

    public void setEtudeOpp(EtudeOpp etudeOpp) {
        this.etudeOpp = etudeOpp;
    }
}
