package biz.picosoft.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Facture} entity.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FactureDTO implements Serializable {

    private Long id;

    private LocalDate dateFacture;

    private String description;

    private String serviceFournis;

    private PVDTO pv;
    private Boolean isPaid;

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

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
        if (this == o) return true;
        if (!(o instanceof FactureDTO)) return false;
        FactureDTO that = (FactureDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateFacture(), that.getDateFacture()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getServiceFournis(), that.getServiceFournis()) && Objects.equals(getPv(), that.getPv()) && Objects.equals(isPaid, that.isPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateFacture(), getDescription(), getServiceFournis(), getPv(), isPaid);
    }

    @Override
    public String toString() {
        return "FactureDTO{" +
                "id=" + id +
                ", dateFacture=" + dateFacture +
                ", description='" + description + '\'' +
                ", serviceFournis='" + serviceFournis + '\'' +
                ", pv=" + pv +
                ", isPaid=" + isPaid +
                '}';
    }
}
