package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.client.kernel.model.objects.ObjectsDTO;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.EtudeOpp;

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
    private String nomDepartement;
    private String sidDepartement;
    private Set<EtudeOpp> etudeOpps;

    public Set<EtudeOpp> getEtudeOpps() {
        return etudeOpps;
    }

    public void setEtudeOpps(Set<EtudeOpp> etudeOpps) {
        this.etudeOpps = etudeOpps;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public String getSidDepartement() {
        return sidDepartement;
    }

    public void setSidDepartement(String sidDepartement) {
        this.sidDepartement = sidDepartement;
    }

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


    private Set<Equipe> equipes ;

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
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
        if (!(o instanceof OpportuniteOutputDTO)) return false;
        OpportuniteOutputDTO that = (OpportuniteOutputDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getNom(), that.getNom()) && Objects.equals(getMsg(), that.getMsg()) && Objects.equals(getNomDepartement(), that.getNomDepartement()) && Objects.equals(getSidDepartement(), that.getSidDepartement()) && Objects.equals(getEtudeOpps(), that.getEtudeOpps()) && Objects.equals(getCreatedBy(), that.getCreatedBy()) && Objects.equals(getCreateAt(), that.getCreateAt()) && Objects.equals(getMontantEstime(), that.getMontantEstime()) && Objects.equals(getWfComment(), that.getWfComment()) && Objects.equals(getEquipes(), that.getEquipes()) && Objects.equals(getDemande(), that.getDemande()) && Objects.equals(getDecision(), that.getDecision()) && Objects.equals(getActivityName(), that.getActivityName()) && Objects.equals(getEndProcess(), that.getEndProcess()) && Objects.equals(getWfProcessID(), that.getWfProcessID()) && Objects.equals(getAssignee(), that.getAssignee()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getFileAccessToken(), that.getFileAccessToken()) && Objects.equals(getSecuriteLevel(), that.getSecuriteLevel()) && Objects.equals(getDraft(), that.getDraft()) && Objects.equals(getWfCurrentComment(), that.getWfCurrentComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getNom(), getMsg(), getNomDepartement(), getSidDepartement(), getEtudeOpps(), getCreatedBy(), getCreateAt(), getMontantEstime(), getWfComment(), getEquipes(), getDemande(), getDecision(), getActivityName(), getEndProcess(), getWfProcessID(), getAssignee(), getStatus(), getFileAccessToken(), getSecuriteLevel(), getDraft(), getWfCurrentComment());
    }

    @Override
    public String toString() {
        return "OpportuniteOutputDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nom='" + nom + '\'' +
                ", msg='" + msg + '\'' +
                ", nomDepartement='" + nomDepartement + '\'' +
                ", sidDepartement='" + sidDepartement + '\'' +
                ", etudeOpps=" + etudeOpps +
                ", createdBy=" + createdBy +
                ", createAt=" + createAt +
                ", montantEstime=" + montantEstime +
                ", wfComment='" + wfComment + '\'' +
                ", equipes=" + equipes +
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
