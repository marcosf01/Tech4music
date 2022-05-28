package com.tech4me.mymusics.service;

import java.util.List;

import com.tech4me.mymusics.dto.MusicaDto;

public interface MusicaService {

    List<MusicaDto> obterTodasAsMusicas();
    MusicaDto buscarMusicaPorId(String id);
    MusicaDto cadastrarMusica(MusicaDto musica);
    void deletarMusica(String id);
    MusicaDto alterarMusica(String id, MusicaDto musicaAlterar);
}
