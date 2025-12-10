package raisetech.student.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.repository.StudentRepository;

@Service
public class StudentService {

private StudentRepository repository;

@Autowired
public StudentService(StudentRepository repository){
  this.repository = repository;
}

  public List<Student> searchStudentList() {
    return repository.search();
  }
  //30代以上
  public List<Student> searchStudentsOver30() {
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30)
        .toList();
  }

  public List<StudentsCourses> searchJavaCourseStudents() {
    return repository.searchStudentsCourses().stream()
        .filter(sc -> "Java".equals(sc.getCourseName()))
        .toList();
  }



}
