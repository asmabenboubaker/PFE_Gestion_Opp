package biz.picosoft.demo.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facture.class)
public abstract class Facture_ {

	public static volatile SingularAttribute<Facture, PV> pv;
	public static volatile SingularAttribute<Facture, LocalDate> dateFacture;
	public static volatile SingularAttribute<Facture, String> description;
	public static volatile SingularAttribute<Facture, String> nom;
	public static volatile SingularAttribute<Facture, String> uuid;
	public static volatile SingularAttribute<Facture, Boolean> isPaid;
	public static volatile SingularAttribute<Facture, Double> totalAmount;
	public static volatile SetAttribute<Facture, InvoiceItem> invoiceItems;
	public static volatile SingularAttribute<Facture, String> serviceFournis;
	public static volatile SingularAttribute<Facture, String> contactNumber;
	public static volatile SingularAttribute<Facture, Client> client;
	public static volatile SingularAttribute<Facture, String> PaymentMethod;
	public static volatile SingularAttribute<Facture, Long> id;

	public static final String PV = "pv";
	public static final String DATE_FACTURE = "dateFacture";
	public static final String DESCRIPTION = "description";
	public static final String NOM = "nom";
	public static final String UUID = "uuid";
	public static final String IS_PAID = "isPaid";
	public static final String TOTAL_AMOUNT = "totalAmount";
	public static final String INVOICE_ITEMS = "invoiceItems";
	public static final String SERVICE_FOURNIS = "serviceFournis";
	public static final String CONTACT_NUMBER = "contactNumber";
	public static final String CLIENT = "client";
	public static final String PAYMENT_METHOD = "PaymentMethod";
	public static final String ID = "id";

}

