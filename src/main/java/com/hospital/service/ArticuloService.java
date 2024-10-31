package com.hospital.service;

import com.hospital.entity.Articulo;
import com.hospital.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public Optional<Articulo> buscarArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    public List<Articulo> obtenerTodosLosArticulos() {
        return articuloRepository.findAll();
    }

    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}