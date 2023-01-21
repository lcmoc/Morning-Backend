package bbw.ch.Morning.Controller;

import bbw.ch.Morning.Model.StudentEntity;
import bbw.ch.Morning.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
        private final StudentService studentService;

        @Autowired
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @CrossOrigin(origins = "https://morning-b5e3d.web.app/")
        @GetMapping("/students")
        public ResponseEntity<List<StudentEntity>> getUsers() {
            return ResponseEntity
                    .status(HttpStatus.OK) // HTTP 200
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(studentService.loadAll());
        }

        @GetMapping("/students/{id}")
        public ResponseEntity<Optional<StudentEntity>>
        getUser(@PathVariable Long id) {
            Optional<StudentEntity> user = studentService.loadOne(id);

            if (user.isPresent()) {
                System.out.println("Accessing single date, HTTP: 200");
                return ResponseEntity
                        .status(HttpStatus.OK)  // HTTP 200
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(user);
            } else {
                System.out.println("Accessing single user, HTTP: 404");
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/students")
        public ResponseEntity<StudentEntity>
        addUser(@RequestBody StudentEntity user) {
            System.out.println("booking created");

            studentService.create(user);
            return ResponseEntity
                    .status(HttpStatus.CREATED)  // HTTP 201
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(user);
        }

        @DeleteMapping("/students/{id}")
        public ResponseEntity<?>
        deleteUser(@PathVariable Long id) {
            Optional<StudentEntity> user = studentService.loadOne(id);

            if (user.isPresent()) {
                System.out.println("removed user");
                studentService.delete(id);
                return ResponseEntity.noContent().build();  // HTTP 204
            } else {
                return ResponseEntity.notFound().build();   // HTTP 404
            }
        }

        @PutMapping("/students/{id}")
        public ResponseEntity<StudentEntity>
        updateUser(@RequestBody StudentEntity user) {

            studentService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED)  // HTTP 201
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(user);
        }

}
