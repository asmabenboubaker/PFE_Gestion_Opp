package biz.picosoft.demo.service.dto;


import biz.picosoft.demo.domain.enumeration.StatutProjet;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.PV} entity.
 */
public class PVDTO implements Serializable {

    private Long id;

    private Instant datePV;

    private String contenu;

    private String participants;

    private StatutProjet statut;

    private ProjetDTO projet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatePV() {
        return datePV;
    }

    public void setDatePV(Instant datePV) {
        this.datePV = datePV;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public StatutProjet getStatut() {
        return statut;
    }

    public void setStatut(StatutProjet statut) {
        this.statut = statut;
    }

    public ProjetDTO getProjet() {
        return projet;
    }

    public void setProjet(ProjetDTO projet) {
        this.projet = projet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PVDTO)) {
            return false;
        }

        PVDTO pVDTO = (PVDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pVDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PVDTO{" +
            "id=" + getId() +
            ", datePV='" + getDatePV() + "'" +
            ", contenu='" + getContenu() + "'" +
            ", participants='" + getParticipants() + "'" +
            ", statut='" + getStatut() + "'" +
            ", projet=" + getProjet() +
            "}";
    }
}
