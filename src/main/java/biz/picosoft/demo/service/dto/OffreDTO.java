package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.enumeration.StatutOffre;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link biz.picosoft.demo.domain.Offre} entity.
 */
public class OffreDTO implements Serializable {

    private Long id;

    private Float montant;

    private LocalDate dateOffre;

    private String description;

    private LocalDate valideJusquA;

    private OpportuniteDTO opportunite;
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

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
    private String modePaiement;

    private LocalDate dateLivraison;


    private StatutOffre statutOffre;

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
        if (!(o instanceof OffreDTO)) return false;
        OffreDTO offreDTO = (OffreDTO) o;
        return Objects.equals(getId(), offreDTO.getId()) && Objects.equals(getMontant(), offreDTO.getMontant()) && Objects.equals(getDateOffre(), offreDTO.getDateOffre()) && Objects.equals(getDescription(), offreDTO.getDescription()) && Objects.equals(getValideJusquA(), offreDTO.getValideJusquA()) && Objects.equals(getOpportunite(), offreDTO.getOpportunite()) && Objects.equals(getArticles(), offreDTO.getArticles()) && Objects.equals(getDecision(), offreDTO.getDecision()) && Objects.equals(getActivityName(), offreDTO.getActivityName()) && Objects.equals(getEndProcess(), offreDTO.getEndProcess()) && Objects.equals(getWfProcessID(), offreDTO.getWfProcessID()) && Objects.equals(getAssignee(), offreDTO.getAssignee()) && Objects.equals(getStatus(), offreDTO.getStatus()) && Objects.equals(getFileAccessToken(), offreDTO.getFileAccessToken()) && Objects.equals(getSecuriteLevel(), offreDTO.getSecuriteLevel()) && Objects.equals(getDraft(), offreDTO.getDraft()) && Objects.equals(getWfCurrentComment(), offreDTO.getWfCurrentComment()) && Objects.equals(getModePaiement(), offreDTO.getModePaiement()) && Objects.equals(getDateLivraison(), offreDTO.getDateLivraison()) && getStatutOffre() == offreDTO.getStatutOffre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMontant(), getDateOffre(), getDescription(), getValideJusquA(), getOpportunite(), getArticles(), getDecision(), getActivityName(), getEndProcess(), getWfProcessID(), getAssignee(), getStatus(), getFileAccessToken(), getSecuriteLevel(), getDraft(), getWfCurrentComment(), getModePaiement(), getDateLivraison(), getStatutOffre());
    }

    @Override
    public String toString() {
        return "OffreDTO{" +
                "id=" + id +
                ", montant=" + montant +
                ", dateOffre=" + dateOffre +
                ", description='" + description + '\'' +
                ", valideJusquA=" + valideJusquA +
                ", opportunite=" + opportunite +
                ", articles=" + articles +
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
                ", modePaiement='" + modePaiement + '\'' +
                ", dateLivraison=" + dateLivraison +
                ", statutOffre=" + statutOffre +
                '}';
    }
}
