package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "invoice_item", schema = "opportunite")
public class InvoiceItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_details")
    private String itemDetails;

    @Column(name = "item_information")
    private String itemInformation;

    @Column(name = "item_cost")
    private double itemCost;

    @Column(name = "item_qty")
    private int itemQty;

    @ManyToOne
    @JsonIgnoreProperties("invoiceItems")
    private Facture facture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getItemInformation() {
        return itemInformation;
    }

    public void setItemInformation(String itemInformation) {
        this.itemInformation = itemInformation;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "id=" + id +
                ", itemDetails='" + itemDetails + '\'' +
                ", itemInformation='" + itemInformation + '\'' +
                ", itemCost=" + itemCost +
                ", itemQty=" + itemQty +
                ", facture=" + facture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItem)) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Double.compare(getItemCost(), that.getItemCost()) == 0 && getItemQty() == that.getItemQty() && Objects.equals(getId(), that.getId()) && Objects.equals(getItemDetails(), that.getItemDetails()) && Objects.equals(getItemInformation(), that.getItemInformation()) && Objects.equals(getFacture(), that.getFacture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemDetails(), getItemInformation(), getItemCost(), getItemQty(), getFacture());
    }
}
