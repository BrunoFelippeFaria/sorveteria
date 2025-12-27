package dev.sorveteria.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.sorveteria.demo.Dtos.SorveteUpdateDto;
import dev.sorveteria.demo.Exeptions.NotFoundExeption;
import dev.sorveteria.demo.models.Sorvete;
import dev.sorveteria.demo.repositories.SorveteRepository;
import jakarta.transaction.Transactional;

@Service
public class SorveteService {
    private final SorveteRepository _sorveteRepository;

    public SorveteService(SorveteRepository sorveteRepository){
        _sorveteRepository = sorveteRepository;
    }

    public Sorvete add(Sorvete sorvete) {
        return _sorveteRepository.save(sorvete);
    }

    public List<Sorvete> getAll(){
        return _sorveteRepository.findAll();
    }

    public Sorvete getById(Long id){
        return _sorveteRepository.findById(id)
            .orElseThrow(() -> new NotFoundExeption("Sorvete não encontrado."));
    }

    public void deleteById(Long id){
        _sorveteRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, SorveteUpdateDto sorveteDto) {
        Optional<Sorvete> sorveteOpt = _sorveteRepository.findById(id);

        if(sorveteOpt.isEmpty()) {
            throw new NotFoundExeption("Sorvete não encontrado.");
        }

        Sorvete sorvete = sorveteOpt.get();

        sorvete.setDescricao(sorveteDto.descricao());
        sorvete.setPreco(sorveteDto.preco());
        sorvete.setQuantidade(sorveteDto.quantidade());
        sorvete.setTipo(sorveteDto.tipo());

    }
}
