package group.demo7.service;

import group.demo7.dto.DependentsDTO;
import group.demo7.repository.DependentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DependentsServiceImpl implements DependentsService{

    @Autowired
    DependentsRepository dependentsRepository;

    @Override
    public List<DependentsDTO> dependentsList() {
        return null;
    }

    @Override
    public DependentsDTO getById(long id) {
        return null;
    }

    @Override
    public DependentsDTO addDependents(DependentsDTO dependentsDTO) {
        return null;
    }

    @Override
    public DependentsDTO updateDependents(long id, DependentsDTO dependentsDTO) {
        return null;
    }

    @Override
    public void deleteDependents(long id) {

    }
}
