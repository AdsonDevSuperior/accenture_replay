package com.banco.completo.finaly.repository;

import com.banco.completo.finaly.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
