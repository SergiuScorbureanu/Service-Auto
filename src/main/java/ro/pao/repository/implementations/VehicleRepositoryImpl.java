package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.ClientMapper;
import ro.pao.mapper.VehicleMapper;
import ro.pao.model.Client;
import ro.pao.model.Vehicle;
import ro.pao.model.enums.Body;
import ro.pao.model.enums.Fuel;
import ro.pao.repository.VehicleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VehicleRepositoryImpl implements VehicleRepository {

    private static final VehicleMapper vehicleMapper = VehicleMapper.getInstance();

    @Override
    public Optional<Vehicle> getVehicleById(UUID id) {
        String selectSql = "SELECT * FROM Vehicle WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return vehicleMapper.mapToVehicle(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteVehicle(UUID id) {
        String deleteNameSql = "DELETE FROM Vehicle WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVehiclesById(UUID id, Vehicle newVehicle) {
        String updateNameSql = "UPDATE Vehicle \n" +
                "SET defect=?, \n" +
                "chassisSeries=?, \n" +
                "engineSeries=?, \n" +
                "body=?, \n" +
                "fuel=?, \n";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newVehicle.getDefect());
            preparedStatement.setString(2, newVehicle.getChassisSeries());
            preparedStatement.setString(3, newVehicle.getEngineSeries());
            preparedStatement.setString(4, newVehicle.getBody().toString());
            preparedStatement.setString(5, newVehicle.getFuel().toString());
            preparedStatement.setString(6, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) {
        String insertSql = "INSERT INTO Vehicle (id, defect, chassisSeries, engineSeries, body, fuel) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, vehicle.getDefect());
            preparedStatement.setString(2, vehicle.getChassisSeries());
            preparedStatement.setString(3, vehicle.getEngineSeries());
            preparedStatement.setString(4, vehicle.getBody().name());
            preparedStatement.setString(5, vehicle.getFuel().name());
            preparedStatement.setString(6, vehicle.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        String selectSql = "SELECT * FROM Vehicle";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return vehicleMapper.mapToVehiclesList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromVehiclesList(List<Vehicle> vehicleList) {
        vehicleList.forEach(this::addNewVehicle);
    }
}
