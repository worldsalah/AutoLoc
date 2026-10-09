package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;
import tn.esprit.autoloc.service.IEmployeService;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;

    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable : " + id));
    }

    @Override
    public Employe create(Employe employe) {
        employe.setId(null);
        return employeRepository.save(employe);
    }

    @Override
    public Employe update(Long id, Employe employe) {
        getById(id);
        employe.setId(id);
        return employeRepository.save(employe);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        employeRepository.deleteById(id);
    }
}