package group.demo7.dto;

import group.demo7.entity.Employees;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentsDTO {

    private String firstName;
    private String lastName;
    private String relationship;
    private Employees employees;
}
