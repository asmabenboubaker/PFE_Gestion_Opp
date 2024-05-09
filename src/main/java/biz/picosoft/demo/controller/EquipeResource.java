package biz.picosoft.demo.controller;


import biz.picosoft.demo.domain.Equipe;
import biz.picosoft.demo.service.EquipeService;
import biz.picosoft.demo.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeResource {

    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.createEquipe(equipe);
    }

    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        return equipeService.updateEquipe(id, equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @PostMapping("/{equipeId}/projets")
    public void affecterProjets(@PathVariable Long equipeId, @RequestBody List<Long> projetIds) {
        equipeService.affecterProjets(equipeId, projetIds);
    }

    @PostMapping("/{projectId}/equipes")
    public void affecterEquipes(@PathVariable Long projectId, @RequestBody List<Long> equipeIds) {
        equipeService.affecterEquipes(projectId, equipeIds);
    }
    @PostMapping("/{oppId}/oppequipes")
    public void affecteroppEquipes(@PathVariable Long oppId, @RequestBody List<Long> equipeIds) {
        equipeService.affecteroppEquipes(oppId, equipeIds);
    }
}
