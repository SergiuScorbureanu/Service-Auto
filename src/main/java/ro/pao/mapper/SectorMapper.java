package ro.pao.mapper;

import ro.pao.model.Sector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SectorMapper {

    private static final SectorMapper INSTANCE = new SectorMapper();

    private SectorMapper() {
    }

    public static SectorMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Sector> mapToSector(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Sector.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        } else {
           return Optional.empty();
        }
    }

    public List<Sector> mapToSectorsList(ResultSet resultSet) throws SQLException {
        List<Sector> SectorsList = new ArrayList<>();
        while (resultSet.next()) {
            SectorsList.add(
                    Sector.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        }

        return SectorsList;
    }
}
