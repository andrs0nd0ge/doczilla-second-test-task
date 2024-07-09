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

    @DeleteMapping("delete")
    public void deleteStudentById(@RequestParam Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("get-all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }
}
