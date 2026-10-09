package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;
import tn.esprit.autoloc.service.IPaiementService;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement getById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + id));
    }

    @Override
    public Paiement create(Paiement paiement) {
        paiement.setId(null);
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement update(Long id, Paiement paiement) {
        getById(id);
        paiement.setId(id);
        return paiementRepository.save(paiement);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        paiementRepository.deleteById(id);
    }
}