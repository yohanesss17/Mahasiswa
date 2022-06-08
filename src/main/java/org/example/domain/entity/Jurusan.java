package org.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table (name = "t_jurusan")
public class Jurusan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_jurusan")
    private String namaJurusan;

    @OneToMany(targetEntity = Mahasiswa.class, mappedBy = "jurusan")
    private List<Mahasiswa> listMahasiswa;

    public Jurusan() {
    }

    public Jurusan(Long id, String namaJurusan) {
        this.id = id;
        this.namaJurusan = namaJurusan;
    }

    public Jurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    

}
