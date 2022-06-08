package org.example.http.mahasiswa.dto;

import java.util.Date;

public class MahasiswaShowDto {
    
    public Long id;
    public String nim;
    public String nama_mhs;
    public String tp_lahir;
    public Date tgl_lahir;
    public String no_hp;
    public String alamat;
    public String nama_jurusan;

    public MahasiswaShowDto(Long id, String nim, String nama_mhs, String tp_lahir, Date tgl_lahir, String no_hp,
            String alamat, String nama_jurusan) {
        this.id = id;
        this.nim = nim;
        this.nama_mhs = nama_mhs;
        this.tp_lahir = tp_lahir;
        this.tgl_lahir = tgl_lahir;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.nama_jurusan = nama_jurusan;
    }

    
    
}
