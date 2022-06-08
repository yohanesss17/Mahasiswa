package org.example.http.mahasiswa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MahasiswaCreateDto {

    @NotEmpty(message = "nim is required")
    public String nim;
    public String nama_mhs;
    public String tp_lahir;
    public String tgl_lahir;
    public String no_hp;
    public String alamat;
    @NotNull(message = "jurusan is required")
    public Long jurusan;

}
