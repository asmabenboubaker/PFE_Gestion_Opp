package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * A EtudeOpp.
 */
@Entity
@Table(name = "etude_opp",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EtudeOpp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nature")
    private String nature;

    @Column(name = "description")
    private String description;

    @Column(name = "specialite")
    private String specialite;

    @Column(name = "nbre_hours")
    private Long nbreHours;

    @Column(name = "responsableEtude")
    private String responsableEtude;
    private LocalDate dateDebut;
    @Column(name = "complexite")
    private String complexite;
    @OneToMany(mappedBy = "etudeOpp", cascade = CascadeType.ALL)
    private Set<TacheOpp> tachesOpp;

    public Set<TacheOpp> getTachesOpp() {
        return tachesOpp;
    }

    public void setTachesOpp(Set<TacheOpp> tachesOpp) {
        this.tachesOpp = tachesOpp;
    }

    // one to many relationship with Opportunite
    // chaque opp peut avoir plusieurs etudes
    @JsonIgnore
    @ManyToOne
    private Opportunite opportunite;

    public Opportunite getOpportunite() {
        return opportunite;
    }

    public void setOpportunite(Opportunite opportunite) {
        this.opportunite = opportunite;
    }
    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EtudeOpp id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }






    public String getSpecialite() {
        return this.specialite;
    }

    public EtudeOpp specialite(String specialite) {
        this.setSpecialite(specialite);
        return this;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Long getNbreHours() {
        return this.nbreHours;
    }

    public EtudeOpp nbreHours(Long nbreHours) {
        this.setNbreHours(nbreHours);
        return this;
    }

    public void setNbreHours(Long nbreHours) {
        this.nbreHours = nbreHours;
    }






    public String getComplexite() {
        return this.complexite;
    }

    public EtudeOpp complexite(String complexite) {
        this.setComplexite(complexite);
        return this;
    }

    public void setComplexite(String complexite) {
        this.complexite = complexite;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudeOpp)) return false;
        EtudeOpp etudeOpp = (EtudeOpp) o;
        return Objects.equals(getId(), etudeOpp.getId()) && Objects.equals(getNature(), etudeOpp.getNature()) && Objects.equals(getDescription(), etudeOpp.getDescription()) && Objects.equals(getSpecialite(), etudeOpp.getSpecialite()) && Objects.equals(getNbreHours(), etudeOpp.getNbreHours()) && Objects.equals(getResponsableEtude(), etudeOpp.getResponsableEtude()) && Objects.equals(getDateDebut(), etudeOpp.getDateDebut()) && Objects.equals(getComplexite(), etudeOpp.getComplexite()) && Objects.equals(getTachesOpp(), etudeOpp.getTachesOpp()) && Objects.equals(getOpportunite(), etudeOpp.getOpportunite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNature(), getDescription(), getSpecialite(), getNbreHours(), getResponsableEtude(), getDateDebut(), getComplexite());
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsableEtude() {
        return responsableEtude;
    }

    public void setResponsableEtude(String responsableEtude) {
        this.responsableEtude = responsableEtude;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Override
    public String toString() {
        return "EtudeOpp{" +
                "id=" + id +
                ", nature='" + nature + '\'' +
                ", description='" + description + '\'' +
                ", specialite='" + specialite + '\'' +
                ", nbreHours=" + nbreHours +
                ", responsableEtude='" + responsableEtude + '\'' +
                ", dateDebut=" + dateDebut +
                ", complexite='" + complexite + '\'' +
                ", opportunite=" + opportunite +
                '}';
    }
}
