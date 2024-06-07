package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<Attachment, Long> {
    Attachment findByName(String name);

    @Override
    List<Attachment> findAll();

  //findByIdClasseAndIdObject
    List<Attachment> findByIdClasseAndIdObject(Long idClasse, Long idObject);
}
