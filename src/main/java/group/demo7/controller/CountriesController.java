package group.demo7.controller;

import group.demo7.dto.CountriesDTO;
import group.demo7.service.CountriesService;
import group.demo7.service.CountriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    @GetMapping("/getCountries")
    public ResponseEntity<List<CountriesDTO>> getCountries(){
        return ResponseEntity.ok(countriesService.getAllCountreis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountriesDTO> getCountriesById(@PathVariable Long id){
        return ResponseEntity.ok(countriesService.getCountryById(id));
    }

    @PostMapping("/createCountries")
    public ResponseEntity<CountriesDTO> createCountries(@RequestBody CountriesDTO countriesDTO){
        CountriesDTO countriesDTO1 = countriesService.createCountry(countriesDTO);
        return new ResponseEntity<>(countriesDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/updateCountries/{id}")
    public ResponseEntity<CountriesDTO> updateCountries(@PathVariable Long countryId, @RequestBody CountriesDTO countriesDTO){
        CountriesDTO updateCountry = countriesService.updateCountry(countryId, countriesDTO);
        return new ResponseEntity<>(updateCountry, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCountries/{id}")
    public ResponseEntity<Void> deleteCountries(@PathVariable Long countryId){
        countriesService.deleteCountry(countryId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
