package biz.picosoft.demo.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Opportunite} entity.
 */
public class OpportuniteDTO implements Serializable {

    private Long id;

    private String description;

    private String nom;

    private Instant createdBy;

    private Instant createAt;

    private Float montantEstime;

    private DemandeDTO demande;

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

    public Instant getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Instant createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
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
