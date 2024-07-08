package service;

import dao.StudentDao;
import dto.StudentDto;
import lombok.RequiredArgsConstructor;
import models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    public void addStudent(StudentDto studentDto) {
        studentDao.addStudent(studentDto);
    }

    public void deleteStudentById(Long id) {
        if (id != null) {
            studentDao.deleteStudentById(id);
        }
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDao.getAllStudents();

        return students.stream()
                .map(StudentDto::buildFrom)
                .collect(toList());
    }

    // Three methods for adding a student entry to the DB, deleting an entry from the DB and inserting an entry to the DB
}
