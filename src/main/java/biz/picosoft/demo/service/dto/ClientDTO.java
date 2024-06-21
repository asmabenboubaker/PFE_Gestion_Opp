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
    private String pays;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

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
        if (this == o) return true;
        if (!(o instanceof ClientDTO)) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(getId(), clientDTO.getId()) && Objects.equals(getAdresse(), clientDTO.getAdresse()) && Objects.equals(getTelephne(), clientDTO.getTelephne()) && Objects.equals(getPays(), clientDTO.getPays()) && Objects.equals(getEmail(), clientDTO.getEmail()) && Objects.equals(getDescription(), clientDTO.getDescription()) && Objects.equals(getNom(), clientDTO.getNom()) && Objects.equals(getDateInscription(), clientDTO.getDateInscription()) && Objects.equals(getTypeClient(), clientDTO.getTypeClient()) && Objects.equals(getNotes(), clientDTO.getNotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdresse(), getTelephne(), getPays(), getEmail(), getDescription(), getNom(), getDateInscription(), getTypeClient(), getNotes());
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", telephne='" + telephne + '\'' +
                ", pays='" + pays + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", dateInscription=" + dateInscription +
                ", typeClient='" + typeClient + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
