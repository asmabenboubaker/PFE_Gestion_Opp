package biz.picosoft.demo.domain;


import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "attachment",schema = "opportunite")
public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idClasse;
    private Long idObject;
private long size;
    private String name;

    private String type;

    private String url;

    @Lob
    @Column(name = "image_data")
    private byte[] imageData;
   public Attachment(String filePath) {
        this.url = filePath;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public void setIdObject(Long idObject) {
        this.idObject = idObject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }



    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }




}
