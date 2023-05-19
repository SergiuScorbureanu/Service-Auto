package ro.pao.service;

import ro.pao.model.Sector;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectorService {

    void addSector(Sector sector);

    void addAllSectorsFromList(List<Sector> sectorsList);

    Optional<Sector> getSectorById(UUID id);
    Optional<Sector> getSectorByName(String name);

    List<Sector> getAllSectors();

    void deleteSectorById(UUID id);

    void updateSectorById(UUID id, Sector newSector);
}
