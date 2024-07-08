package dao;

import dto.StudentDto;
import lombok.RequiredArgsConstructor;
import models.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public void addStudent(StudentDto studentDto) {
        String firstName = studentDto.getFirstName();
        String lastName = studentDto.getLastName();
        String patronymic = studentDto.getPatronymic();
        LocalDate dateOfBirth = studentDto.getDateOfBirth();
        String group = studentDto.getStudyGroup();

        String sql = "insert into working_db.s.students (first_name, last_name, patronymic, date_of_birth, study_group)" +
                "values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, patronymic);
            statement.setDate(4, dateOfBirth != null ? Date.valueOf(dateOfBirth) : null);
            statement.setString(5, group);

            return statement;
        });
    }

    public void deleteStudentById(Long id) {
        String sql = "delete from working_db.s.students " +
                "where id = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, id);
            return statement;
        });
    }

    public List<Student> getAllStudents() {
        String sql = "select * from working_db.s.students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    // Three methods for adding a student entry to the DB, deleting an entry from the DB and inserting an entry to the DB
}
