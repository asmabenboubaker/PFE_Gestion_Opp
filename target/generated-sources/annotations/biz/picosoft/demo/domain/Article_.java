package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ {

	public static volatile SingularAttribute<Article, Double> prixUnitaire;
	public static volatile SingularAttribute<Article, String> description;
	public static volatile SingularAttribute<Article, Long> id;
	public static volatile SingularAttribute<Article, String> nom;
	public static volatile SingularAttribute<Article, Double> prixTotal;
	public static volatile SingularAttribute<Article, Integer> quantite;
	public static volatile SingularAttribute<Article, Offre> offreDePrix;

	public static final String PRIX_UNITAIRE = "prixUnitaire";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String PRIX_TOTAL = "prixTotal";
	public static final String QUANTITE = "quantite";
	public static final String OFFRE_DE_PRIX = "offreDePrix";

}

