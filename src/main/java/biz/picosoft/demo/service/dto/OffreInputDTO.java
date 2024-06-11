package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.enumeration.StatutOffre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OffreInputDTO  implements Serializable {

    private Long id;

    private Float montant;
    private List<Article> articles;
    private LocalDate dateOffre;

    private String description;

    private LocalDate valideJusquA;

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
    private String wfComment;
    private String msg;

    private String modePaiement;

    private LocalDate dateLivraison;


    private StatutOffre statutOffre;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public StatutOffre getStatutOffre() {
        return statutOffre;
    }

    public void setStatutOffre(StatutOffre statutOffre) {
        this.statutOffre = statutOffre;
    }

    public String getWfComment() {
        return wfComment;
    }

    public void setWfComment(String wfComment) {
        this.wfComment = wfComment;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public LocalDate getDateOffre() {
        return dateOffre;
    }

    public void setDateOffre(LocalDate dateOffre) {
        this.dateOffre = dateOffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getValideJusquA() {
        return valideJusquA;
    }

    public void setValideJusquA(LocalDate valideJusquA) {
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
        if (!(o instanceof OffreInputDTO)) return false;
        OffreInputDTO that = (OffreInputDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getMontant(), that.getMontant()) && Objects.equals(getArticles(), that.getArticles()) && Objects.equals(getDateOffre(), that.getDateOffre()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getValideJusquA(), that.getValideJusquA()) && Objects.equals(getOpportunite(), that.getOpportunite()) && Objects.equals(getDecision(), that.getDecision()) && Objects.equals(getActivityName(), that.getActivityName()) && Objects.equals(getEndProcess(), that.getEndProcess()) && Objects.equals(getWfProcessID(), that.getWfProcessID()) && Objects.equals(getAssignee(), that.getAssignee()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getFileAccessToken(), that.getFileAccessToken()) && Objects.equals(getSecuriteLevel(), that.getSecuriteLevel()) && Objects.equals(getDraft(), that.getDraft()) && Objects.equals(getWfCurrentComment(), that.getWfCurrentComment()) && Objects.equals(getWfComment(), that.getWfComment()) && Objects.equals(getMsg(), that.getMsg()) && Objects.equals(getModePaiement(), that.getModePaiement()) && Objects.equals(getDateLivraison(), that.getDateLivraison()) && getStatutOffre() == that.getStatutOffre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMontant(), getArticles(), getDateOffre(), getDescription(), getValideJusquA(), getOpportunite(), getDecision(), getActivityName(), getEndProcess(), getWfProcessID(), getAssignee(), getStatus(), getFileAccessToken(), getSecuriteLevel(), getDraft(), getWfCurrentComment(), getWfComment(), getMsg(), getModePaiement(), getDateLivraison(), getStatutOffre());
    }

    @Override
    public String toString() {
        return "OffreInputDTO{" +
                "id=" + id +
                ", montant=" + montant +
                ", articles=" + articles +
                ", dateOffre=" + dateOffre +
                ", description='" + description + '\'' +
                ", valideJusquA=" + valideJusquA +
                ", opportunite=" + opportunite +
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
                ", wfComment='" + wfComment + '\'' +
                ", msg='" + msg + '\'' +
                ", modePaiement='" + modePaiement + '\'' +
                ", dateLivraison=" + dateLivraison +
                ", statutOffre=" + statutOffre +
                '}';
    }
}
