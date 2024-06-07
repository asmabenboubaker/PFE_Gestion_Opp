package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<Attachment, Long> {
    Attachment findByName(String name);
}
