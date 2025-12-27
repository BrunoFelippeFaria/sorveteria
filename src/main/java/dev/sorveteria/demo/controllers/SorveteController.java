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

import dev.sorveteria.demo.Dtos.SorveteUpdateDto;
import dev.sorveteria.demo.models.Sorvete;
import dev.sorveteria.demo.services.SorveteService;

@RestController
@RequestMapping("api/sorvetes")
public class SorveteController {
    private final SorveteService _sorveteService;
    
    public SorveteController(SorveteService sorveteService){
        this._sorveteService = sorveteService;
    }

    @GetMapping
    public List<Sorvete> getAll() {
        return _sorveteService.getAll();
    }

    @GetMapping("/{id}")
    public Sorvete getById(@PathVariable Long id) {
        return _sorveteService.getById(id);
    }

    @PostMapping()
    public Sorvete add(@RequestBody Sorvete sorvete){
        return _sorveteService.add(sorvete);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        _sorveteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody SorveteUpdateDto updateDto){
        _sorveteService.update(id, updateDto);
    }
}
