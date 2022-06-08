package org.example.http.mahasiswa.dto;

import javax.validation.constraints.NotEmpty;

public class JurusanCreateDto {
    @NotEmpty(message = "nama jurusan is required")
    public String nama_jurusan;
}
