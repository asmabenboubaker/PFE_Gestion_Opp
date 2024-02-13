package biz.picosoft.demo.domain;

import biz.picosoft.demo.domain.enumeration.StatutProjet;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PV.class)
public abstract class PV_ {

	public static volatile SingularAttribute<PV, Instant> datePV;
	public static volatile SingularAttribute<PV, Projet> projet;
	public static volatile SetAttribute<PV, Facture> factures;
	public static volatile SingularAttribute<PV, Long> id;
	public static volatile SingularAttribute<PV, String> contenu;
	public static volatile SingularAttribute<PV, StatutProjet> statut;
	public static volatile SingularAttribute<PV, String> participants;

	public static final String DATE_PV = "datePV";
	public static final String PROJET = "projet";
	public static final String FACTURES = "factures";
	public static final String ID = "id";
	public static final String CONTENU = "contenu";
	public static final String STATUT = "statut";
	public static final String PARTICIPANTS = "participants";

}

