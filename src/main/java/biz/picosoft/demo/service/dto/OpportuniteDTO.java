package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Opportunite} entity.
 */
public class OpportuniteDTO implements Serializable {

    private Long id;

    private String description;

    private String nom;

    private ZonedDateTime createdBy;

    private ZonedDateTime createAt;
    private String nomDepartement;
    private String sidDepartement;
    private Set<EtudeOpp> etudeOpps;

    public Set<EtudeOpp> getEtudeOpps() {
        return etudeOpps;
    }

    public void setEtudeOpps(Set<EtudeOpp> etudeOpps) {
        this.etudeOpps = etudeOpps;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getSidDepartement() {
        return sidDepartement;
    }

    public void setSidDepartement(String sidDepartement) {
        this.sidDepartement = sidDepartement;
    }

    private Float montantEstime;

    private DemandeDTO demande;
    private Set<Equipe> equipes;

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
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

    public ZonedDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ZonedDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public Float getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(Float montantEstime) {
        this.montantEstime = montantEstime;
    }

    public DemandeDTO getDemande() {
        return demande;
    }

    public void setDemande(DemandeDTO demande) {
        this.demande = demande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpportuniteDTO)) return false;
        OpportuniteDTO that = (OpportuniteDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getCreatedBy(), that.getCreatedBy()) && Objects.equals(getCreateAt(), that.getCreateAt()) && Objects.equals(getNomDepartement(), that.getNomDepartement()) && Objects.equals(getSidDepartement(), that.getSidDepartement()) && Objects.equals(getEtudeOpps(), that.getEtudeOpps()) && Objects.equals(getMontantEstime(), that.getMontantEstime()) && Objects.equals(getDemande(), that.getDemande()) && Objects.equals(getEquipes(), that.getEquipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getNom(), getCreatedBy(), getCreateAt(), getNomDepartement(), getSidDepartement(), getEtudeOpps(), getMontantEstime(), getDemande(), getEquipes());
    }

    @Override
    public String toString() {
        return "OpportuniteDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", createdBy=" + createdBy +
                ", createAt=" + createAt +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", sidDepartement='" + sidDepartement + '\'' +
                ", etudeOpps=" + etudeOpps +
                ", montantEstime=" + montantEstime +
                ", demande=" + demande +
                ", equipes=" + equipes +
                '}';
    }
}
