package org.example.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.example.domain.entity.Jurusan;
import org.example.domain.repository.JurusanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JurusanService {
    @Autowired
    private JurusanRepo repo;

    public List<Jurusan> listAll() {

        return repo.findAll();
    }

    public void save(Jurusan jurusan) {
        repo.save(jurusan);
    }

    public Jurusan get(Long id) {
        return repo.findById(id).get();
    }

}
