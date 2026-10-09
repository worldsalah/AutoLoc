package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;
import tn.esprit.autoloc.service.IClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + id));
    }

    @Override
    public Client create(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        getById(id);
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        clientRepository.deleteById(id);
    }
}