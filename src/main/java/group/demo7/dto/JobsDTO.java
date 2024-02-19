package group.demo7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobsDTO {

    private String jobTitle;

    private long minSalary;

    private long maxSalary;

}
