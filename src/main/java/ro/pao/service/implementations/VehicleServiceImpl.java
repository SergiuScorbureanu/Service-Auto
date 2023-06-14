package ro.pao.service.implementations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Vehicle;
import ro.pao.repository.implementations.VehicleRepositoryImpl;
import ro.pao.service.VehicleService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepositoryImpl vehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addNewVehicle(vehicle);
    }

    @Override
    public void addAllFromVehiclesList(List<Vehicle> vehicleList) {
        vehicleRepository.addAllFromVehiclesList(vehicleList);
    }

    @Override
    public Optional<Vehicle> getVehicleById(UUID id) {
        return vehicleRepository.getVehicleById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    @Override
    public void deleteVehicleById(UUID id) {
        vehicleRepository.deleteVehicle(id);
    }

    @Override
    public void updateVehicleById(UUID id, Vehicle newVehicle) {
        vehicleRepository.updateVehiclesById(id, newVehicle);
    }
}
