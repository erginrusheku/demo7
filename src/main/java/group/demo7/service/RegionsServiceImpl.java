package group.demo7.service;

import group.demo7.dto.RegionsDTO;
import group.demo7.repository.RegionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionsServiceImpl implements RegionsService{

    @Autowired
    private RegionsRepository regionsRepository;

    @Override
    public List<RegionsDTO> getAllRegions() {
        return null;
    }

    @Override
    public RegionsDTO getRegionById(Long regionsId) {
        return null;
    }

    @Override
    public RegionsDTO createRegion(RegionsDTO regionsDTO) {
        return null;
    }

    @Override
    public RegionsDTO updateRegion(Long regionsId, RegionsDTO regionsDTO) {
        return null;
    }

    @Override
    public RegionsDTO deleteRegion(Long regionsId) {
        return null;
    }

}
