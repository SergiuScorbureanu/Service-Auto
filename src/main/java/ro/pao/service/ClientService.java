package ro.pao.service;

import ro.pao.model.Client;
import ro.pao.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    void addClient(Client client);

    void addAllClientsFromList(List<Client> clientList);

    Optional<Client> getClientById(UUID id);

    List<Client> getAllClients();

    void deleteClientsById(UUID id);

    void updateClientsById(UUID id, Client newClient);

}
