package tn.esprit.autoloc.service;

import java.util.List;
import tn.esprit.autoloc.domain.Contrat;

public interface IContratService {
    List<Contrat> getAll();
    Contrat getById(Long id);
    Contrat create(Contrat contrat);
    Contrat update(Long id, Contrat contrat);
    void delete(Long id);
}