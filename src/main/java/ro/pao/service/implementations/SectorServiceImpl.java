package ro.pao.service.implementations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Sector;
import ro.pao.service.SectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class SectorServiceImpl implements SectorService {

    private static List<Sector> sectorsList = new ArrayList<>();

    @Override
    public void addSector(Sector sector) {
        sectorsList.add(sector);
    }

    @Override
    public void addAllSectorsFromList(List<Sector> sectorList) {
        sectorsList.addAll(sectorList);
    }

    @Override
    public Optional<Sector> getSectorById(UUID id) {
        return sectorsList.stream()
                .filter(sector -> id.equals(sector.getId()))
                .findFirst();
    }

    @Override
    public Optional<Sector> getSectorByName(String name) {
        return sectorsList.stream()
                .filter(sector -> name.equals(sector.getName()))
                .findFirst();
    }

    @Override
    public List<Sector> getAllSectors() {
        return sectorsList;
    }

    @Override
    public void deleteSectorById(UUID id) {
        sectorsList = sectorsList.stream()
                .filter(object -> !id.equals(object.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateSectorById(UUID id, Sector newSector) {
        Optional<Sector> sector = this.getSectorById(id);
        if(sector.isPresent()) {
            deleteSectorById(id);
            newSector.setId(id);
            addSector(newSector);
        }
    }
}
