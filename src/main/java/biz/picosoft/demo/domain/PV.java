package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutProjet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A PV.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pv",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_pv")
    private Instant datePV;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "participants")
    private String participants;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutProjet statut;

    @OneToMany(mappedBy = "pv")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "pv" }, allowSetters = true)
    private Set<Facture> factures = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "bondecommandes", "pvs" }, allowSetters = true)
    private Projet projet;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PV id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatePV() {
        return this.datePV;
    }

    public PV datePV(Instant datePV) {
        this.setDatePV(datePV);
        return this;
    }

    public void setDatePV(Instant datePV) {
        this.datePV = datePV;
    }

    public String getContenu() {
        return this.contenu;
    }

    public PV contenu(String contenu) {
        this.setContenu(contenu);
        return this;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getParticipants() {
        return this.participants;
    }

    public PV participants(String participants) {
        this.setParticipants(participants);
        return this;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public StatutProjet getStatut() {
        return this.statut;
    }

    public PV statut(StatutProjet statut) {
        this.setStatut(statut);
        return this;
    }

    public void setStatut(StatutProjet statut) {
        this.statut = statut;
    }

    public Set<Facture> getFactures() {
        return this.factures;
    }

    public void setFactures(Set<Facture> factures) {
        if (this.factures != null) {
            this.factures.forEach(i -> i.setPv(null));
        }
        if (factures != null) {
            factures.forEach(i -> i.setPv(this));
        }
        this.factures = factures;
    }

    public PV factures(Set<Facture> factures) {
        this.setFactures(factures);
        return this;
    }

    public PV addFacture(Facture facture) {
        this.factures.add(facture);
        facture.setPv(this);
        return this;
    }

    public PV removeFacture(Facture facture) {
        this.factures.remove(facture);
        facture.setPv(null);
        return this;
    }

    public Projet getProjet() {
        return this.projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public PV projet(Projet projet) {
        this.setProjet(projet);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PV)) {
            return false;
        }
        return id != null && id.equals(((PV) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PV{" +
            "id=" + getId() +
            ", datePV='" + getDatePV() + "'" +
            ", contenu='" + getContenu() + "'" +
            ", participants='" + getParticipants() + "'" +
            ", statut='" + getStatut() + "'" +
            "}";
    }
}
