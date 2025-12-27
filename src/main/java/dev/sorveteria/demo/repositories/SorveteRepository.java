package dev.sorveteria.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sorveteria.demo.models.Sorvete;

@Repository
public interface SorveteRepository extends JpaRepository<Sorvete, Long> {
    
}
