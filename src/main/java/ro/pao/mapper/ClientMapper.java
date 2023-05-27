package ro.pao.mapper;

import ro.pao.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientMapper {

    private static final ClientMapper INSTANCE = new ClientMapper();

    private ClientMapper() {
    }

    public static ClientMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Client> mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .lastName(resultSet.getString(2))
                            .firstName(resultSet.getString(3))
                            .phone(resultSet.getString(4))
                            .email(resultSet.getString(5))
                            .CNP(resultSet.getString(6))
                            .address(resultSet.getString(7))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Client> mapToClientsList(ResultSet resultSet) throws SQLException {
        List<Client> ClientsList = new ArrayList<>();
        while (resultSet.next()) {
            ClientsList.add(
                    Client.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .lastName(resultSet.getString(2))
                            .firstName(resultSet.getString(3))
                            .phone(resultSet.getString(4))
                            .email(resultSet.getString(5))
                            .CNP(resultSet.getString(6))
                            .address(resultSet.getString(7))
                            .build()
            );
        }

        return ClientsList;
    }
}
