package biz.picosoft.demo.domain;

import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, ZonedDateTime> end_date;
	public static volatile SingularAttribute<Task, String> subject;
	public static volatile SingularAttribute<Task, String> details;
	public static volatile SingularAttribute<Task, Long> id;
	public static volatile SingularAttribute<Task, String> assignee;
	public static volatile SingularAttribute<Task, String> priority;
	public static volatile SingularAttribute<Task, String> status;
	public static volatile SingularAttribute<Task, ZonedDateTime> start_date;

	public static final String END_DATE = "end_date";
	public static final String SUBJECT = "subject";
	public static final String DETAILS = "details";
	public static final String ID = "id";
	public static final String ASSIGNEE = "assignee";
	public static final String PRIORITY = "priority";
	public static final String STATUS = "status";
	public static final String START_DATE = "start_date";

}

