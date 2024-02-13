package biz.picosoft.demo.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Offre.class)
public abstract class Offre_ {

	public static volatile SingularAttribute<Offre, Instant> valideJusquA;
	public static volatile SetAttribute<Offre, BonDeCommande> bondecommandes;
	public static volatile SingularAttribute<Offre, Opportunite> opportunite;
	public static volatile SingularAttribute<Offre, Instant> dateOffre;
	public static volatile SingularAttribute<Offre, String> description;
	public static volatile SingularAttribute<Offre, Float> montant;
	public static volatile SingularAttribute<Offre, Long> id;

	public static final String VALIDE_JUSQU_A = "valideJusquA";
	public static final String BONDECOMMANDES = "bondecommandes";
	public static final String OPPORTUNITE = "opportunite";
	public static final String DATE_OFFRE = "dateOffre";
	public static final String DESCRIPTION = "description";
	public static final String MONTANT = "montant";
	public static final String ID = "id";

}

