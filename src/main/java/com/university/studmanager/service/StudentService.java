package com.university.studmanager.service;

import com.university.studmanager.DTOs.StudentDTO;
import com.university.studmanager.domain.*;
import com.university.studmanager.exceptions.ErrorCodes;
import com.university.studmanager.exceptions.StudentAlreadyExistsException;
import com.university.studmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UsersService usersService;
    private final GrupaRepository grupaRepository;
    private final PasswordEncoder passwordEncoder;
    private final FacultateRepository facultateRepository;
    private final DepartamentRepository departamentRepository;
    private final AnRepository anRepository;
    private final SerieRepository serieRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, UsersService usersService,
                          GrupaRepository grupaRepository, PasswordEncoder passwordEncoder, UsersRepository usersRepository,
                          FacultateRepository facultateRepository,
                          DepartamentRepository departamentRepository,
                          AnRepository anRepository,
                          SerieRepository serieRepository) {
        this.studentRepository = studentRepository;
        this.usersService = usersService;
        this.grupaRepository = grupaRepository;
        this.passwordEncoder = passwordEncoder;
        this.facultateRepository = facultateRepository;
        this.departamentRepository = departamentRepository;
        this.anRepository = anRepository;
        this.serieRepository = serieRepository;
    }

    @Transactional
    public Student addStudent(StudentDTO studentDTO) throws StudentAlreadyExistsException {
        Optional<Student> studentToAdd = studentRepository.findByNrMatricolAndCnp(studentDTO.getNrMatricol(), studentDTO.getCnp());
        Optional<Grupa> grupaOptional = grupaRepository.findById(studentDTO.getIdGrupa());
        Optional<Facultate> facultateOptional = facultateRepository.findById(studentDTO.getIdFacultate());
        Optional<Departament> departamentOptional = departamentRepository.findById(studentDTO.getIdDepartament());
        Optional<An> anOptional = anRepository.findById(studentDTO.getIdAn());
        Optional<Serie> serieOptional = serieRepository.findById(studentDTO.getIdSerie());

        if (studentToAdd.isEmpty()) {
            String email = studentDTO.getPrenume() + "." + studentDTO.getNume() + "@stud.upb.ro";

            Users user = Users.builder()
                    .firstName(studentDTO.getPrenume())
                    .lastName(studentDTO.getNume())
                    .email(email)
                    .password(passwordEncoder.encode(studentDTO.getCnp()))
                    .role(Role.USER)
                    .build();

            usersService.addUser(user);

            Student student = Student.builder()
                    .nrMatricol(studentDTO.getNrMatricol())
                    .cnp(studentDTO.getCnp())
                    .serieCI(studentDTO.getSerieCI())
                    .nume(studentDTO.getNume())
                    .prenume(studentDTO.getPrenume())
                    .adresa(studentDTO.getAdresa())
                    .dataNastere(studentDTO.getDataNastere())
                    .user(user)
                    .facultate(facultateOptional.get())
                    .departament(departamentOptional.get())
                    .an(anOptional.get())
                    .serie(serieOptional.get())
                    .grupa(grupaOptional.get())
                    .build();
            Student addedStudent = studentRepository.save(student);
            return addedStudent;
        } else {
            throw new StudentAlreadyExistsException("Un student cu acest CNP si numar matricol deja exista!", ErrorCodes.STUDENT_ALREADY_EXISTS);
        }
    }

    public Student editStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findByIdStudent(studentDTO.getIdStudent());
        student.setNrMatricol(studentDTO.getNrMatricol());
        student.setCnp(studentDTO.getCnp());
        student.setSerieCI(studentDTO.getSerieCI());
        student.setNume(studentDTO.getNume());
        student.setPrenume(studentDTO.getPrenume());
        student.setAdresa(studentDTO.getAdresa());
        student.setDataNastere(studentDTO.getDataNastere());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudenti() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
