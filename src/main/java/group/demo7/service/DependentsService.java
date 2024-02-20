package group.demo7.service;

import group.demo7.dto.DependentsDTO;

import java.util.List;

public interface DependentsService {

    List<DependentsDTO> dependentsList();

    DependentsDTO getById(long id);

    DependentsDTO addDependents(DependentsDTO dependentsDTO);

    DependentsDTO updateDependents(long id, DependentsDTO dependentsDTO);

    void deleteDependents(long id);
}
