package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

import org.example.domain.entity.Jurusan;
import org.example.domain.entity.Mahasiswa;
import org.example.domain.service.JurusanService;
import org.example.domain.service.MahasiswaService;
import org.example.http.mahasiswa.dto.MahasiswaCreateDto;
import org.example.http.mahasiswa.dto.MahasiswaShowDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService service;

    @Autowired
    private JurusanService jurService;

    @PostMapping
    public ResponseEntity<MahasiswaShowDto> create(
            @Valid @RequestBody MahasiswaCreateDto mhsDto) throws ParseException {

        Jurusan jur = jurService.get(mhsDto.jurusan);
        SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy");
        Date TglLahirMhs = formater.parse(mhsDto.tgl_lahir);

        Mahasiswa mhs = new Mahasiswa(mhsDto.nim, mhsDto.nama_mhs, mhsDto.tp_lahir,
                TglLahirMhs, mhsDto.no_hp, mhsDto.alamat, jur);

        mhs.setJurusan(jur);
        service.save(mhs);

        MahasiswaShowDto newMhs = new MahasiswaShowDto(mhs.getId(),
                mhs.getNim(), mhs.getNamaMhs(), mhs.getTpLahir(),
                mhs.getTglLahir(), mhs.getNoHp(), mhs.getAlamat(),
                mhs.getJurusan().getNamaJurusan());

        return ResponseEntity.ok().body(newMhs);

    }

    @GetMapping
    public List<MahasiswaShowDto> list() {
        List<Mahasiswa> mhsList = service.listAll();
        MahasiswaShowDto mhs;
        List<MahasiswaShowDto> listMhsDto = new LinkedList<MahasiswaShowDto>();
        for (Mahasiswa mahasiswa : mhsList) {
            mhs = new MahasiswaShowDto(mahasiswa.getId(),
                    mahasiswa.getNim(), mahasiswa.getNamaMhs(), mahasiswa.getTpLahir(),
                    mahasiswa.getTglLahir(), mahasiswa.getNoHp(), mahasiswa.getAlamat(),
                    mahasiswa.getJurusan().getNamaJurusan());
            listMhsDto.add(mhs);
        }
        return listMhsDto;
    }

    @GetMapping("/{id}")
    public MahasiswaShowDto show(
            @PathVariable(name = "id") Long id) {
        Mahasiswa mhs = service.show(id);
        MahasiswaShowDto mhsDto = new MahasiswaShowDto(mhs.getId(),
                mhs.getNim(), mhs.getNamaMhs(), mhs.getTpLahir(),
                mhs.getTglLahir(), mhs.getNoHp(), mhs.getAlamat(),
                mhs.getJurusan().getNamaJurusan());

        return mhsDto;
    }

}
