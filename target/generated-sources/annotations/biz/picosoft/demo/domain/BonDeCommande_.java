package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutBC;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BonDeCommande.class)
public abstract class BonDeCommande_ {

	public static volatile SingularAttribute<BonDeCommande, String> statutDemande;
	public static volatile SingularAttribute<BonDeCommande, String> methodedepaiement;
	public static volatile SingularAttribute<BonDeCommande, Float> montantTotal;
	public static volatile SingularAttribute<BonDeCommande, String> identifiant;
	public static volatile SingularAttribute<BonDeCommande, String> activityName;
	public static volatile SingularAttribute<BonDeCommande, Boolean> endProcess;
	public static volatile SingularAttribute<BonDeCommande, String> description;
	public static volatile SingularAttribute<BonDeCommande, String> demandeNumber;
	public static volatile SingularAttribute<BonDeCommande, ZonedDateTime> dateCommande;
	public static volatile SingularAttribute<BonDeCommande, Integer> securiteLevel;
	public static volatile SingularAttribute<BonDeCommande, Boolean> excludeFromView;
	public static volatile SingularAttribute<BonDeCommande, Offre> offre;
	public static volatile SingularAttribute<BonDeCommande, LocalDate> datedelivraison;
	public static volatile SingularAttribute<BonDeCommande, Projet> projet;
	public static volatile SingularAttribute<BonDeCommande, String> wfProcessID;
	public static volatile SingularAttribute<BonDeCommande, String> servicecommande;
	public static volatile SingularAttribute<BonDeCommande, Long> id;
	public static volatile SingularAttribute<BonDeCommande, String> assignee;
	public static volatile SingularAttribute<BonDeCommande, Long> numberOfattachments;
	public static volatile SingularAttribute<BonDeCommande, StatutBC> statut;
	public static volatile SingularAttribute<BonDeCommande, String> status;

	public static final String STATUT_DEMANDE = "statutDemande";
	public static final String METHODEDEPAIEMENT = "methodedepaiement";
	public static final String MONTANT_TOTAL = "montantTotal";
	public static final String IDENTIFIANT = "identifiant";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String END_PROCESS = "endProcess";
	public static final String DESCRIPTION = "description";
	public static final String DEMANDE_NUMBER = "demandeNumber";
	public static final String DATE_COMMANDE = "dateCommande";
	public static final String SECURITE_LEVEL = "securiteLevel";
	public static final String EXCLUDE_FROM_VIEW = "excludeFromView";
	public static final String OFFRE = "offre";
	public static final String DATEDELIVRAISON = "datedelivraison";
	public static final String PROJET = "projet";
	public static final String WF_PROCESS_ID = "wfProcessID";
	public static final String SERVICECOMMANDE = "servicecommande";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String NUMBER_OFATTACHMENTS = "numberOfattachments";
	public static final String STATUT = "statut";
	public static final String STATUS = "status";

}

