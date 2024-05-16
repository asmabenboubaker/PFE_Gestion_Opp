package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.client.kernel.model.objects.ObjectsDTO;
import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.enumeration.StatutDemande;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DemandeOutputDTO  extends ObjectsDTO implements Serializable {

    private Long id;
    private String decision;
    private String statutDemande;
    private String activityName;

    private Boolean endProcess;
    private String wfProcessID;
    private String assignee;
    private String description;
    private String status;

    private String  fileAccessToken;
    private LocalDate deadline;

    private String source;


    private String commentaires;

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    private Integer securiteLevel;

    private Boolean draft;
    private String wfCurrentComment;
    private String nom;

    private ZonedDateTime dateDeCreation;

    private StatutDemande statut;

    private Set<DomaineDTO> domaines = new HashSet<>();

    private boolean createOpp;

    public boolean isCreateOpp() {
        return createOpp;
    }

    public void setCreateOpp(boolean createOpp) {
        this.createOpp = createOpp;
    }

    private ClientDTO client;
    private Set<Equipe> equipes;

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public String getWfProcessID() {
        return wfProcessID;
    }

    public void setWfProcessID(String wfProcessID) {
        this.wfProcessID = wfProcessID;
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


    public String getDecision() {
        return decision;
    }
    public String getWfCurrentComment() {
        return wfCurrentComment;
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
    public void setWfCurrentComment(String wfCurrentComment) {
        this.wfCurrentComment = wfCurrentComment;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }


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

    public ZonedDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(ZonedDateTime dateDeCreation) {
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
        if (!(o instanceof DemandeOutputDTO)) {
            return false;
        }

        DemandeOutputDTO demandeDTO = (DemandeOutputDTO) o;
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
