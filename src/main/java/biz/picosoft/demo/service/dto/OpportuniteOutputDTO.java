package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.client.kernel.model.objects.ObjectsDTO;
import biz.picosoft.demo.domain.Equipe;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

public class OpportuniteOutputDTO extends ObjectsDTO implements Serializable {
    private Long id;

    private String description;

    private String nom;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ZonedDateTime createdBy;

    private ZonedDateTime createAt;

    private Float montantEstime;
    private String wfComment;

    public String getWfComment() {
        return wfComment;
    }

    public void setWfComment(String wfComment) {
        this.wfComment = wfComment;
    }

    private DemandeDTO demande;
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

    private Set<Equipe> equipes;

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ZonedDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ZonedDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    public Float getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(Float montantEstime) {
        this.montantEstime = montantEstime;
    }

    public DemandeDTO getDemande() {
        return demande;
    }

    public void setDemande(DemandeDTO demande) {
        this.demande = demande;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpportuniteOutputDTO that = (OpportuniteOutputDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(nom, that.nom) && Objects.equals(msg, that.msg) && Objects.equals(createdBy, that.createdBy) && Objects.equals(createAt, that.createAt) && Objects.equals(montantEstime, that.montantEstime) && Objects.equals(wfComment, that.wfComment) && Objects.equals(demande, that.demande) && Objects.equals(decision, that.decision) && Objects.equals(activityName, that.activityName) && Objects.equals(endProcess, that.endProcess) && Objects.equals(wfProcessID, that.wfProcessID) && Objects.equals(assignee, that.assignee) && Objects.equals(status, that.status) && Objects.equals(fileAccessToken, that.fileAccessToken) && Objects.equals(securiteLevel, that.securiteLevel) && Objects.equals(draft, that.draft) && Objects.equals(wfCurrentComment, that.wfCurrentComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, nom, msg, createdBy, createAt, montantEstime, wfComment, demande, decision, activityName, endProcess, wfProcessID, assignee, status, fileAccessToken, securiteLevel, draft, wfCurrentComment);
    }

    @Override
    public String toString() {
        return "OpportuniteInputDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", createdBy=" + createdBy +
                ", createAt=" + createAt +
                ", montantEstime=" + montantEstime +
                ", demande=" + demande +
                ", decision='" + decision + '\'' +
                ", activityName='" + activityName + '\'' +
                ", endProcess=" + endProcess +
                ", wfProcessID='" + wfProcessID + '\'' +
                ", assignee='" + assignee + '\'' +
                ", status='" + status + '\'' +
                ", fileAccessToken='" + fileAccessToken + '\'' +
                ", securiteLevel=" + securiteLevel +
                ", draft=" + draft +
                ", wfCurrentComment='" + wfCurrentComment + '\'' +
                '}';
    }
}
