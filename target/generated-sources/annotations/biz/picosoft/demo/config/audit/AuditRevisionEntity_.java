package biz.picosoft.demo.config.audit;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditRevisionEntity.class)
public abstract class AuditRevisionEntity_ extends org.hibernate.envers.DefaultRevisionEntity_ {

	public static volatile SingularAttribute<AuditRevisionEntity, String> ipAdr;
	public static volatile SingularAttribute<AuditRevisionEntity, String> usr;
	public static volatile SingularAttribute<AuditRevisionEntity, String> uuid;

	public static final String IP_ADR = "ipAdr";
	public static final String USR = "usr";
	public static final String UUID = "uuid";

}

