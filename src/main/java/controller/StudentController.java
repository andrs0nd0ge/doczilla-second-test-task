package controller;

import dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // POST endpoint "add" for adding a student to the DB

    // DELETE endpoint "delete?id=..." for deleting a student from the DB

    @GetMapping("get-all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }
    // GET endpoint "get-all" for selecting all students from the DB
}
