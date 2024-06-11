package biz.picosoft.demo.service.impl;

import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.domain.Offre;
import biz.picosoft.demo.repository.ArticleRepository;
import biz.picosoft.demo.repository.OffreRepository;
import biz.picosoft.demo.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImp {
    private final ArticleRepository articleRepository;

private final OffreService offreDePrixService;
private final OffreRepository offreRepository;
    public ArticleServiceImp(ArticleRepository articleRepository, OffreService offreDePrixService, OffreRepository offreRepository
    ) {
        this.articleRepository = articleRepository;
        this.offreDePrixService = offreDePrixService;
        this.offreRepository = offreRepository;
    }
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }
    public Article createArticle(Article article) {
        // Calculate total price based on quantity and unit price
        article.setPrixTotal(article.getQuantite() * article.getPrixUnitaire());
        return articleRepository.save(article);
    }
    public Article updateArticle(Long id, Article updatedArticle) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            // Update fields
            article.setNom(updatedArticle.getNom());
            article.setQuantite(updatedArticle.getQuantite());
            article.setPrixUnitaire(updatedArticle.getPrixUnitaire());
            // Recalculate total price
            article.setPrixTotal(article.getQuantite() * article.getPrixUnitaire());
            return articleRepository.save(article);
        } else {
            // Handle error when article with given id is not found
            throw new RuntimeException("Article not found with id: " + id);
        }
    }
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public Article createArticleAndAssignToOffreDePrix(Long offreDePrixId, Article article) {
        Offre offreDePrix = offreRepository.findById(offreDePrixId).get();

        article.setOffreDePrix(offreDePrix);

        article.setPrixTotal(article.getPrixUnitaire() * article.getQuantite());

        return articleRepository.save(article);
    }
}
