package biz.picosoft.demo.service.dto;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Facture} entity.
 */
public class FactureDTO implements Serializable {

    private Long id;

    private LocalDate dateFacture;

    private String description;

    private String serviceFournis;

    private PVDTO pv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceFournis() {
        return serviceFournis;
    }

    public void setServiceFournis(String serviceFournis) {
        this.serviceFournis = serviceFournis;
    }

    public PVDTO getPv() {
        return pv;
    }

    public void setPv(PVDTO pv) {
        this.pv = pv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FactureDTO)) {
            return false;
        }

        FactureDTO factureDTO = (FactureDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, factureDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FactureDTO{" +
            "id=" + getId() +
            ", dateFacture='" + getDateFacture() + "'" +
            ", description='" + getDescription() + "'" +
            ", serviceFournis='" + getServiceFournis() + "'" +
            ", pv=" + getPv() +
            "}";
    }
}
