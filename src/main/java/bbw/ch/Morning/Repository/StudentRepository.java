package bbw.ch.Morning.Repository;

import bbw.ch.Morning.Model.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByEmail(String findByEmail);
}
