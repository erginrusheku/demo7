package group.demo7.service;

import group.demo7.dto.DepartmentsDTO;
import group.demo7.dto.LocationsDTO;
import group.demo7.entity.Departments;
import group.demo7.entity.Locations;
import group.demo7.repository.LocationsRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationsServiceImpl implements LocationsService{

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LocationsDTO> getAllLocations() {
        List<Locations> locations = locationsRepository.findAll();
        return locations.stream().map(locations1 -> modelMapper.map(locations1, LocationsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public LocationsDTO getLocationById(Long locationId) {
        Optional<Locations> locations = locationsRepository.findById(locationId);
        return locations.stream().map(locations1 -> modelMapper.map(locations1, LocationsDTO.class)).findAny().orElse(null);
    }

    @Override
    public LocationsDTO createLocation(LocationsDTO locationsDTO) {
        if(locationsDTO == null || locationsDTO.getDepartments() == null){
            return null;
        }

        Locations locations = modelMapper.map(locationsDTO, Locations.class);

        List<Departments> departments = locationsDTO.getDepartments().stream().map(departmentsDTO -> {
            Departments departments1 = modelMapper.map(departmentsDTO, Departments.class);
            departments1.setLocation(locations);
            return departments1;
        }).collect(Collectors.toList());

        locations.setDepartments(departments);

        Locations saveLocations = locationsRepository.save(locations);

        return modelMapper.map(saveLocations, LocationsDTO.class);
    }

    @Override
    public LocationsDTO updateLocations(Long locationId, LocationsDTO locationsDTO) {
        Locations existingLocations = locationsRepository.findById(locationId).orElse(null);

        if(existingLocations != null && locationsDTO != null){
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            existingLocations.setLocationId(locationsDTO.getId());

            if(locationsDTO.getDepartments() != null){
                List<Departments> updateDepartments = new ArrayList<>();

                for(DepartmentsDTO departmentsDTO : locationsDTO.getDepartments()){
                    if(departmentsDTO.getDepartmentId() != null){
                        Departments existingDepartments = existingLocations.getDepartments().stream().filter(departments -> departments.getDepartmentId().equals(departmentsDTO.getDepartmentId())).findFirst().orElse(null);

                        if(existingDepartments != null){
                            modelMapper.map(departmentsDTO, existingDepartments);
                            updateDepartments.add(existingDepartments);
                        }
                    }else {
                        Departments newDepartment = modelMapper.map(departmentsDTO, Departments.class);

                        newDepartment.setLocation(existingLocations);
                        updateDepartments.add(newDepartment);
                    }
                }

                existingLocations.setDepartments(updateDepartments);
            }else{
                existingLocations.setDepartments(Collections.emptyList());

            }

            existingLocations = locationsRepository.save(existingLocations);

            return modelMapper.map(existingLocations, LocationsDTO.class);
        }
        return null;
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationsRepository.deleteById(locationId);

    }

}
