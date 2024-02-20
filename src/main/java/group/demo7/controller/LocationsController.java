package group.demo7.controller;

import group.demo7.dto.LocationsDTO;
import group.demo7.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping("/getLocations")
    public ResponseEntity<List<LocationsDTO>> getLocations(){
        return ResponseEntity.ok(locationsService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationsDTO> getLocationsById(@PathVariable Long id){
        return ResponseEntity.ok(locationsService.getLocationById(id));
    }

    @PostMapping("/createLocations")
    public ResponseEntity<LocationsDTO> createLocations(@RequestBody LocationsDTO locationsDTO){
        LocationsDTO locationsDTO1 = locationsService.createLocation(locationsDTO);
        return new ResponseEntity<>(locationsDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/updateLocations/{id}")
    public ResponseEntity<LocationsDTO> updateLocations(@PathVariable Long locationId, @RequestBody LocationsDTO locationsDTO){
        LocationsDTO updateLocation = locationsService.updateLocations(locationId, locationsDTO);
        return new ResponseEntity<>(updateLocation, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteLocations/{id}")
    public ResponseEntity<Void> deleteLocations(@PathVariable Long locationId){
        locationsService.deleteLocation(locationId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
