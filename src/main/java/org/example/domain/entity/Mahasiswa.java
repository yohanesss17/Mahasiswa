package org.example.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table (name = "t_mhs")
public class Mahasiswa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nim;
    private String namaMhs;
    private String tpLahir;
    private Date tglLahir;

    @Column(name = "no_hp")
    private String noHp;
    private String alamat;

    @ManyToOne(targetEntity = Jurusan.class)
    @JoinColumn(name = "jurusan")
    private Jurusan jurusan;

    public Mahasiswa() {
    }

    public Mahasiswa(Long id, String nim, String namaMhs, String tpLahir, Date tglLahir, String noHp, String alamat, Jurusan jurusan) {
        this.id = id;
        this.nim = nim;
        this.namaMhs = namaMhs;
        this.tpLahir = tpLahir;
        this.tglLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }

    public Mahasiswa(String nim, String namaMhs, String tpLahir, Date tglLahir, String noHp, String alamat, Jurusan jurusan) {
        this.nim = nim;
        this.namaMhs = namaMhs;
        this.tpLahir = tpLahir;
        this.tglLahir = tglLahir;
        this.noHp = noHp;
        this.alamat = alamat;
        this.jurusan = jurusan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getTpLahir() {
        return tpLahir;
    }

    public void setTpLahir(String tpLahir) {
        this.tpLahir = tpLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }
}
