package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Facture.
 */
@Entity
@Table(name = "facture",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_facture")
    private LocalDate dateFacture;

    @Column(name = "description")
    private String description;

    @Column(name = "service_fournis")
    private String serviceFournis;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<InvoiceItem> invoiceItems = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "factures" }, allowSetters = true)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Facture addInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItems.add(invoiceItem);
        invoiceItem.setFacture(this);
        return this;
    }

    public Facture removeInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItems.remove(invoiceItem);
        invoiceItem.setFacture(null);
        return this;
    }
    @Transient
    private boolean isGenerate;
    // getter and setter isGenerate
    public void setIsGenerate(boolean isGenerate) {
        this.isGenerate = isGenerate;
    }
    public boolean getIsGenerate() {
        return isGenerate;
    }
    private String nom;
    // getter et setter nom
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
private String PaymentMethod;
// getter et setter paymetMethod
    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }
    public String getPaymentMethod() {
        return PaymentMethod;
    }
    private double totalAmount;
    //getter and setter totalAmount
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    private String contactNumber;
    // getter and setter contactNumber
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    private String uuid;
    // getter and setter uuid
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUuid() {
        return uuid;
    }
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

    public LocalDate getDateFacture() {
        return this.dateFacture;
    }

    public Facture dateFacture(LocalDate dateFacture) {
        this.setDateFacture(dateFacture);
        return this;
    }

    public void setDateFacture(LocalDate dateFacture) {
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
