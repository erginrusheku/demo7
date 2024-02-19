package group.demo7.service;

import group.demo7.dto.CountriesDTO;

import java.util.List;

public interface CountriesService {

    List <CountriesDTO> getAllCountreis();

    CountriesDTO getCountryById(Long countryId);

    CountriesDTO createCountry(CountriesDTO countriesDTO);

    CountriesDTO updateCountry(Long countryId, CountriesDTO countriesDTO);

    void deleteCountry(Long countryId);


}
