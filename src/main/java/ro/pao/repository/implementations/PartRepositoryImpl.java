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
        String selectSql = "SELECT * FROM Part WHERE id=?";
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
        String deleteNameSql = "DELETE FROM Part WHERE id=?";
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
        String updateNameSql = "UPDATE Part \n" +
                "SET code=?, \n" +
                "name=?, \n" +
                "price=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newPart.getCode());
            preparedStatement.setString(2, newPart.getName());
            preparedStatement.setDouble(3, newPart.getPrice());
            preparedStatement.setString(4, id.toString());
            preparedStatement.setString(5, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewPart(Part part) {
        String insertSql = "INSERT INTO Part (id, code, name, price) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, part.getCode());
            preparedStatement.setString(2, part.getName());
            preparedStatement.setDouble(3, part.getPrice());
            preparedStatement.setString(4, part.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Part> getAllParts(UUID id) {
        String selectSql = "SELECT * FROM Part";

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
        String selectSql = "SELECT * FROM Part WHERE name=?";
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
