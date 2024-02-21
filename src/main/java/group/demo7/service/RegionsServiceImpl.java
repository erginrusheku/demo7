package group.demo7.service;

import group.demo7.dto.CountriesDTO;
import group.demo7.dto.RegionsDTO;
import group.demo7.entity.Countries;
import group.demo7.entity.Regions;
import group.demo7.repository.RegionsRepository;
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
public class RegionsServiceImpl implements RegionsService{

    @Autowired
    private RegionsRepository regionsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RegionsDTO> getAllRegions() {
        List<Regions> regions = regionsRepository.findAll();
        return regions.stream().map(regions1 -> modelMapper.map(regions1, RegionsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RegionsDTO getRegionById(Long regionsId) {
        Optional<Regions> regions = regionsRepository.findById(regionsId);
        return regions.stream().map(regions1 -> modelMapper.map(regions1, RegionsDTO.class)).findAny().orElse(null);
    }

    @Override
    public RegionsDTO createRegion(RegionsDTO regionsDTO) {
        if(regionsDTO == null || regionsDTO.getCountries() == null){
            return null;
        }

        Regions regions = modelMapper.map(regionsDTO, Regions.class);

        List<Countries> countries = regionsDTO.getCountries().stream().map(countriesDTO -> {
            Countries countries1 = modelMapper.map(countriesDTO, Countries.class);
            countries1.setRegions(regions);
            return countries1;
        }).collect(Collectors.toList());

        regions.setCountries(countries);

        Regions saveRegions = regionsRepository.save(regions);

        return modelMapper.map(saveRegions, RegionsDTO.class);


    }

    @Override
    public RegionsDTO updateRegion(Long regionsId, RegionsDTO regionsDTO) {
        Regions existingRegions = regionsRepository.findById(regionsId).orElse(null);

        if(existingRegions != null && regionsDTO != null){
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            existingRegions.setRegionId(regionsDTO.getRegionsId());

            if(regionsDTO.getCountries() != null){
                List<Countries> updateCountries = new ArrayList<>();

                for(CountriesDTO countriesDTO : regionsDTO.getCountries()){
                    if(countriesDTO.getId() != null){
                        Countries existingCountries = existingRegions.getCountries().stream().filter(countries -> countries.getRegions().equals(countriesDTO.getRegions())).findFirst().orElse(null);

                        if(existingCountries != null){
                            modelMapper.map(countriesDTO, existingCountries);
                            updateCountries.add(existingCountries);
                        }
                    }else {
                        Countries newCountry = modelMapper.map(countriesDTO, Countries.class);

                        newCountry.setRegions(existingRegions);
                        updateCountries.add(newCountry);
                    }
                }

                existingRegions.setCountries(updateCountries);
            }else {
                existingRegions.setCountries(Collections.emptyList());
            }

            existingRegions = regionsRepository.save(existingRegions);

            return modelMapper.map(existingRegions, RegionsDTO.class);
        }
        return null;
    }

    @Override
    public void deleteRegion(Long regionsId) {
        regionsRepository.deleteById(regionsId);
    }

}
