package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EtudeOpp.class)
public abstract class EtudeOpp_ {

	public static volatile SingularAttribute<EtudeOpp, String> evaluation;
	public static volatile SingularAttribute<EtudeOpp, String> specialite;
	public static volatile SingularAttribute<EtudeOpp, String> complexite;
	public static volatile SingularAttribute<EtudeOpp, Opportunite> opportunite;
	public static volatile SingularAttribute<EtudeOpp, Long> id;
	public static volatile SingularAttribute<EtudeOpp, String> membres;
	public static volatile SingularAttribute<EtudeOpp, Long> nbreHours;
	public static volatile SingularAttribute<EtudeOpp, String> nomEquipe;

	public static final String EVALUATION = "evaluation";
	public static final String SPECIALITE = "specialite";
	public static final String COMPLEXITE = "complexite";
	public static final String OPPORTUNITE = "opportunite";
	public static final String ID = "id";
	public static final String MEMBRES = "membres";
	public static final String NBRE_HOURS = "nbreHours";
	public static final String NOM_EQUIPE = "nomEquipe";

}

