package interfaces;

import com.example.springrestapi.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface IStudentRepository {
    Iterable<Student> findAll();
    Optional<Student> findById(Long id);
    void deleteById(Long id);
    void createStudent(Student student);
}
