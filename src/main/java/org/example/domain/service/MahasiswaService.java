package org.example.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.example.domain.entity.Mahasiswa;
import org.example.domain.repository.MahasiswaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MahasiswaService {
    @Autowired
    private MahasiswaRepo repo;

    public List<Mahasiswa> listAll() {

        return repo.findAll();
    }

    public void save(Mahasiswa mahasiswa) {
        repo.save(mahasiswa);
    }

    public Mahasiswa get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Mahasiswa show(Long id) {
        Mahasiswa mhs = repo.findById(id).get();
        return mhs;
    }
}
