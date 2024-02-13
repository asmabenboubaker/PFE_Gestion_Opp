package biz.picosoft.demo.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facture.class)
public abstract class Facture_ {

	public static volatile SingularAttribute<Facture, PV> pv;
	public static volatile SingularAttribute<Facture, String> serviceFournis;
	public static volatile SingularAttribute<Facture, Instant> dateFacture;
	public static volatile SingularAttribute<Facture, String> description;
	public static volatile SingularAttribute<Facture, Long> id;

	public static final String PV = "pv";
	public static final String SERVICE_FOURNIS = "serviceFournis";
	public static final String DATE_FACTURE = "dateFacture";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

