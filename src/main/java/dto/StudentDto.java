package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Student;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class StudentDto {
    public static StudentDto buildFrom(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .patronymic(student.getPatronymic())
                .studyGroup(student.getStudyGroup())
                .dateOfBirth(student.getDateOfBirth())
                .build();
    }

    public StudentDto(long id, String firstName, String lastName, String patronymic, String studyGroup, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.studyGroup = studyGroup;
        this.dateOfBirth = dateOfBirth;
    }

    private long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String patronymic;
    @JsonProperty("study_group")
    private String studyGroup;
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
}
