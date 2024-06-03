package org.example.Modelo;

import java.io.Serializable;
import java.time.LocalDate;

// Clase que representa un contacto en la agenda
public class Contacto implements Serializable {
    // Atributos de un contacto
    private String nombre;
    private long telefono;
    private String correoElectronico;
    private LocalDate fechaNacimiento;

    // Constructor de la clase Contacto
    public Contacto(String nombre, long telefono, String correoElectronico, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Métodos para acceder y modificar el nombre del contacto
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para acceder y modificar el número de teléfono del contacto
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    // Métodos para acceder y modificar el correo electrónico del contacto
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Métodos para acceder y modificar la fecha de nacimiento del contacto
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
