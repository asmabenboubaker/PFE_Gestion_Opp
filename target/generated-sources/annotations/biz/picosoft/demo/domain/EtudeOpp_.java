package biz.picosoft.demo.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EtudeOpp.class)
public abstract class EtudeOpp_ {

	public static volatile SingularAttribute<EtudeOpp, String> nature;
	public static volatile SingularAttribute<EtudeOpp, String> specialite;
	public static volatile SingularAttribute<EtudeOpp, LocalDate> dateDebut;
	public static volatile SingularAttribute<EtudeOpp, String> complexite;
	public static volatile SingularAttribute<EtudeOpp, Opportunite> opportunite;
	public static volatile SetAttribute<EtudeOpp, TacheOpp> tachesOpp;
	public static volatile SingularAttribute<EtudeOpp, String> responsableEtude;
	public static volatile SingularAttribute<EtudeOpp, String> description;
	public static volatile SingularAttribute<EtudeOpp, Long> id;
	public static volatile SingularAttribute<EtudeOpp, Long> nbreHours;

	public static final String NATURE = "nature";
	public static final String SPECIALITE = "specialite";
	public static final String DATE_DEBUT = "dateDebut";
	public static final String COMPLEXITE = "complexite";
	public static final String OPPORTUNITE = "opportunite";
	public static final String TACHES_OPP = "tachesOpp";
	public static final String RESPONSABLE_ETUDE = "responsableEtude";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String NBRE_HOURS = "nbreHours";

}

