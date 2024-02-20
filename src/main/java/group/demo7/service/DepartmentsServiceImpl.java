package group.demo7.service;

import group.demo7.dto.CountriesDTO;
import group.demo7.dto.DepartmentsDTO;
import group.demo7.dto.EmployeesDTO;
import group.demo7.repository.CountriesRepository;
import group.demo7.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

    @Autowired
    private DepartmentsRepository departmentsRepository;


    @Override
    public List<DepartmentsDTO> getAllDepartments() {
        return null;
    }

    @Override
    public DepartmentsDTO getDepartmentsById(long departmentsId) {
        return null;
    }

    @Override
    public DepartmentsDTO addDepartments(DepartmentsDTO employeesDTO) {
        return null;
    }

    @Override
    public DepartmentsDTO updateDepartments(long departmentsId, DepartmentsDTO updatedDepartmentsDTO) {
        return null;
    }

    @Override
    public void deleteDepartmentsById(long id) {

    }
}
