package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Employee;
import ro.pao.model.Vehicle;
import ro.pao.service.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class VehicleServiceImpl implements VehicleService {

    private static List<Vehicle> vehiclesList = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    @Override
    public void addAllVehiclesFromList(List<Vehicle> vehicleList) {
        vehiclesList.addAll(vehicleList);
    }

    @Override
    public Optional<Vehicle> getVehicleById(UUID id) {
        return Optional.empty(); // problema cu id-ul
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehiclesList;
    }

    @Override
    public void deleteVehicleById(UUID id) {
        vehiclesList = vehiclesList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateVehicleById(UUID id, Vehicle newVehicle) {
        Optional<Vehicle> employee = this.getVehicleById(id);
        if (employee.isPresent()) {
            deleteVehicleById(id);
            newVehicle.setId(id);
            addVehicle(newVehicle);
        }
    }
}
