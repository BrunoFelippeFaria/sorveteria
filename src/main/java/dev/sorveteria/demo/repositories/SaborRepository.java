package dev.sorveteria.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.sorveteria.demo.models.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long>{
    
}
