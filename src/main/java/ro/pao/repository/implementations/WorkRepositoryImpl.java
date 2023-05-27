package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.WorkMapper;
import ro.pao.model.Work;
import ro.pao.repository.WorkRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkRepositoryImpl implements WorkRepository {

    private static final WorkMapper workMapper = WorkMapper.getInstance();

    @Override
    public Optional<Work> getWorkById(UUID id) {
        String selectSql = "SELECT * FROM Work WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkMapper.mapToWork(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteWork(UUID id) {
        String deleteNameSql = "DELETE FROM Work WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWorksById(UUID id, Work newWork) {
        String updateNameSql = "UPDATE Work \n" +
                "SET firstName=?, \n" +
                "name=?, \n" +
                "duration=?, \n" +
                "price=?, \n" +
                "sectorId=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newWork.getName());
            preparedStatement.setInt(2, newWork.getDuration());
            preparedStatement.setDouble(3, newWork.getPrice());
            preparedStatement.setString(4, newWork.getSectorId().toString());
            preparedStatement.setString(5, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewWork(Work Work) {
        String insertSql = "INSERT INTO Work (id, name, duration, price, sectorId) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Work.getName());
            preparedStatement.setInt(2, Work.getDuration());
            preparedStatement.setDouble(3, Work.getPrice());
            preparedStatement.setString(4, Work.getSectorId().toString());
            preparedStatement.setString(5, Work.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Work> getAllWorks() {
        String selectSql = "SELECT * FROM Work";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkMapper.mapToWorksList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromWorksList(List<Work> WorkList) {
        WorkList.forEach(this::addNewWork);
    }
}
