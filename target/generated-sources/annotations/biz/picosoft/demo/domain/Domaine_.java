package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Domaine.class)
public abstract class Domaine_ {

	public static volatile SingularAttribute<Domaine, String> description;
	public static volatile SingularAttribute<Domaine, Long> id;
	public static volatile SetAttribute<Domaine, Demande> demandes;
	public static volatile SingularAttribute<Domaine, String> nom;

	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String DEMANDES = "demandes";
	public static final String NOM = "nom";

}

