package com.example.demo.controller;

import com.example.demo.model.Mahasiswa;
import com.example.demo.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("mahasiswa")
public class MahasiswaController {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @GetMapping("/")
    public List<Mahasiswa> all() {
        return mahasiswaRepository.findAll();
    }

    @GetMapping("/detail/{id}")
    public Optional<Mahasiswa> find(
            @PathVariable("id") Long id) {
        return mahasiswaRepository.findById(id);
    }

    @PostMapping("/tambah")
    public Mahasiswa add(
            @RequestParam("nama_depan") String namaDepan,
            @RequestParam("nama_belakang") String namaBelakang,
            @RequestParam("telp") String telp,
            @RequestParam("alamat") String alamat) {

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNamaDepan(namaDepan);
        mahasiswa.setNamaBelakang(namaBelakang);
        mahasiswa.setTelp(telp);
        mahasiswa.setAlamat(alamat);

        return mahasiswaRepository.save(mahasiswa);

    }

    @PutMapping("ubah/{id}")
    public Mahasiswa update(
            @PathVariable("id") Long id,
            @RequestParam("nama_depan") String namaDepan,
            @RequestParam("nama_belakang") String namaBelakang,
            @RequestParam("alamat") String alamat,
            @RequestParam("telp") String telp) {

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNamaDepan(namaDepan);
        mahasiswa.setNamaBelakang(namaBelakang);
        mahasiswa.setTelp(telp);
        mahasiswa.setAlamat(alamat);

        return mahasiswaRepository.save(mahasiswa);

    }

    @DeleteMapping("hapus/{id}")
    public void deleteById(
            @PathVariable("id") Long id
    ) {
        mahasiswaRepository.deleteById(id);

    }

}