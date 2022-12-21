package bbw.ch.Morning.Service;

import  bbw.ch.Morning.Model.StudentEntity;
import  bbw.ch.Morning.Model.StudentEntity;
import  bbw.ch.Morning.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final  StudentRepository repository;

    public  StudentService( StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    public List< StudentEntity> loadAll() {
        return (List< StudentEntity>) repository.findAll();
    }

    public Optional< StudentEntity> loadOne(Long id) {
        return repository.findById(id);
    }

    public  StudentEntity create( StudentEntity studentEntity) {
        studentEntity.setPassword(studentEntity.getPassword());
        return repository.save(studentEntity);
    }

    @Transactional
    public StudentEntity update( StudentEntity updateStudent) {
        updateStudent.setPassword(updateStudent.getPassword());
        return repository.save(updateStudent);
    }

    public void delete(Long userId) {
        repository.deleteById(userId);
    }
}