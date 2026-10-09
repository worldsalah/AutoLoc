package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.service.IAgenceService;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence getById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + id));
    }

    @Override
    public Agence create(Agence agence) {
        agence.setId(null);
        return agenceRepository.save(agence);
    }

    @Override
    public Agence update(Long id, Agence agence) {
        getById(id);
        agence.setId(id);
        return agenceRepository.save(agence);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        agenceRepository.deleteById(id);
    }
}