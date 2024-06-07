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

    private String name;

    private String type;

    private String path;

    @Lob
    private byte[] imageData;
   public Attachment(String filePath) {
        this.path = filePath;
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

    public void setPath(String path) {
        this.path = path;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", idClasse=" + idClasse +
                ", idObject=" + idObject +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attachment)) return false;
        Attachment that = (Attachment) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getIdClasse(), that.getIdClasse()) && Objects.equals(getIdObject(), that.getIdObject()) && Objects.equals(getName(), that.getName()) && Objects.equals(getType(), that.getType()) && Objects.equals(getPath(), that.getPath()) && Arrays.equals(getImageData(), that.getImageData());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getIdClasse(), getIdObject(), getName(), getType(), getPath());
        result = 31 * result + Arrays.hashCode(getImageData());
        return result;
    }
}
