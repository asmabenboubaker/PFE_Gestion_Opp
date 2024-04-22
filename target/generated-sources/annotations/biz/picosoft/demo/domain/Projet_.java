package biz.picosoft.demo.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Projet.class)
public abstract class Projet_ {

	public static volatile SingularAttribute<Projet, String> responsable;
	public static volatile SingularAttribute<Projet, Boolean> JiraProject;
	public static volatile SingularAttribute<Projet, String> description;
	public static volatile SetAttribute<Projet, PV> pvs;
	public static volatile SingularAttribute<Projet, String> type;
	public static volatile SingularAttribute<Projet, String> lienJira;
	public static volatile SingularAttribute<Projet, String> nom;
	public static volatile SetAttribute<Projet, BonDeCommande> bondecommandes;
	public static volatile SingularAttribute<Projet, ZonedDateTime> dateDebut;
	public static volatile SingularAttribute<Projet, ZonedDateTime> derniereMiseAJour;
	public static volatile SingularAttribute<Projet, String> objectif;
	public static volatile SingularAttribute<Projet, Integer> priorite;
	public static volatile SingularAttribute<Projet, String> idJira;
	public static volatile SingularAttribute<Projet, String> commentaires;
	public static volatile SingularAttribute<Projet, Long> id;
	public static volatile SingularAttribute<Projet, ZonedDateTime> dateFin;
	public static volatile SingularAttribute<Projet, String> participants;
	public static volatile SingularAttribute<Projet, Float> budget;
	public static volatile SingularAttribute<Projet, String> lieu;

	public static final String RESPONSABLE = "responsable";
	public static final String JIRA_PROJECT = "JiraProject";
	public static final String DESCRIPTION = "description";
	public static final String PVS = "pvs";
	public static final String TYPE = "type";
	public static final String LIEN_JIRA = "lienJira";
	public static final String NOM = "nom";
	public static final String BONDECOMMANDES = "bondecommandes";
	public static final String DATE_DEBUT = "dateDebut";
	public static final String DERNIERE_MISE_AJOUR = "derniereMiseAJour";
	public static final String OBJECTIF = "objectif";
	public static final String PRIORITE = "priorite";
	public static final String ID_JIRA = "idJira";
	public static final String COMMENTAIRES = "commentaires";
	public static final String ID = "id";
	public static final String DATE_FIN = "dateFin";
	public static final String PARTICIPANTS = "participants";
	public static final String BUDGET = "budget";
	public static final String LIEU = "lieu";

}

