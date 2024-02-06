package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Facture.
 */
@Entity
@Table(name = "facture",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "date_facture")
    private Instant dateFacture;

    @Column(name = "description")
    private String description;

    @Column(name = "service_fournis")
    private String serviceFournis;

    @ManyToOne
    @JsonIgnoreProperties(value = { "factures", "projet" }, allowSetters = true)
    private PV pv;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Facture id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateFacture() {
        return this.dateFacture;
    }

    public Facture dateFacture(Instant dateFacture) {
        this.setDateFacture(dateFacture);
        return this;
    }

    public void setDateFacture(Instant dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getDescription() {
        return this.description;
    }

    public Facture description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceFournis() {
        return this.serviceFournis;
    }

    public Facture serviceFournis(String serviceFournis) {
        this.setServiceFournis(serviceFournis);
        return this;
    }

    public void setServiceFournis(String serviceFournis) {
        this.serviceFournis = serviceFournis;
    }

    public PV getPv() {
        return this.pv;
    }

    public void setPv(PV pV) {
        this.pv = pV;
    }

    public Facture pv(PV pV) {
        this.setPv(pV);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Facture)) {
            return false;
        }
        return id != null && id.equals(((Facture) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Facture{" +
            "id=" + getId() +
            ", dateFacture='" + getDateFacture() + "'" +
            ", description='" + getDescription() + "'" +
            ", serviceFournis='" + getServiceFournis() + "'" +
            "}";
    }
}
