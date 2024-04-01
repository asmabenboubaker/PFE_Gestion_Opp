package biz.picosoft.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="File_model")
public class FileModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long imageId;
    private String name;
    private String type;
    @Column(length =50000000)
    private byte[] picByte;
//    @ManyToOne
//    @JoinColumn(name = "demande_id")
//    private Demande demande;
    public FileModel(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
