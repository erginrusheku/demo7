package group.demo7.service;

import group.demo7.dto.LocationsDTO;

import java.util.List;

public interface LocationsService {

    List<LocationsDTO> getAllLocations();

    LocationsDTO getLocationById(Long locationId);

    LocationsDTO createLocation(LocationsDTO locationsDTO);

    LocationsDTO updateLocations(Long locationId, LocationsDTO locationsDTO);

    void deleteLocation(Long locationId);
}
