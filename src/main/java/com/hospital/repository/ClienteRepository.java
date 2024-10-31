package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}