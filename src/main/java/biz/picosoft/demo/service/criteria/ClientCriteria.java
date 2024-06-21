package biz.picosoft.demo.service.criteria;

import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link biz.picosoft.demo.domain.Client} entity. This class is used
 * in {@link biz.picosoft.demo.controller.ClientResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /clients?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class ClientCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter adresse;

    private StringFilter telephne;

    private StringFilter email;

    private StringFilter description;

    private StringFilter nom;
    private StringFilter pays;

    public StringFilter getPays() {
        return pays;
    }

    public void setPays(StringFilter pays) {
        this.pays = pays;
    }

    private InstantFilter dateInscription;

    private StringFilter typeClient;

    private StringFilter notes;

    private LongFilter demandeId;

    private Boolean distinct;

    public ClientCriteria() {}

    public ClientCriteria(ClientCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.adresse = other.adresse == null ? null : other.adresse.copy();
        this.telephne = other.telephne == null ? null : other.telephne.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.nom = other.nom == null ? null : other.nom.copy();
        this.dateInscription = other.dateInscription == null ? null : other.dateInscription.copy();
        this.typeClient = other.typeClient == null ? null : other.typeClient.copy();
        this.notes = other.notes == null ? null : other.notes.copy();
        this.demandeId = other.demandeId == null ? null : other.demandeId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public ClientCriteria copy() {
        return new ClientCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAdresse() {
        return adresse;
    }

    public StringFilter adresse() {
        if (adresse == null) {
            adresse = new StringFilter();
        }
        return adresse;
    }

    public void setAdresse(StringFilter adresse) {
        this.adresse = adresse;
    }

    public StringFilter getTelephne() {
        return telephne;
    }

    public StringFilter telephne() {
        if (telephne == null) {
            telephne = new StringFilter();
        }
        return telephne;
    }

    public void setTelephne(StringFilter telephne) {
        this.telephne = telephne;
    }

    public StringFilter getEmail() {
        return email;
    }

    public StringFilter email() {
        if (email == null) {
            email = new StringFilter();
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public StringFilter getDescription() {
        return description;
    }

    public StringFilter description() {
        if (description == null) {
            description = new StringFilter();
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public StringFilter getNom() {
        return nom;
    }

    public StringFilter nom() {
        if (nom == null) {
            nom = new StringFilter();
        }
        return nom;
    }

    public void setNom(StringFilter nom) {
        this.nom = nom;
    }

    public InstantFilter getDateInscription() {
        return dateInscription;
    }

    public InstantFilter dateInscription() {
        if (dateInscription == null) {
            dateInscription = new InstantFilter();
        }
        return dateInscription;
    }

    public void setDateInscription(InstantFilter dateInscription) {
        this.dateInscription = dateInscription;
    }

    public StringFilter getTypeClient() {
        return typeClient;
    }

    public StringFilter typeClient() {
        if (typeClient == null) {
            typeClient = new StringFilter();
        }
        return typeClient;
    }

    public void setTypeClient(StringFilter typeClient) {
        this.typeClient = typeClient;
    }

    public StringFilter getNotes() {
        return notes;
    }

    public StringFilter notes() {
        if (notes == null) {
            notes = new StringFilter();
        }
        return notes;
    }

    public void setNotes(StringFilter notes) {
        this.notes = notes;
    }

    public LongFilter getDemandeId() {
        return demandeId;
    }

    public LongFilter demandeId() {
        if (demandeId == null) {
            demandeId = new LongFilter();
        }
        return demandeId;
    }

    public void setDemandeId(LongFilter demandeId) {
        this.demandeId = demandeId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ClientCriteria that = (ClientCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(adresse, that.adresse) &&
            Objects.equals(telephne, that.telephne) &&
            Objects.equals(email, that.email) &&
            Objects.equals(description, that.description) &&
            Objects.equals(nom, that.nom) &&
            Objects.equals(dateInscription, that.dateInscription) &&
            Objects.equals(typeClient, that.typeClient) &&
            Objects.equals(notes, that.notes) &&
            Objects.equals(demandeId, that.demandeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adresse, telephne, email, description, nom, dateInscription, typeClient, notes, demandeId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ClientCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (adresse != null ? "adresse=" + adresse + ", " : "") +
            (telephne != null ? "telephne=" + telephne + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            (description != null ? "description=" + description + ", " : "") +
            (nom != null ? "nom=" + nom + ", " : "") +
            (dateInscription != null ? "dateInscription=" + dateInscription + ", " : "") +
            (typeClient != null ? "typeClient=" + typeClient + ", " : "") +
            (notes != null ? "notes=" + notes + ", " : "") +
            (demandeId != null ? "demandeId=" + demandeId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
