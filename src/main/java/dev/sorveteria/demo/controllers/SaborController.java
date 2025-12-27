package dev.sorveteria.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sorveteria.demo.Dtos.SaborDto;
import dev.sorveteria.demo.models.Sabor;
import dev.sorveteria.demo.services.SaborService;

@RestController
@RequestMapping("api/sorvetes/sabores")
public class SaborController {
    private final SaborService _SaborService;

    public SaborController(SaborService saborService){
        _SaborService = saborService;
    }

    @GetMapping
    public List<Sabor> getAll(){
        return _SaborService.getAll();
    }

    @GetMapping("/{id}")
    public Sabor getById(@PathVariable Long id) {
        return _SaborService.getById(id);
    }

    @PostMapping
    public Sabor create(@RequestBody Sabor sabor) {
        return _SaborService.save(sabor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        _SaborService.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody SaborDto saborDto) {
        _SaborService.update(id, saborDto);
    }

}
