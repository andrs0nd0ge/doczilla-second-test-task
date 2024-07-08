package models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String studyGroup;
    private LocalDate dateOfBirth;
}
