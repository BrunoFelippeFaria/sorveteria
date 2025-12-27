package dev.sorveteria.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.sorveteria.demo.Dtos.SorveteDto;
import dev.sorveteria.demo.Exeptions.NotFoundExeption;
import dev.sorveteria.demo.models.Sabor;
import dev.sorveteria.demo.models.Sorvete;
import dev.sorveteria.demo.repositories.SorveteRepository;
import jakarta.transaction.Transactional;

@Service
public class SorveteService {
    private final SorveteRepository sorveteRepository;
    private final SaborService SaborService;

    public SorveteService(SorveteRepository sorveteRepository, SaborService saborService){
        this.sorveteRepository = sorveteRepository;
        this.SaborService = saborService;
    }

    public Sorvete add(SorveteDto sorveteDto) {
        Sorvete sorvete = new Sorvete();
        mapFromDto(sorvete, sorveteDto);
        
        return sorveteRepository.save(sorvete);
    }

    public List<Sorvete> getAll(){
        return sorveteRepository.findAll();
    }

    public Sorvete getById(Long id){
        return sorveteRepository.findById(id)
            .orElseThrow(() -> new NotFoundExeption("Sorvete não encontrado."));
    }

    public void deleteById(Long id){
        sorveteRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, SorveteDto sorveteDto) {
        Sorvete sorvete = getById(id);
        mapFromDto(sorvete, sorveteDto);
    }

    private void mapFromDto (Sorvete sorvete, SorveteDto sorveteDto) {
        sorvete.setDescricao(sorveteDto.descricao());
        sorvete.setPreco(sorveteDto.preco());
        sorvete.setQuantidade(sorveteDto.quantidade());
        sorvete.setTipo(sorveteDto.tipo());
        
        Sabor sabor = SaborService.getById(sorveteDto.saborId());
        sorvete.setSabor(sabor); 
    }
}
