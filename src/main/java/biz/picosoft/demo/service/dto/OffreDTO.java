package biz.picosoft.demo.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Offre} entity.
 */
public class OffreDTO implements Serializable {

    private Long id;

    private Float montant;

    private Instant dateOffre;

    private String description;

    private Instant valideJusquA;

    private OpportuniteDTO opportunite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Instant getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(Instant dateOffre) {
        this.dateOffre = dateOffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getValideJusquA() {
        return valideJusquA;
    }

    public void setValideJusquA(Instant valideJusquA) {
        this.valideJusquA = valideJusquA;
    }

    public OpportuniteDTO getOpportunite() {
        return opportunite;
    }

    public void setOpportunite(OpportuniteDTO opportunite) {
        this.opportunite = opportunite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OffreDTO)) {
            return false;
        }

        OffreDTO offreDTO = (OffreDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, offreDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OffreDTO{" +
            "id=" + getId() +
            ", montant=" + getMontant() +
            ", dateOffre='" + getDateOffre() + "'" +
            ", description='" + getDescription() + "'" +
            ", valideJusquA='" + getValideJusquA() + "'" +
            ", opportunite=" + getOpportunite() +
            "}";
    }
}
