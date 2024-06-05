package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TacheOpp.class)
public abstract class TacheOpp_ {

	public static volatile SingularAttribute<TacheOpp, EtudeOpp> etudeOpp;
	public static volatile SingularAttribute<TacheOpp, String> description;
	public static volatile SingularAttribute<TacheOpp, Long> id;
	public static volatile SingularAttribute<TacheOpp, String> nom;
	public static volatile SingularAttribute<TacheOpp, Long> nbreHours;

	public static final String ETUDE_OPP = "etudeOpp";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String NBRE_HOURS = "nbreHours";

}

