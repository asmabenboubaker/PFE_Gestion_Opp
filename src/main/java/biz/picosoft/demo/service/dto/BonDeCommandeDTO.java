package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.enumeration.StatutBC;


import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.BonDeCommande} entity.
 */
public class BonDeCommandeDTO implements Serializable {

    private Long id;

    private Float montantTotal;

    private ZonedDateTime dateCommande;

    private String description;

    private StatutBC statut;

    private OffreDTO offre;

    private ProjetDTO projet;
    private String decision;

    private String activityName;

    private Boolean endProcess;
    private String wfProcessID;
    private String assignee;

    private String status;

    private String  fileAccessToken;
    private LocalDate datedelivraison;
    private String servicecommande;
    private String methodedepaiement;

    public LocalDate getDatedelivraison() {
        return datedelivraison;
    }

    public void setDatedelivraison(LocalDate datedelivraison) {
        this.datedelivraison = datedelivraison;
    }

    public String getServicecommande() {
        return servicecommande;
    }

    public void setServicecommande(String servicecommande) {
        this.servicecommande = servicecommande;
    }

    public String getMethodedepaiement() {
        return methodedepaiement;
    }

    public void setMethodedepaiement(String methodedepaiement) {
        this.methodedepaiement = methodedepaiement;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Boolean getEndProcess() {
        return endProcess;
    }

    public void setEndProcess(Boolean endProcess) {
        this.endProcess = endProcess;
    }

    public String getWfProcessID() {
        return wfProcessID;
    }

    public void setWfProcessID(String wfProcessID) {
        this.wfProcessID = wfProcessID;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileAccessToken() {
        return fileAccessToken;
    }

    public void setFileAccessToken(String fileAccessToken) {
        this.fileAccessToken = fileAccessToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Float montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ZonedDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(ZonedDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutBC getStatut() {
        return statut;
    }

    public void setStatut(StatutBC statut) {
        this.statut = statut;
    }

    public OffreDTO getOffre() {
        return offre;
    }

    public void setOffre(OffreDTO offre) {
        this.offre = offre;
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
        if (!(o instanceof BonDeCommandeDTO)) {
            return false;
        }

        BonDeCommandeDTO bonDeCommandeDTO = (BonDeCommandeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bonDeCommandeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BonDeCommandeDTO{" +
            "id=" + getId() +
            ", montantTotal=" + getMontantTotal() +
            ", dateCommande='" + getDateCommande() + "'" +
            ", description='" + getDescription() + "'" +
            ", statut='" + getStatut() + "'" +
            ", offre=" + getOffre() +
            ", projet=" + getProjet() +
            "}";
    }
}
