package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Client;
import ro.pao.model.Employee;
import ro.pao.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ClientServiceImpl implements ClientService {

    private static List<Client> clientsList = new ArrayList<>();

    @Override
    public void addClient(Client client) {
        clientsList.add(client);
    }

    @Override
    public void addAllClientsFromList(List<Client> clientList) {
        clientsList.addAll(clientList);
    }

    @Override
    public Optional<Client> getClientById(UUID id) {
        return clientsList.stream()
                .filter(client -> id.equals(client.getId()))
                .findFirst();
    }

    @Override
    public List<Client> getAllClients() {
        return clientsList;
    }

    @Override
    public void deleteClientsById(UUID id) {
        clientsList = clientsList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateClientsById(UUID id, Client newClient) {
        Optional<Client> client = this.getClientById(id);
        if (client.isPresent()) {
            deleteClientsById(id);
            newClient.setId(id);
            addClient(newClient);
        }
    }
}
