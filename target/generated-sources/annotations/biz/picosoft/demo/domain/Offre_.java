package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutOffre;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Offre.class)
public abstract class Offre_ {

	public static volatile SingularAttribute<Offre, StatutOffre> statutOffre;
	public static volatile SingularAttribute<Offre, String> offreNumber;
	public static volatile SingularAttribute<Offre, Opportunite> opportunite;
	public static volatile SingularAttribute<Offre, String> identifiant;
	public static volatile SingularAttribute<Offre, String> activityName;
	public static volatile SingularAttribute<Offre, Boolean> endProcess;
	public static volatile SingularAttribute<Offre, String> modePaiement;
	public static volatile SingularAttribute<Offre, String> description;
	public static volatile SingularAttribute<Offre, Float> montant;
	public static volatile SingularAttribute<Offre, Integer> securiteLevel;
	public static volatile SingularAttribute<Offre, Boolean> excludeFromView;
	public static volatile SingularAttribute<Offre, ZonedDateTime> valideJusquA;
	public static volatile SetAttribute<Offre, BonDeCommande> bondecommandes;
	public static volatile SingularAttribute<Offre, ZonedDateTime> dateOffre;
	public static volatile SingularAttribute<Offre, ZonedDateTime> dateLivraison;
	public static volatile SingularAttribute<Offre, String> wfProcessID;
	public static volatile SingularAttribute<Offre, Long> id;
	public static volatile SingularAttribute<Offre, String> assignee;
	public static volatile SingularAttribute<Offre, Long> numberOfattachments;
	public static volatile SingularAttribute<Offre, String> status;

	public static final String STATUT_OFFRE = "statutOffre";
	public static final String OFFRE_NUMBER = "offreNumber";
	public static final String OPPORTUNITE = "opportunite";
	public static final String IDENTIFIANT = "identifiant";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String END_PROCESS = "endProcess";
	public static final String MODE_PAIEMENT = "modePaiement";
	public static final String DESCRIPTION = "description";
	public static final String MONTANT = "montant";
	public static final String SECURITE_LEVEL = "securiteLevel";
	public static final String EXCLUDE_FROM_VIEW = "excludeFromView";
	public static final String VALIDE_JUSQU_A = "valideJusquA";
	public static final String BONDECOMMANDES = "bondecommandes";
	public static final String DATE_OFFRE = "dateOffre";
	public static final String DATE_LIVRAISON = "dateLivraison";
	public static final String WF_PROCESS_ID = "wfProcessID";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String NUMBER_OFATTACHMENTS = "numberOfattachments";
	public static final String STATUS = "status";

}

