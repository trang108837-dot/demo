package studentmanager.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	// http://localhost:8080/api/hello
	@GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }
	//Api voi Path Variable
	//http://localhost:8080/api/student/10
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable int id) {
		return "Sinh viên có mã: " + id;
	}
	//API nhan tham so vd1
	//http://localhost:8080/api/student?name=Trang
	@GetMapping("/student")
	public String greet(@RequestParam String name) {
    	return "Xin chào " + name;
	}
	//API nhan tham so vd2
	//http://localhost:8080/api/searchstudent?name=Trang&age=20
	@GetMapping("/searchstudent")
	public String searchStudent(@RequestParam String name,
                         @RequestParam(defaultValue = "1") int age) {
    	return "Tên=" + name + ", tuổi=" + age;
	}
	//Tra ve Json object
	//http://localhost:8080/api/students
	@GetMapping("/students")
	public Student getStudent() {
    	return new Student(1,"Dao Thi Huyen Trang",20);
	}
	//API tra ve danh sach
	//http://localhost:8080/api/studentall
	@GetMapping("/studentall")
	public List<Student> getStudents() {
    	List<Student> list = new ArrayList<>();
    	list.add(new Student(1, "Dao Thi Huen Trang", 20));
    	list.add(new Student(2, "Nguyen Thi Mai Huyen", 21));
    	return list;
	}
	//@RequestHeader  
	//http://localhost:8080/api/getstudent
	@GetMapping("/getstudent")
	public String getStudents(
        @RequestHeader("Authorization") String authorization) {
    		return "Authorization = " + authorization;
	}
}
