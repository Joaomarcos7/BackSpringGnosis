package com.gnosiseducacao.api.service;

import com.gnosiseducacao.api.model.Student;
import com.gnosiseducacao.api.model.StudentDTO;
import com.gnosiseducacao.api.model.Subject;
import com.gnosiseducacao.api.repositories.StudentRepository;
import com.gnosiseducacao.api.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentrepository;

    @Autowired
    private SubjectRepository subjectrepository;

    public List<StudentDTO> getstudents(){
        return this.studentrepository.findAll().stream().map(StudentDTO::new).toList();
    }

    public Student getstudentbyid(Long id){
        return this.studentrepository.findById(id).orElse(null);
    }

    public StudentDTO getstudentDTObyid(Long id){
        return new StudentDTO(this.studentrepository.findById(id).orElse(null));
    }

    @Transactional
    public StudentDTO inserirouatualizar(Student student){
        Student aluno= this.studentrepository.save(student);
        return new StudentDTO(aluno);
    }

    public void apagar(long id){
        this.studentrepository.deleteById(id);
    }

    public List<StudentDTO> getstudentbyemail(String email){
        return this.studentrepository.findStudentsByEmail(email).stream().map(StudentDTO::new).toList();
    }

    @Transactional
    public void adicionarDisciplinaParaAluno(Long studentId, Long subjectId) {
        Student aluno = studentrepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        Subject disciplina = subjectrepository.findById(subjectId).orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada"));

        aluno.addSubject(disciplina);

        studentrepository.save(aluno);
        subjectrepository.save(disciplina);
    }

public List<StudentDTO> getstudentsbysubject(Long id) {
    return this.studentrepository.findstudentsbysubject(id).stream().map(StudentDTO::new).toList();
}




}
