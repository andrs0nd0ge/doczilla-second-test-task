package controller;

import dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("add")
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }
    // POST endpoint "add" for adding a student to the DB

    @DeleteMapping("delete")
    public void deleteStudentById(@RequestParam Long id) {
        studentService.deleteStudentById(id);
    }
    // DELETE endpoint "delete?id=..." for deleting a student from the DB

    @GetMapping("get-all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }
    // GET endpoint "get-all" for selecting all students from the DB
}
