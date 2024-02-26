package biz.picosoft.demo.service.dto;



import biz.picosoft.demo.domain.enumeration.StatutDemande;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Demande} entity.
 */
public class DemandeDTO implements Serializable {

    private Long id;

    private String statutDemande;

    private String description;

    private String nom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeCreation;

    private StatutDemande statut;

    private Set<DomaineDTO> domaines = new HashSet<>();

    private ClientDTO client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatutDemande() {
        return statutDemande;
    }

    public void setStatutDemande(String statutDemande) {
        this.statutDemande = statutDemande;
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

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public StatutDemande getStatut() {
        return statut;
    }

    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }

    public Set<DomaineDTO> getDomaines() {
        return domaines;
    }

    public void setDomaines(Set<DomaineDTO> domaines) {
        this.domaines = domaines;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DemandeDTO)) {
            return false;
        }

        DemandeDTO demandeDTO = (DemandeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, demandeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DemandeDTO{" +
            "id=" + getId() +
            ", statutDemande='" + getStatutDemande() + "'" +
            ", description='" + getDescription() + "'" +
            ", nom='" + getNom() + "'" +
            ", dateDeCreation='" + getDateDeCreation() + "'" +
            ", statut='" + getStatut() + "'" +
            ", domaines=" + getDomaines() +
            ", client=" + getClient() +
            "}";
    }
}
