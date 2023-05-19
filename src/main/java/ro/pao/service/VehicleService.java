package ro.pao.service;

import ro.pao.model.Employee;
import ro.pao.model.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void addAllVehiclesFromList(List<Vehicle> vehicleList);

    Optional<Vehicle> getVehicleById(UUID id);

    List<Vehicle> getAllVehicles();

    void deleteVehicleById(UUID id);

    void updateVehicleById(UUID id, Vehicle newVehicle);
}
