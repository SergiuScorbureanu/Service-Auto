package ro.pao.repository.implementations;


import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.ClientMapper;
import ro.pao.model.Client;
import ro.pao.repository.ClientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientRepositoryImpl implements ClientRepository {

    private static final ClientMapper clientMapper = ClientMapper.getInstance();

    @Override
    public Optional<Client> getClientById(UUID id) {
        String selectSql = "SELECT * FROM Client WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClient(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteClient(UUID id) {
        String deleteNameSql = "DELETE FROM Client WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClientsById(UUID id, Client newClient) {
        String updateNameSql = "UPDATE Client \n" +
                "SET firstName=?, \n" +
                "lastName=?, \n" +
                "phone=?, \n" +
                "email=?, \n" +
                "CNP=?, \n" +
                "address=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newClient.getFirstName());
            preparedStatement.setString(2, newClient.getLastName());
            preparedStatement.setString(3, newClient.getPhone());
            preparedStatement.setString(4, newClient.getEmail());
            preparedStatement.setString(5, newClient.getCNP());
            preparedStatement.setString(6, newClient.getAddress());
            preparedStatement.setString(7, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewClient(Client client) {
        String insertSql = "INSERT INTO Client (id, firstName, lastName, phone, email, CNP, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getCNP());
            preparedStatement.setString(6, client.getAddress());
            preparedStatement.setString(7, client.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> getAllClients() {
        String selectSql = "SELECT * FROM Client";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return clientMapper.mapToClientsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromClientsList(List<Client> clientList) {
        clientList.forEach(this::addNewClient);
    }
}
