package ro.pao.service;

import ro.pao.model.Sector;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectorService {

    void createSector(Sector sector);

    Optional<Sector> getSectorById();

    List<Sector> getAllFromList();

    void deleteSectorById(UUID id);

    void updateSectorById(UUID id, Sector newSector);
}
