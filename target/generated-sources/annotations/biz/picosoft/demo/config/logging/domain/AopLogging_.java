package biz.picosoft.demo.config.logging.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AopLogging.class)
public abstract class AopLogging_ {

	public static volatile SingularAttribute<AopLogging, Long> duration;
	public static volatile SingularAttribute<AopLogging, String> uniteName;
	public static volatile SingularAttribute<AopLogging, String> packageFullName;
	public static volatile SingularAttribute<AopLogging, String> microserviceName;
	public static volatile SingularAttribute<AopLogging, String> methodName;
	public static volatile SingularAttribute<AopLogging, Long> id;
	public static volatile SingularAttribute<AopLogging, String> userName;
	public static volatile SingularAttribute<AopLogging, String> uuid;
	public static volatile SingularAttribute<AopLogging, String> packageTitle;

	public static final String DURATION = "duration";
	public static final String UNITE_NAME = "uniteName";
	public static final String PACKAGE_FULL_NAME = "packageFullName";
	public static final String MICROSERVICE_NAME = "microserviceName";
	public static final String METHOD_NAME = "methodName";
	public static final String ID = "id";
	public static final String USER_NAME = "userName";
	public static final String UUID = "uuid";
	public static final String PACKAGE_TITLE = "packageTitle";

}

