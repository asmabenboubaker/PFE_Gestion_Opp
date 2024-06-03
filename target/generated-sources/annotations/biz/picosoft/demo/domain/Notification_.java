package biz.picosoft.demo.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Notification.class)
public abstract class Notification_ {

	public static volatile SingularAttribute<Notification, String> createdBy;
	public static volatile SingularAttribute<Notification, Long> id;
	public static volatile SingularAttribute<Notification, String> message;
	public static volatile SingularAttribute<Notification, Boolean> seen;
	public static volatile SingularAttribute<Notification, String> url;
	public static volatile SingularAttribute<Notification, String> username;
	public static volatile SingularAttribute<Notification, LocalDate> timestamp;

	public static final String CREATED_BY = "createdBy";
	public static final String ID = "id";
	public static final String MESSAGE = "message";
	public static final String SEEN = "seen";
	public static final String URL = "url";
	public static final String USERNAME = "username";
	public static final String TIMESTAMP = "timestamp";

}

