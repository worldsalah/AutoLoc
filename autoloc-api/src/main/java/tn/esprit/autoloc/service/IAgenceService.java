package tn.esprit.autoloc.service;

import java.util.List;
import tn.esprit.autoloc.domain.Agence;

public interface IAgenceService {
    List<Agence> getAll();
    Agence getById(Long id);
    Agence create(Agence agence);
    Agence update(Long id, Agence agence);
    void delete(Long id);
}