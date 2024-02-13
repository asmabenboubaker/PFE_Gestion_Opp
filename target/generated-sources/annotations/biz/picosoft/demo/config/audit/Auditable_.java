package biz.picosoft.demo.config.audit;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Auditable.class)
public abstract class Auditable_ {

	public static volatile SingularAttribute<Auditable, String> sysupdatedBy;
	public static volatile SingularAttribute<Auditable, ZonedDateTime> sysdateCreated;
	public static volatile SingularAttribute<Auditable, String> syscreatedBy;
	public static volatile SingularAttribute<Auditable, ZonedDateTime> sysdateUpdated;

	public static final String SYSUPDATED_BY = "sysupdatedBy";
	public static final String SYSDATE_CREATED = "sysdateCreated";
	public static final String SYSCREATED_BY = "syscreatedBy";
	public static final String SYSDATE_UPDATED = "sysdateUpdated";

}

