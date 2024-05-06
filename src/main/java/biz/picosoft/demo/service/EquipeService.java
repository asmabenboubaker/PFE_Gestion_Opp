package biz.picosoft.demo.service;

import biz.picosoft.demo.domain.Equipe;

import java.util.List;

public interface EquipeService {
    Equipe createEquipe(Equipe equipe);
    Equipe updateEquipe(Long id, Equipe equipe);
    void deleteEquipe(Long id);
    Equipe getEquipeById(Long id);
    List<Equipe> getAllEquipes();
    void affecterProjets(Long equipeId, List<Long> projetIds);
    void affecterEquipes(Long projetId, List<Long> equipeIds);
}
