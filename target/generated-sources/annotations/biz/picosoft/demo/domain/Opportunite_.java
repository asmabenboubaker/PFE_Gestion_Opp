package biz.picosoft.demo.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Opportunite.class)
public abstract class Opportunite_ {

	public static volatile SetAttribute<Opportunite, Offre> offres;
	public static volatile SingularAttribute<Opportunite, String> identifiant;
	public static volatile SingularAttribute<Opportunite, String> activityName;
	public static volatile SingularAttribute<Opportunite, Boolean> endProcess;
	public static volatile SingularAttribute<Opportunite, String> description;
	public static volatile SingularAttribute<Opportunite, Integer> securiteLevel;
	public static volatile SingularAttribute<Opportunite, Boolean> excludeFromView;
	public static volatile SingularAttribute<Opportunite, Demande> demande;
	public static volatile SingularAttribute<Opportunite, String> nom;
	public static volatile SingularAttribute<Opportunite, ZonedDateTime> createAt;
	public static volatile SingularAttribute<Opportunite, ZonedDateTime> createdBy;
	public static volatile SingularAttribute<Opportunite, String> wfProcessID;
	public static volatile SingularAttribute<Opportunite, Long> id;
	public static volatile SingularAttribute<Opportunite, String> assignee;
	public static volatile SingularAttribute<Opportunite, Long> numberOfattachments;
	public static volatile SingularAttribute<Opportunite, Float> montantEstime;
	public static volatile SingularAttribute<Opportunite, String> oppNumber;
	public static volatile SingularAttribute<Opportunite, String> status;

	public static final String OFFRES = "offres";
	public static final String IDENTIFIANT = "identifiant";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String END_PROCESS = "endProcess";
	public static final String DESCRIPTION = "description";
	public static final String SECURITE_LEVEL = "securiteLevel";
	public static final String EXCLUDE_FROM_VIEW = "excludeFromView";
	public static final String DEMANDE = "demande";
	public static final String NOM = "nom";
	public static final String CREATE_AT = "createAt";
	public static final String CREATED_BY = "createdBy";
	public static final String WF_PROCESS_ID = "wfProcessID";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String NUMBER_OFATTACHMENTS = "numberOfattachments";
	public static final String MONTANT_ESTIME = "montantEstime";
	public static final String OPP_NUMBER = "oppNumber";
	public static final String STATUS = "status";

}

