package ro.pao.service;

import ro.pao.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    void addClient(Client client);

    void addAllFromClientsList(List<Client> clientList);

    Optional<Client> getClientById(UUID id);

    List<Client> getAllClients();

    void deleteClientsById(UUID id);

    void updateClientsById(UUID id, Client newClient);

}
