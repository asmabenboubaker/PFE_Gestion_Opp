package biz.picosoft.demo.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Opportunite.class)
public abstract class Opportunite_ {

	public static volatile SingularAttribute<Opportunite, Instant> createdBy;
	public static volatile SetAttribute<Opportunite, Offre> offres;
	public static volatile SingularAttribute<Opportunite, String> description;
	public static volatile SingularAttribute<Opportunite, Long> id;
	public static volatile SingularAttribute<Opportunite, Demande> demande;
	public static volatile SingularAttribute<Opportunite, String> nom;
	public static volatile SingularAttribute<Opportunite, Float> montantEstime;
	public static volatile SingularAttribute<Opportunite, Instant> createAt;

	public static final String CREATED_BY = "createdBy";
	public static final String OFFRES = "offres";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String DEMANDE = "demande";
	public static final String NOM = "nom";
	public static final String MONTANT_ESTIME = "montantEstime";
	public static final String CREATE_AT = "createAt";

}

