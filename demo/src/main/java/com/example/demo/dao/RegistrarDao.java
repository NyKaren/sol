package com.example.demo.dao;

import com.example.demo.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrarDao extends JpaRepository<Conta, Long> {

}
