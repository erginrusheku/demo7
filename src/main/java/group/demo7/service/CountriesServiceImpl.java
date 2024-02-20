package group.demo7.service;

import group.demo7.dto.CountriesDTO;
import group.demo7.dto.LocationsDTO;
import group.demo7.entity.Countries;
import group.demo7.entity.Locations;
import group.demo7.repository.CountriesRepository;
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
public class CountriesServiceImpl implements CountriesService{

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountriesDTO> getAllCountreis() {
        List<Countries> countries = countriesRepository.findAll();
        return countries.stream().map(country -> modelMapper.map(country, CountriesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CountriesDTO getCountryById(Long countryId) {
        Optional<Countries> countries = countriesRepository.findById(countryId);
        return countries.stream().map(country -> modelMapper.map(country, CountriesDTO.class)).findAny().orElse(null);
    }

    @Override
    public CountriesDTO createCountry(CountriesDTO countriesDTO) {
        if(countriesDTO == null || countriesDTO.getLocations() == null){
            return null;
        }

        Countries countries = modelMapper.map(countriesDTO, Countries.class);

        List<Locations> locations = countriesDTO.getLocations().stream().map(locationDTO -> {
            Locations locations1 = modelMapper.map(locationDTO, Locations.class);
            locations1.setCountries(countries);
            return locations1;
        }).collect(Collectors.toList());

        countries.setLocations(locations);

        Countries savedCountries = countriesRepository.save(countries);

        return modelMapper.map(savedCountries, CountriesDTO.class);
    }

    @Override
    public CountriesDTO updateCountry(Long countryId, CountriesDTO countriesDTO) {
        Countries existingCountries = countriesRepository.findById(countryId).orElse(null);

        if(existingCountries != null && countriesDTO != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            existingCountries.setCountryName(countriesDTO.getCountryName());

            if(countriesDTO.getLocations() != null) {
                List<Locations> updateLocations = new ArrayList<>();

                for (LocationsDTO locationsDTO : countriesDTO.getLocations()) {
                    if (locationsDTO.getId() != null) {
                        Locations existingLocation = existingCountries.getLocations().stream().filter(l -> l.getLocationId().equals(locationsDTO.getId())).findFirst().orElse(null);

                        if(existingLocation != null) {
                            modelMapper.map(locationsDTO, existingLocation);
                            updateLocations.add(existingLocation);
                        }
                    }else{
                        Locations newLocation = modelMapper.map(locationsDTO, Locations.class);

                        newLocation.setCountries(existingCountries);
                        updateLocations.add(newLocation);
                    }
                }

                existingCountries.setLocations(updateLocations);
            } else {
                existingCountries.setLocations(Collections.emptyList());
            }

            existingCountries = countriesRepository.save(existingCountries);

            return modelMapper.map(existingCountries, CountriesDTO.class);
        }

        return null;
    }

    @Override
    public void deleteCountry(Long countryId) {
        countriesRepository.deleteById(countryId);
    }


}
