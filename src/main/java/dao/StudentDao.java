package dao;

import lombok.RequiredArgsConstructor;
import models.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudents() {
        String sql = "select * from working_db.s.students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    // Three methods for adding a student entry to the DB, deleting an entry from the DB and inserting an entry to the DB
}
