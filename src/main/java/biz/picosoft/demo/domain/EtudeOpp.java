package biz.picosoft.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A EtudeOpp.
 */
@Entity
@Table(name = "etude_opp",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EtudeOpp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_equipe")
    private String nomEquipe;

    @Column(name = "membres")
    private String membres;

    @Column(name = "specialite")
    private String specialite;

    @Column(name = "nbre_hours")
    private Long nbreHours;

    @Column(name = "evaluation")
    private String evaluation;

    @Column(name = "complexite")
    private String complexite;

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

    public String getNomEquipe() {
        return this.nomEquipe;
    }

    public EtudeOpp nomEquipe(String nomEquipe) {
        this.setNomEquipe(nomEquipe);
        return this;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getMembres() {
        return this.membres;
    }

    public EtudeOpp membres(String membres) {
        this.setMembres(membres);
        return this;
    }

    public void setMembres(String membres) {
        this.membres = membres;
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

    public String getEvaluation() {
        return this.evaluation;
    }

    public EtudeOpp evaluation(String evaluation) {
        this.setEvaluation(evaluation);
        return this;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof EtudeOpp)) {
            return false;
        }
        return id != null && id.equals(((EtudeOpp) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EtudeOpp{" +
            "id=" + getId() +
            ", nomEquipe='" + getNomEquipe() + "'" +
            ", membres='" + getMembres() + "'" +
            ", specialite='" + getSpecialite() + "'" +
            ", nbreHours=" + getNbreHours() +
            ", evaluation='" + getEvaluation() + "'" +
            ", complexite='" + getComplexite() + "'" +
            "}";
    }
}
