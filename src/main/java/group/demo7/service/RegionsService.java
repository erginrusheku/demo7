package group.demo7.service;

import group.demo7.dto.RegionsDTO;

import java.util.List;

public interface RegionsService {

    List<RegionsDTO> getAllRegions();

    RegionsDTO getRegionById(Long regionsId);

    RegionsDTO createRegion(RegionsDTO regionsDTO);

    RegionsDTO updateRegion(Long regionsId, RegionsDTO regionsDTO);

    RegionsDTO deleteRegion(Long regionsId);
}
