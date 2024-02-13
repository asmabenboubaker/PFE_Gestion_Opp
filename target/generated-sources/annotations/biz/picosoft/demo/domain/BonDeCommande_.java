package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutBC;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BonDeCommande.class)
public abstract class BonDeCommande_ {

	public static volatile SingularAttribute<BonDeCommande, Projet> projet;
	public static volatile SingularAttribute<BonDeCommande, Float> montantTotal;
	public static volatile SingularAttribute<BonDeCommande, String> description;
	public static volatile SingularAttribute<BonDeCommande, Long> id;
	public static volatile SingularAttribute<BonDeCommande, Instant> dateCommande;
	public static volatile SingularAttribute<BonDeCommande, StatutBC> statut;
	public static volatile SingularAttribute<BonDeCommande, Offre> offre;

	public static final String PROJET = "projet";
	public static final String MONTANT_TOTAL = "montantTotal";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String DATE_COMMANDE = "dateCommande";
	public static final String STATUT = "statut";
	public static final String OFFRE = "offre";

}

