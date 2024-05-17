package biz.picosoft.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "equipe",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String chef;
    private String email;
    private String telephone;
  // many to many with project
  @ManyToMany
  @JoinTable(
          name = "equipe_projet",
          joinColumns = @JoinColumn(name = "equipe_id"),
          inverseJoinColumns = @JoinColumn(name = "projet_id")
  )
  private Set<Projet> projects;
    @ManyToMany
    @JoinTable(
            name = "equipe_opp",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "opp_id")
    )
    private Set<Opportunite> opportunites = new HashSet<>();
    public Set<Opportunite> getOpportunites() {
        return opportunites;
    }

    public void setOpportunites(Set<Opportunite> opportunites) {
        this.opportunites = opportunites;
    }

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

    public Set<Projet> getProjects() {
        return projects;
    }

    public void setProjects(Set<Projet> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return Objects.equals(id, equipe.id) && Objects.equals(nom, equipe.nom) && Objects.equals(description, equipe.description) && Objects.equals(chef, equipe.chef) && Objects.equals(email, equipe.email) && Objects.equals(telephone, equipe.telephone) && Objects.equals(projects, equipe.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, chef, email, telephone, projects);
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", chef='" + chef + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", projects=" + projects +
                '}';
    }
}
