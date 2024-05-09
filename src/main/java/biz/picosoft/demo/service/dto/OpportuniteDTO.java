package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Equipe;

import java.io.Serializable;
import java.time.ZonedDateTime;
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof OpportuniteDTO)) {
            return false;
        }

        OpportuniteDTO opportuniteDTO = (OpportuniteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, opportuniteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OpportuniteDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", nom='" + getNom() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createAt='" + getCreateAt() + "'" +
            ", montantEstime=" + getMontantEstime() +
            ", demande=" + getDemande() +
            "}";
    }
}
