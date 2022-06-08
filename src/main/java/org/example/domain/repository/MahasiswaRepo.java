package org.example.domain.repository;

import org.example.domain.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long>  {

    Mahasiswa findByNamaMhs(String name);
}
