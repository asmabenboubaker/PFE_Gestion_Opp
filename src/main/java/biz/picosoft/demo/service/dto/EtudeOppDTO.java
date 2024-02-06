package biz.picosoft.demo.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.EtudeOpp} entity.
 */
public class EtudeOppDTO implements Serializable {

    private Long id;

    private String nomEquipe;

    private String membres;

    private String specialite;

    private Long nbreHours;

    private String evaluation;

    private String complexite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getMembres() {
        return membres;
    }

    public void setMembres(String membres) {
        this.membres = membres;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Long getNbreHours() {
        return nbreHours;
    }

    public void setNbreHours(Long nbreHours) {
        this.nbreHours = nbreHours;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getComplexite() {
        return complexite;
    }

    public void setComplexite(String complexite) {
        this.complexite = complexite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EtudeOppDTO)) {
            return false;
        }

        EtudeOppDTO etudeOppDTO = (EtudeOppDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, etudeOppDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EtudeOppDTO{" +
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
