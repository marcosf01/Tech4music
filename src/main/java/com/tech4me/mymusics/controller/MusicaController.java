package com.tech4me.mymusics.controller;

import java.util.List;

import com.tech4me.mymusics.dto.MusicaDto;
import com.tech4me.mymusics.service.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    
    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> obterMusicas() {
        return service.obterTodasAsMusicas();
    }
    
    @GetMapping("/{id}")
    public MusicaDto obterPorCodigo(@PathVariable String id) {
        return service.buscarMusicaPorId(id);
    }

    @PostMapping
    public MusicaDto cadastrar(@RequestBody MusicaDto musica) {
        return service.cadastrarMusica(musica);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletarMusica(id);
    }

    @PutMapping("/{id}")
    public MusicaDto alterar(@PathVariable String id, @RequestBody MusicaDto musica) {
        return service.alterarMusica(id, musica);
    }
}
