package biz.picosoft.demo.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Projet.class)
public abstract class Projet_ {

	public static volatile SetAttribute<Projet, BonDeCommande> bondecommandes;
	public static volatile SingularAttribute<Projet, String> responsable;
	public static volatile SingularAttribute<Projet, Instant> dateDebut;
	public static volatile SingularAttribute<Projet, String> description;
	public static volatile SingularAttribute<Projet, Long> id;
	public static volatile SingularAttribute<Projet, Instant> dateFin;
	public static volatile SetAttribute<Projet, PV> pvs;
	public static volatile SingularAttribute<Projet, String> nom;
	public static volatile SingularAttribute<Projet, String> participants;

	public static final String BONDECOMMANDES = "bondecommandes";
	public static final String RESPONSABLE = "responsable";
	public static final String DATE_DEBUT = "dateDebut";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String DATE_FIN = "dateFin";
	public static final String PVS = "pvs";
	public static final String NOM = "nom";
	public static final String PARTICIPANTS = "participants";

}

