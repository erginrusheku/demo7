package group.demo7.controller;

import group.demo7.dto.RegionsDTO;
import group.demo7.service.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionsController {

    @Autowired
    private RegionsService regionsService;

    @GetMapping("/getRegions")
    public ResponseEntity<List<RegionsDTO>> getRegions(){
        return ResponseEntity.ok(regionsService.getAllRegions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionsDTO> getRegionsById(@PathVariable Long id){
        return ResponseEntity.ok(regionsService.getRegionById(id));
    }

    @PostMapping("/createRegions")
    public ResponseEntity<RegionsDTO> createRegions(@RequestBody RegionsDTO regionsDTO){
        RegionsDTO regionsDTO1 = regionsService.createRegion(regionsDTO);
        return new ResponseEntity<>(regionsDTO1, HttpStatus.CREATED);
    }

    @PutMapping("/updateRegions/{id}")
    public ResponseEntity<RegionsDTO> updateRegions(@PathVariable Long regionsId, @RequestBody RegionsDTO regionsDTO){
        RegionsDTO updateRegion = regionsService.updateRegion(regionsId, regionsDTO);
        return new ResponseEntity<>(updateRegion, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRegions/{id}")
    public ResponseEntity<Void> deleteRegions(Long regionsId){
        regionsService.deleteRegion(regionsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
