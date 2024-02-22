package biz.picosoft.demo.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, String> notes;
	public static volatile SingularAttribute<Client, String> telephne;
	public static volatile SingularAttribute<Client, LocalDate> dateInscription;
	public static volatile SingularAttribute<Client, String> typeClient;
	public static volatile SingularAttribute<Client, String> adresse;
	public static volatile SingularAttribute<Client, String> description;
	public static volatile SingularAttribute<Client, Long> id;
	public static volatile SetAttribute<Client, Demande> demandes;
	public static volatile SingularAttribute<Client, String> nom;
	public static volatile SingularAttribute<Client, String> email;

	public static final String NOTES = "notes";
	public static final String TELEPHNE = "telephne";
	public static final String DATE_INSCRIPTION = "dateInscription";
	public static final String TYPE_CLIENT = "typeClient";
	public static final String ADRESSE = "adresse";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String DEMANDES = "demandes";
	public static final String NOM = "nom";
	public static final String EMAIL = "email";

}

