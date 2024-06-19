package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InvoiceItem.class)
public abstract class InvoiceItem_ {

	public static volatile SingularAttribute<InvoiceItem, Integer> itemQty;
	public static volatile SingularAttribute<InvoiceItem, Double> itemCost;
	public static volatile SingularAttribute<InvoiceItem, Facture> facture;
	public static volatile SingularAttribute<InvoiceItem, String> itemDetails;
	public static volatile SingularAttribute<InvoiceItem, String> itemInformation;
	public static volatile SingularAttribute<InvoiceItem, Long> id;

	public static final String ITEM_QTY = "itemQty";
	public static final String ITEM_COST = "itemCost";
	public static final String FACTURE = "facture";
	public static final String ITEM_DETAILS = "itemDetails";
	public static final String ITEM_INFORMATION = "itemInformation";
	public static final String ID = "id";

}

