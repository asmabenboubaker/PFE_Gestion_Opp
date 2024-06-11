package biz.picosoft.demo.repository;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.TacheOpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
}
