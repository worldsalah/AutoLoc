package tn.esprit.autoloc.service;

import java.util.List;
import tn.esprit.autoloc.domain.Paiement;

public interface IPaiementService {
    List<Paiement> getAll();
    Paiement getById(Long id);
    Paiement create(Paiement paiement);
    Paiement update(Long id, Paiement paiement);
    void delete(Long id);
}