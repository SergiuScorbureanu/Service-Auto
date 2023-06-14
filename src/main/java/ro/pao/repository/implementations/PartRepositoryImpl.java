package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.PartMapper;
import ro.pao.model.Part;
import ro.pao.repository.PartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PartRepositoryImpl implements PartRepository {

    private static final PartMapper partMapper = PartMapper.getInstance();

    @Override
    public Optional<Part> getPartById(UUID id) {
        String selectSql = "SELECT * FROM parts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return partMapper.mapToPart(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deletePartById(UUID id) {
        String deleteNameSql = "DELETE FROM parts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePartById(UUID id, Part newPart) {
        String updateNameSql = "UPDATE parts \n" +
                "SET code=?, \n" +
                "name=?, \n" +
                "price=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newPart.getCode());
            preparedStatement.setString(2, newPart.getName());
            preparedStatement.setDouble(3, newPart.getPrice());
            preparedStatement.setObject(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewPart(Part part) {
        String insertSql = "INSERT INTO parts (id, code, name, price) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setObject(1, part.getId());
            preparedStatement.setString(2, part.getCode());
            preparedStatement.setString(3, part.getName());
            preparedStatement.setDouble(4, part.getPrice());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Part> getAllParts() {
        String selectSql = "SELECT * FROM parts";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return partMapper.mapToPartsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllPartsFromList(List<Part> partList) {
        partList.forEach(this::addNewPart);
    }

    @Override
    public Optional<Part> getPartByName(String name) {
        String selectSql = "SELECT * FROM parts WHERE name=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return partMapper.mapToPart(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

}
