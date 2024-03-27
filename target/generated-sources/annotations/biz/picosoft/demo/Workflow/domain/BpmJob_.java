package biz.picosoft.demo.Workflow.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BpmJob.class)
public abstract class BpmJob_ extends biz.picosoft.demo.config.audit.Auditable_ {

	public static volatile SingularAttribute<BpmJob, Long> classID;
	public static volatile SingularAttribute<BpmJob, String> data;
	public static volatile SingularAttribute<BpmJob, String> processID;
	public static volatile SingularAttribute<BpmJob, String> activityName;
	public static volatile SingularAttribute<BpmJob, Boolean> endProcess;
	public static volatile SingularAttribute<BpmJob, Long> id;
	public static volatile SingularAttribute<BpmJob, String> assignee;
	public static volatile SingularAttribute<BpmJob, Long> objectID;
	public static volatile SingularAttribute<BpmJob, ZonedDateTime> activityDueDate;

	public static final String CLASS_ID = "classID";
	public static final String DATA = "data";
	public static final String PROCESS_ID = "processID";
	public static final String ACTIVITY_NAME = "activityName";
	public static final String END_PROCESS = "endProcess";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String OBJECT_ID = "objectID";
	public static final String ACTIVITY_DUE_DATE = "activityDueDate";

}

