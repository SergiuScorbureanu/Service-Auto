package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.Sector;
import ro.pao.service.SectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class SectorServiceImpl implements SectorService {

    private static List<Sector> sectorsList = new ArrayList<>();

    @Override
    public void createSector(Sector sector) {

    }

    @Override
    public Optional<Sector> getSectorById() {
        return Optional.empty();
    }

    @Override
    public List<Sector> getAllFromList() {
        return null;
    }

    @Override
    public void deleteSectorById(UUID id) {

    }

    @Override
    public void updateSectorById(UUID id, Sector newSector) {

    }
}
