package biz.picosoft.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Client} entity.
 */
public class ClientDTO implements Serializable {

    private Long id;

    private String adresse;

    private String telephne;

    private String email;

    private String description;

    private String nom;
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private LocalDate  dateInscription;

    private String typeClient;

    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephne() {
        return telephne;
    }

    public void setTelephne(String telephne) {
        this.telephne = telephne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate  dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClientDTO)) {
            return false;
        }

        ClientDTO clientDTO = (ClientDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClientDTO{" +
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
