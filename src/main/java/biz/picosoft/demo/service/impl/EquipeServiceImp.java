package biz.picosoft.demo.service.impl;


import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.domain.Projet;
import biz.picosoft.demo.repository.EquipeRepository;
import biz.picosoft.demo.repository.ProjetRepository;
import biz.picosoft.demo.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EquipeServiceImp implements EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;
@Autowired
private ProjetRepository projectRepository;

    @Override
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Long id, Equipe equipe) {
        equipe.setId(id);
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).orElse(null);

    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public void affecterProjets(Long equipeId, List<Long> projetIds) {
        Equipe equipe = equipeRepository.findById(equipeId).orElse(null);
        if (equipe != null) {
            List<Projet> projets = projectRepository.findAllById(projetIds);
            equipe.setProjects(new HashSet<>(projets));
            equipeRepository.save(equipe);
        }
    }

    @Override
    public void affecterEquipes(Long projetId, List<Long> equipeIds) {
        Projet project = projectRepository.findById(projetId).orElse(null);
        if (project != null) {
            List<Equipe> equipeList = equipeRepository.findAllById(equipeIds);
            Set<Equipe> equipes = new HashSet<>(equipeList);
            project.setEquipes(equipes);
            projectRepository.save(project);
        }
    }
}
