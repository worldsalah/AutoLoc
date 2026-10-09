package tn.esprit.autoloc.service;

import java.util.List;
import tn.esprit.autoloc.domain.Employe;

public interface IEmployeService {
    List<Employe> getAll();
    Employe getById(Long id);
    Employe create(Employe employe);
    Employe update(Long id, Employe employe);
    void delete(Long id);
}