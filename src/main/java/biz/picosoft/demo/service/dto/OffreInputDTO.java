package biz.picosoft.demo.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;

public class OffreInputDTO  implements Serializable {

    private Long id;

    private Float montant;

    private ZonedDateTime dateOffre;

    private String description;

    private ZonedDateTime valideJusquA;

    private OpportuniteDTO opportunite;
    // process
    private String decision;

    private String activityName;

    private Boolean endProcess;
    private String wfProcessID;
    private String assignee;

    private String status;

    private String  fileAccessToken;

    private Integer securiteLevel;

    private Boolean draft;
    private String wfCurrentComment;

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

    public Integer getSecuriteLevel() {
        return securiteLevel;
    }

    public void setSecuriteLevel(Integer securiteLevel) {
        this.securiteLevel = securiteLevel;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public String getWfCurrentComment() {
        return wfCurrentComment;
    }

    public void setWfCurrentComment(String wfCurrentComment) {
        this.wfCurrentComment = wfCurrentComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public ZonedDateTime getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(ZonedDateTime dateOffre) {
        this.dateOffre = dateOffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getValideJusquA() {
        return valideJusquA;
    }

    public void setValideJusquA(ZonedDateTime valideJusquA) {
        this.valideJusquA = valideJusquA;
    }

    public OpportuniteDTO getOpportunite() {
        return opportunite;
    }

    public void setOpportunite(OpportuniteDTO opportunite) {
        this.opportunite = opportunite;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffreInputDTO that = (OffreInputDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(montant, that.montant) && Objects.equals(dateOffre, that.dateOffre) && Objects.equals(description, that.description) && Objects.equals(valideJusquA, that.valideJusquA) && Objects.equals(opportunite, that.opportunite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant, dateOffre, description, valideJusquA, opportunite);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OffreDTO{" +
                "id=" + getId() +
                ", montant=" + getMontant() +
                ", dateOffre='" + getDateOffre() + "'" +
                ", description='" + getDescription() + "'" +
                ", valideJusquA='" + getValideJusquA() + "'" +
                ", opportunite=" + getOpportunite() +
                "}";
    }
}
