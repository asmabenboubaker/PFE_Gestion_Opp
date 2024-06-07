package biz.picosoft.demo.service.impl;


import biz.picosoft.demo.domain.EtudeOpp;
import biz.picosoft.demo.domain.TacheOpp;
import biz.picosoft.demo.repository.EtudeOppRepository;
import biz.picosoft.demo.repository.TacheRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TacheServiceImp {
    private final TacheRepo tacheRepo;
private final EtudeOppRepository etudeOppRepository;

    public TacheServiceImp(TacheRepo taskRepository,
                           EtudeOppRepository etudeOppRepository
    ) {
        this.tacheRepo = taskRepository;
        this.etudeOppRepository = etudeOppRepository;

    }
    public void addTacheToEtude(Long etudeId, TacheOpp tacheOpp) {
        EtudeOpp etudeOpp = etudeOppRepository.findById(etudeId)
                .orElseThrow(() -> new IllegalArgumentException("L'étude avec l'ID fourni n'existe pas"));

        // Assurez-vous que la tâche n'est pas déjà associée à une étude
        if (tacheOpp.getEtudeOpp() != null) {
            throw new IllegalArgumentException("La tâche est déjà associée à une étude");
        }

        // Associez la tâche à l'étude et enregistrez-la
        tacheOpp.setEtudeOpp(etudeOpp);
        tacheRepo.save(tacheOpp);
    }
    public List<TacheOpp> findTachesByEtudeId(Long etudeId) {
        return tacheRepo.findByEtudeOppId(etudeId);
    }
    //add tache
    public TacheOpp save(TacheOpp tacheOpp) {
        return tacheRepo.save(tacheOpp);
    }
}
