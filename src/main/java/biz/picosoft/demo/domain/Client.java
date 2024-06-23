package biz.picosoft.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;
import javax.persistence.*;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

/**
 * A Client.
 */
@Entity

@Table(name = "client",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephne")
    private String telephne;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "nom")
    private String nom;
private String pays;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "client" }, allowSetters = true)
    private Set<Facture> factures = new HashSet<>();

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Column(name = "date_inscription")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDate dateInscription;

    @Column(name = "type_client")
    private String typeClient;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "client")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "opportunites", "domaines", "client" }, allowSetters = true)
    private Set<Demande> demandes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Client id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public Client adresse(String adresse) {
        this.setAdresse(adresse);
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephne() {
        return this.telephne;
    }

    public Client telephne(String telephne) {
        this.setTelephne(telephne);
        return this;
    }

    public void setTelephne(String telephne) {
        this.telephne = telephne;
    }

    public String getEmail() {
        return this.email;
    }

    public Client email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return this.description;
    }

    public Client description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return this.nom;
    }

    public Client nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateInscription() {
        return this.dateInscription;
    }

    public Client dateInscription(LocalDate dateInscription) {
        this.setDateInscription(dateInscription);
        return this;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getTypeClient() {
        return this.typeClient;
    }

    public Client typeClient(String typeClient) {
        this.setTypeClient(typeClient);
        return this;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getNotes() {
        return this.notes;
    }

    public Client notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Demande> getDemandes() {
        return this.demandes;
    }

    public void setDemandes(Set<Demande> demandes) {
        if (this.demandes != null) {
            this.demandes.forEach(i -> i.setClient(null));
        }
        if (demandes != null) {
            demandes.forEach(i -> i.setClient(this));
        }
        this.demandes = demandes;
    }

    public Client demandes(Set<Demande> demandes) {
        this.setDemandes(demandes);
        return this;
    }

    public Client addDemande(Demande demande) {
        this.demandes.add(demande);
        demande.setClient(this);
        return this;
    }

    public Client removeDemande(Demande demande) {
        this.demandes.remove(demande);
        demande.setClient(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Client)) {
            return false;
        }
        return id != null && id.equals(((Client) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", adresse='" + getAdresse() + "'" +
            ", telephne='" + getTelephne() + "'" +
            ", email='" + getEmail() + "'" +
            ", description='" + getDescription() + "'" +
            ", nom='" + getNom() + "'" +
            ", dateInscription='" + getDateInscription() + "'" +
            ", typeClient='" + getTypeClient() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
