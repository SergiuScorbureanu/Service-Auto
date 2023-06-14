package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Client;
import ro.pao.repository.implementations.ClientRepositoryImpl;
import ro.pao.service.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class ClientServiceImpl implements ClientService {

    private final ClientRepositoryImpl clientRepository;

    @Override
    public void addClient(Client client) {
        clientRepository.addNewClient(client);
    }

    @Override
    public void addAllFromClientsList(List<Client> clientList) {
        clientRepository.addAllFromClientsList(clientList);
    }

    @Override
    public Optional<Client> getClientById(UUID id) {
        return clientRepository.getClientById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    @Override
    public void deleteClientsById(UUID id) {
        clientRepository.deleteClient(id);
    }

    @Override
    public void updateClientsById(UUID id, Client newClient) {
        clientRepository.updateClientsById(id, newClient);
    }
}