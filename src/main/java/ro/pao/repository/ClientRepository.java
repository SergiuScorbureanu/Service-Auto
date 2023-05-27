package ro.pao.repository;

import ro.pao.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {

    Optional<Client> getClientById(UUID id);

    void deleteClient(UUID id);

    void updateClientsById(UUID id, Client newClient);

    void addNewClient(Client client);

    List<Client> getAllClients();

    void addAllFromClientsList(List<Client> clientList);
}
