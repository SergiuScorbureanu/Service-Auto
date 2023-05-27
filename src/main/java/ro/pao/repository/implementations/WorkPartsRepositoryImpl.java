package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.WorkPartsMapper;
import ro.pao.model.WorkParts;
import ro.pao.repository.WorkPartsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkPartsRepositoryImpl implements WorkPartsRepository {

    private static final WorkPartsMapper workPartsMapper = WorkPartsMapper.getInstance();

    @Override
    public Optional<WorkParts> getWorkPartsById(UUID id) {
        String selectSql = "SELECT * FROM WorkParts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkPartsMapper.mapToWorkParts(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteWorkParts(UUID id) {
        String deleteNameSql = "DELETE FROM WorkParts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWorkPartsById(UUID id, WorkParts newWorkParts) {
        String updateNameSql = "UPDATE WorkParts \n" +
                "SET code=?, \n" +
                "name=?, \n" +
                "price=?, \n" +
                "wordId=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newWorkParts.getCode());
            preparedStatement.setString(2, newWorkParts.getName());
            preparedStatement.setDouble(3, newWorkParts.getPrice());
            preparedStatement.setString(4, newWorkParts.getWorkId().toString());
            preparedStatement.setString(5, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewWorkParts(WorkParts workParts) {
        String insertSql = "INSERT INTO WorkParts (id, code, name, price, workId) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, workParts.getCode());
            preparedStatement.setString(2, workParts.getName());
            preparedStatement.setDouble(3, workParts.getPrice());
            preparedStatement.setString(4, workParts.getWorkId().toString());
            preparedStatement.setString(5, workParts.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<WorkParts> getAllWorkParts() {
        String selectSql = "SELECT * FROM WorkParts";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkPartsMapper.mapToWorkPartsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromWorkPartsList(List<WorkParts> WorkPartsList) {
        WorkPartsList.forEach(this::addNewWorkParts);
    }
}
