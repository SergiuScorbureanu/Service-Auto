package ro.pao.repository;

import ro.pao.model.Sector;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectorRepository {

    Optional<Sector> getSectorById(UUID id);

    Optional<Sector> getSectorByName(String name);

    void deleteSector(UUID id);

    void updateSectorsById(UUID id, Sector newSector);

    void addNewSector(Sector Sector);

    List<Sector> getAllSectors();

    void addAllFromSectorsList(List<Sector> SectorList);
}
