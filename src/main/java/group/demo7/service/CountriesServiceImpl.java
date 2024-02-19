package group.demo7.service;

import group.demo7.dto.CountriesDTO;
import group.demo7.repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesServiceImpl implements CountriesService{

    @Autowired
    private CountriesRepository countriesRepository;

    @Override
    public List<CountriesDTO> getAllCountreis() {
        return null;
    }

    @Override
    public CountriesDTO getCountryById(Long countryId) {
        return null;
    }

    @Override
    public CountriesDTO createCountry(CountriesDTO countriesDTO) {
        return null;
    }

    @Override
    public CountriesDTO updateCountry(Long countryId, CountriesDTO countriesDTO) {
        return null;
    }

    @Override
    public void deleteCountry(Long countryId) {

    }


}
