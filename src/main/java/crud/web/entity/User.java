package crud.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    @NotEmpty(message = "Enter name")
    private String name;

    @NotEmpty(message = "Enter surname")
    private String surname;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @NotEmpty(message = "Enter email")
    private String email;
}
