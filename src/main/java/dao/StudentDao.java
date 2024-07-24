package dao;

import dto.StudentDto;
import models.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudent(StudentDto studentDto) {
        String firstName = studentDto.getFirstName();
        String lastName = studentDto.getLastName();
        String patronymic = studentDto.getPatronymic();
        LocalDate dateOfBirth = studentDto.getDateOfBirth();
        String group = studentDto.getStudyGroup();

        String sql = "insert into s.students (first_name, last_name, patronymic, date_of_birth, study_group)" +
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
        String sql = "delete from s.students " +
                "where id = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, id);
            return statement;
        });
    }

    public List<Student> getAllStudents() {
        String sql = "select * from s.students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
