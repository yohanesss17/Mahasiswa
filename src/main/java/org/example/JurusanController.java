package org.example;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.example.domain.entity.Jurusan;
import org.example.domain.service.JurusanService;
import org.example.http.mahasiswa.dto.JurusanCreateDto;
import org.example.http.mahasiswa.dto.JurusanShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jurusan")
public class JurusanController {
    @Autowired
    private JurusanService jurService;

    @PostMapping
    public ResponseEntity<JurusanShowDto> create(
            @Valid @RequestBody JurusanCreateDto jurusanDto) throws ParseException {

        Jurusan jurusan = new Jurusan(jurusanDto.nama_jurusan);
        jurService.save(jurusan);

        JurusanShowDto newJurusan = new JurusanShowDto(jurusan.getId(),
                jurusan.getNamaJurusan());

        return ResponseEntity.ok().body(newJurusan);
    }

    @GetMapping
    public List<JurusanShowDto> list() {
        List<Jurusan> jurusanList = jurService.listAll();
        JurusanShowDto jur;
        List<JurusanShowDto> listJurDto = new LinkedList<JurusanShowDto>();
        for (Jurusan jurusan : jurusanList) {
            jur = new JurusanShowDto(jurusan.getId(),
                    jurusan.getNamaJurusan());
            listJurDto.add(jur);
        }
        return listJurDto;
    }

    @GetMapping("/{id}")
    public JurusanShowDto show(
            @PathVariable(name = "id") Long id) {
        Jurusan jurusan = jurService.get(id);

        JurusanShowDto jurusanDto = new JurusanShowDto(jurusan.getId(),
                jurusan.getNamaJurusan());


        return jurusanDto;
    }

}
