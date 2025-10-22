package raisetech.student.management;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  private String name;
  private String age;
  private Map<String,String> students = new HashMap<>(Map.of(
      "nonaka","41","kitagawa","27","tikami","31","motoyama","25"));

	public static void main(String[] args) {
    		SpringApplication.run(Application.class, args);
	}
  @GetMapping("/studentInfomation")
  public Map<String,String> getStudents() {
    return students;
  }
  @PostMapping("/studentInfomation")
  public String addStudentInfo(@RequestParam String name, @RequestParam String age){
    students.put(name,age);
    return "Added:" + name +"("+ age +")";
  }

  // GET:取得する
  // POST:情報を与える


}
