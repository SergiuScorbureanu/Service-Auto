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
        String selectSql = "SELECT * FROM works WHERE id=?";
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
        String deleteNameSql = "DELETE FROM works WHERE id=?";
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
        String updateNameSql = "UPDATE works \n" +
                "SET name=?, \n" +
                "duration=?, \n" +
                "price=?, \n" +
                "vehicleid=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newWork.getName());
            preparedStatement.setInt(2, newWork.getDuration());
            preparedStatement.setDouble(3, newWork.getPrice());
            preparedStatement.setObject(4, newWork.getVehicleId());
            preparedStatement.setObject(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewWork(Work work) {
        String insertSql = "INSERT INTO works (id, name, duration, price, vehicleid) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setObject(1, work.getId());
            preparedStatement.setString(2, work.getName());
            preparedStatement.setInt(3, work.getDuration());
            preparedStatement.setDouble(4, work.getPrice());
            preparedStatement.setObject(5, work.getVehicleId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Work> getAllWorks() {
        String selectSql = "SELECT * FROM works";

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
