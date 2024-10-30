package com.hospital.service;

import com.hospital.entity.Empleado;
import com.hospital.repository.EmpleadoRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Transactional
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerEmpleadoPorCodigo(String codigo) {
        Optional<Empleado> empleado = empleadoRepository.findByCodigo(codigo);
        return empleado.orElse(null);
    }

    @Transactional
    public Empleado actualizarEmpleado(Empleado empleado) {
    if (empleado.getId() == null) {
        throw new IllegalArgumentException("El ID del empleado es requerido para la actualización.");
    }

    Optional<Empleado> empleadoExistente = empleadoRepository.findById(empleado.getId());
    if (empleadoExistente.isPresent()) {
        Empleado actualizado = empleadoExistente.get();
        actualizado.setCodigo(empleado.getCodigo());
        actualizado.setNombre(empleado.getNombre());
        actualizado.setApellido(empleado.getApellido());
        actualizado.setCargo(empleado.getCargo());
        actualizado.setTelefono(empleado.getTelefono());
        actualizado.setCorreo(empleado.getCorreo());
        
        return empleadoRepository.save(actualizado);
    } else {
        throw new EntityNotFoundException("Empleado no encontrado con ID: " + empleado.getId());
    }
}


    @Transactional
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }
}
