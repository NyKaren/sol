package com.example.demo.service;

import com.example.demo.controller.Registrar;
import com.example.demo.dao.RegistrarDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegistrarService {
    private RegistrarDao dao;

    public RegistrarService(@Autowired RegistrarDao dao) {
        this.dao = dao;
    }

    public List<Registrar> getAll() {
        this.dao.findAll();
    }

    public void persistOrMerge (Registrar conta) {
        this.dao.save(conta);
    }

    public Registrar findById(Long id) {
        this.dao.findById(id);
    }

    public void deleteById(long id) { this.dao.findById(id); }
}
