package ro.pao.repository;

import ro.pao.model.Client;
import ro.pao.model.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository {

    Optional<Vehicle> getVehicleById(UUID id);

    void deleteVehicle(UUID id);

    void updateVehiclesById(UUID id, Vehicle newVehicle);

    void addNewVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    void addAllFromVehiclesList(List<Vehicle> vehicleList);
}
