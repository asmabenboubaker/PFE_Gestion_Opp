package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attachment.class)
public abstract class Attachment_ {

	public static volatile SingularAttribute<Attachment, byte[]> imageData;
	public static volatile SingularAttribute<Attachment, Long> idClasse;
	public static volatile SingularAttribute<Attachment, String> name;
	public static volatile SingularAttribute<Attachment, Long> idObject;
	public static volatile SingularAttribute<Attachment, Long> id;
	public static volatile SingularAttribute<Attachment, String> type;
	public static volatile SingularAttribute<Attachment, String> url;

	public static final String IMAGE_DATA = "imageData";
	public static final String ID_CLASSE = "idClasse";
	public static final String NAME = "name";
	public static final String ID_OBJECT = "idObject";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String URL = "url";

}

