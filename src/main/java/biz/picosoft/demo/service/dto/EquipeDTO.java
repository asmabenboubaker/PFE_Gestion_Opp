package biz.picosoft.demo.service.dto;

import biz.picosoft.demo.domain.Opportunite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipeDTO implements Serializable {

    private Long id;
    private String nom;
    private String description;
    private String chef;
    private String email;
    private String telephone;
    private Set<Opportunite> opportunites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Opportunite> getOpportunites() {
        return opportunites;
    }

    public void setOpportunites(Set<Opportunite> opportunites) {
        this.opportunites = opportunites;
    }
}
