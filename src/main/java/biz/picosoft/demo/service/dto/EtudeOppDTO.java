package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Opportunite;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.EtudeOpp} entity.
 */
public class EtudeOppDTO implements Serializable {

    private Long id;


    private String nature;


    private String description;


    private String specialite;


    private Long nbreHours;


    private String responsableEtude;
    private LocalDate dateDebut;

    private String complexite;
    private Opportunite opportunite;

    @Override
    public String toString() {
        return "EtudeOppDTO{" +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudeOppDTO)) return false;
        EtudeOppDTO that = (EtudeOppDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNature(), that.getNature()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getSpecialite(), that.getSpecialite()) && Objects.equals(getNbreHours(), that.getNbreHours()) && Objects.equals(getResponsableEtude(), that.getResponsableEtude()) && Objects.equals(getDateDebut(), that.getDateDebut()) && Objects.equals(getComplexite(), that.getComplexite()) && Objects.equals(getOpportunite(), that.getOpportunite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNature(), getDescription(), getSpecialite(), getNbreHours(), getResponsableEtude(), getDateDebut(), getComplexite(), getOpportunite());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComplexite() {
        return complexite;
    }

    public void setComplexite(String complexite) {
        this.complexite = complexite;
    }

    public Opportunite getOpportunite() {
        return opportunite;
    }

    public void setOpportunite(Opportunite opportunite) {
        this.opportunite = opportunite;
    }
}
