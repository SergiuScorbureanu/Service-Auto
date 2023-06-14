package ro.pao.mapper;

import ro.pao.model.Vehicle;
import ro.pao.model.enums.Body;
import ro.pao.model.enums.Fuel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class VehicleMapper {

    private static final VehicleMapper INSTANCE = new VehicleMapper();

    private VehicleMapper() {
    }

    public static VehicleMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Vehicle> mapToVehicle(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Optional.of(
                    Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .defect(resultSet.getString(2))
                            .chassisSeries(resultSet.getString(3))
                            .engineSeries(resultSet.getString(4))
                            .body(Body.valueOf(resultSet.getString(5)))
                            .fuel(Fuel.valueOf(resultSet.getString(6)))
                            .build()
            );
        }
        return Optional.empty();
    }

    public List<Vehicle> mapToVehiclesList(ResultSet resultSet) throws SQLException {

        List<Vehicle> VehiclesList = new ArrayList<>();

        while (resultSet.next()) {
            VehiclesList.add(
                    Vehicle.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .defect(resultSet.getString(2))
                            .chassisSeries(resultSet.getString(3))
                            .engineSeries(resultSet.getString(4))
                            .body(Body.valueOf(resultSet.getString(5)))
                            .fuel(Fuel.valueOf(resultSet.getString(6)))
                            .build()
            );
        }
        return VehiclesList;
    }
}
