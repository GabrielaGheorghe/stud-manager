package com.university.studmanager.service;

import com.university.studmanager.domain.Catalog;
import com.university.studmanager.domain.Student;
import com.university.studmanager.repository.CatalogRepository;
import com.university.studmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CatalogService(CatalogRepository catalogRepository,
                          StudentRepository studentRepository) {
        this.catalogRepository = catalogRepository;
        this.studentRepository = studentRepository;
    }

    public Catalog addNota(Catalog nota) {
        Catalog optionalNota = catalogRepository.findCatalogByMaterieAndStudent(nota.getMaterie(), nota.getStudent());
        if (optionalNota != null) {
            optionalNota.setNota(nota.getNota());
            return catalogRepository.save(optionalNota);
        }
        return catalogRepository.save(nota);
    }

    public List<Catalog> getNoteByStudent(Student student) {
        return catalogRepository.getAllByStudent(student);
    }
}
