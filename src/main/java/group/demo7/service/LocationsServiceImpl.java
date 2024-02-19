package group.demo7.service;

import group.demo7.dto.LocationsDTO;
import group.demo7.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImpl implements LocationsService{

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public List<LocationsDTO> getAllLocations() {
        return null;
    }

    @Override
    public LocationsDTO getLocationById(Long locationId) {
        return null;
    }

    @Override
    public LocationsDTO createLocation(LocationsDTO locationsDTO) {
        return null;
    }

    @Override
    public LocationsDTO updateLocations(Long locationId, LocationsDTO locationsDTO) {
        return null;
    }

    @Override
    public void deleteLocation(Long locationId) {

    }

}
