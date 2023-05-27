package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.SectorMapper;
import ro.pao.model.Sector;
import ro.pao.repository.SectorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SectorRepositoryImpl implements SectorRepository {

    private static final SectorMapper sectorMapper = SectorMapper.getInstance();

    @Override
    public Optional<Sector> getSectorById(UUID id) {
        String selectSql = "SELECT * FROM Sector WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return SectorMapper.mapToSector(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Sector> getSectorByName(String name) {
        String selectSql = "SELECT * FROM Sector WHERE name=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, name.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return SectorMapper.mapToSector(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteSector(UUID id) {
        String deleteNameSql = "DELETE FROM Sector WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSectorsById(UUID id, Sector newSector) {
        String updateNameSql = "UPDATE Sector \n" +
                "SET name=?, \n" +
                "WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newSector.getName());
            preparedStatement.setString(2, id.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addNewSector(Sector Sector) {
        String insertSql = "INSERT INTO Sector (id, name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Sector.getName());
            preparedStatement.setString(2, Sector.getId().toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Sector> getAllSectors() {
        String selectSql = "SELECT * FROM Sector";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return SectorMapper.mapToSectorsList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromSectorsList(List<Sector> SectorList) {
        SectorList.forEach(this::addNewSector);
    }
}
