package ro.pao.service.implementations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ro.pao.model.Sector;
import ro.pao.repository.implementations.SectorRepositoryImpl;
import ro.pao.service.SectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class SectorServiceImpl implements SectorService {

    private final SectorRepositoryImpl sectorRepository;

    @Override
    public void addSector(Sector sector) {
        sectorRepository.addNewSector(sector);
    }

    @Override
    public void addAllSectorsFromList(List<Sector> sectorList) {
        sectorRepository.addAllFromSectorsList(sectorList);
    }

    @Override
    public Optional<Sector> getSectorById(UUID id) {
        return sectorRepository.getSectorById(id);
    }

    @Override
    public Optional<Sector> getSectorByName(String name) {
        return sectorRepository.getSectorByName(name);
    }

    @Override
    public List<Sector> getAllSectors() {
        return sectorRepository.getAllSectors();
    }

    @Override
    public void deleteSectorById(UUID id) {
        sectorRepository.deleteSector(id);
    }

    @Override
    public void updateSectorById(UUID id, Sector newSector) {
        sectorRepository.updateSectorsById(id, newSector);
    }
}
