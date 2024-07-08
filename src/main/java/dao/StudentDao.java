package dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    // Three methods for adding a student entry to the DB, deleting an entry from the DB and inserting an entry to the DB
}
