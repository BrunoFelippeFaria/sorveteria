package dev.sorveteria.demo.services;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.sorveteria.demo.Dtos.SaborDto;
import dev.sorveteria.demo.Exeptions.NotFoundExeption;
import dev.sorveteria.demo.models.Sabor;
import dev.sorveteria.demo.repositories.SaborRepository;
import jakarta.transaction.Transactional;

@Service
public class SaborService {
    private final SaborRepository saborRepository;

    public SaborService(SaborRepository saborRepository) {
        this.saborRepository = saborRepository;
    }
    
    public List<Sabor> getAll(){
        return saborRepository.findAll();
    }

    public Sabor getById(Long id){
        return saborRepository.findById(id)
            .orElseThrow(() -> new NotFoundExeption("Sabor não encontrado."));
    }

    public Sabor save(Sabor sabor){
        return saborRepository.save(sabor);
    }

    public void deleteById(Long id){
        saborRepository.deleteById(id);
    }

    @Transactional
    public Sabor update(long id, SaborDto saborDto){
        Sabor sabor = getById(id);
        sabor.setDescricao(saborDto.descricao());
        return sabor;
    }
}
