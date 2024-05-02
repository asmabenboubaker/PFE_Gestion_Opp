package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.enumeration.StatutBC;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class BCInputDTO  implements Serializable {

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BCInputDTO that = (BCInputDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(montantTotal, that.montantTotal) && Objects.equals(dateCommande, that.dateCommande) && Objects.equals(description, that.description) && statut == that.statut && Objects.equals(offre, that.offre) && Objects.equals(projet, that.projet);
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
