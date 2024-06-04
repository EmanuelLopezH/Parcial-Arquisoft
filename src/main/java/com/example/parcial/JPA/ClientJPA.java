package com.example.parcial.JPA;

import com.example.parcial.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJPA extends JpaRepository<Client, Long> {
}
