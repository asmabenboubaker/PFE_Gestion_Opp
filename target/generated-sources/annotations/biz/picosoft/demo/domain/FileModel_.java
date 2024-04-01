package biz.picosoft.demo.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileModel.class)
public abstract class FileModel_ {

	public static volatile SingularAttribute<FileModel, Long> imageId;
	public static volatile SingularAttribute<FileModel, String> name;
	public static volatile SingularAttribute<FileModel, byte[]> picByte;
	public static volatile SingularAttribute<FileModel, String> type;

	public static final String IMAGE_ID = "imageId";
	public static final String NAME = "name";
	public static final String PIC_BYTE = "picByte";
	public static final String TYPE = "type";

}

