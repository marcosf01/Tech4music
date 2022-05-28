package com.tech4me.mymusics.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.mymusics.dto.MusicaDto;
import com.tech4me.mymusics.model.Musica;
import com.tech4me.mymusics.repository.MusicaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<MusicaDto> obterTodasAsMusicas() {
        List<Musica> musicas = repository.findAll();
        
        return musicas.stream()
            .map(m -> mapper.map(m, MusicaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDto buscarMusicaPorId(String id) {
        Optional<Musica> buscarMusica = repository.findById(id);

        if (buscarMusica.isPresent()) {
            return mapper.map(buscarMusica, MusicaDto.class);
        }
        return null;
    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto musica) {
        Musica salvarMusica = mapper.map(musica, Musica.class);
        repository.save(salvarMusica);
            return mapper.map(salvarMusica, MusicaDto.class); 
    }

    @Override
    public void deletarMusica(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public MusicaDto alterarMusica(String id, MusicaDto musicaAlterar) {
        Optional<Musica> buscarMusica = repository.findById(id);

        if (buscarMusica.isPresent()) {
            Musica musicaSalvar = mapper.map(musicaAlterar, Musica.class);
            musicaSalvar.setId(id);
            musicaSalvar = repository.save(musicaSalvar);
                return mapper.map(musicaSalvar, MusicaDto.class);
        }
        return null;
    }
    
}
