package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutDemande;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Demande.class)
public abstract class Demande_ {

	public static volatile SingularAttribute<Demande, String> statutDemande;
	public static volatile SetAttribute<Demande, FileModel> images;
	public static volatile SetAttribute<Demande, Domaine> domaines;
	public static volatile SingularAttribute<Demande, String> identifiant;
	public static volatile SingularAttribute<Demande, String> activityName;
	public static volatile SingularAttribute<Demande, Boolean> endProcess;
	public static volatile SingularAttribute<Demande, String> description;
	public static volatile SingularAttribute<Demande, Integer> securiteLevel;
	public static volatile SingularAttribute<Demande, String> nom;
	public static volatile SingularAttribute<Demande, LocalDate> dateDeCreation;
	public static volatile SetAttribute<Demande, Opportunite> opportunites;
	public static volatile SingularAttribute<Demande, String> wfProcessID;
	public static volatile SingularAttribute<Demande, Client> client;
	public static volatile SingularAttribute<Demande, Long> id;
	public static volatile SingularAttribute<Demande, String> assignee;
	public static volatile SingularAttribute<Demande, StatutDemande> statut;
	public static volatile SingularAttribute<Demande, String> status;

	public static final String STATUT_DEMANDE = "statutDemande";
	public static final String IMAGES = "images";
	public static final String DOMAINES = "domaines";
	public static final String IDENTIFIANT = "identifiant";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String END_PROCESS = "endProcess";
	public static final String DESCRIPTION = "description";
	public static final String SECURITE_LEVEL = "securiteLevel";
	public static final String NOM = "nom";
	public static final String DATE_DE_CREATION = "dateDeCreation";
	public static final String OPPORTUNITES = "opportunites";
	public static final String WF_PROCESS_ID = "wfProcessID";
	public static final String CLIENT = "client";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String STATUT = "statut";
	public static final String STATUS = "status";

}

