package org.example.Servicio;

import org.example.Modelo.Contacto;
import org.example.Modelo.NodoContacto;

import java.time.LocalDate;

public class Agenda {
    private NodoContacto raiz; // Raíz del árbol de contactos

    // Constructor que inicializa la raíz como null
    public Agenda() {
        this.raiz = null;
    }

    // Método para agregar un nuevo contacto a la agenda
    public void agregarContacto(String nombre, long telefono, String correoElectronico, LocalDate fechaNacimiento) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, correoElectronico, fechaNacimiento);
        this.raiz = insertar(this.raiz, nuevoContacto);
    }

    // Método recursivo para insertar un nuevo contacto en el árbol
    private NodoContacto insertar(NodoContacto nodo, Contacto contacto) {
        if (nodo == null) {
            return new NodoContacto(contacto);
        }
        if (contacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setIzdo(insertar(nodo.getIzdo(), contacto));
        } else {
            nodo.setDcho(insertar(nodo.getDcho(), contacto));
        }
        return nodo;
    }

    // Método para mostrar todos los contactos en orden
    public void mostrarContactos() {
        inOrden(this.raiz);
    }

    // Método recursivo para recorrer el árbol en orden
    private void inOrden(NodoContacto nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzdo());
            imprimirContacto(nodo.getContacto());
            inOrden(nodo.getDcho());
        }
    }

    // Método para imprimir los detalles de un contacto
    private void imprimirContacto(Contacto contacto) {
        System.out.println("Nombre: " + contacto.getNombre());
        System.out.println("Teléfono: " + contacto.getTelefono());
        System.out.println("Correo: " + contacto.getCorreoElectronico());
        System.out.println("Fecha: " + contacto.getFechaNacimiento());
        System.out.println();
    }

    // Método para buscar un contacto basado en un criterio
    public Contacto buscarContacto(String criterio) {
        return buscar(this.raiz, criterio);
    }

    // Método recursivo para buscar un contacto en el árbol
    private Contacto buscar(NodoContacto nodo, String criterio) {
        if (nodo == null) {
            return null;
        }
        if (criterio.equalsIgnoreCase(nodo.getContacto().getNombre()) ||
                criterio.equals(String.valueOf(nodo.getContacto().getTelefono())) ||
                criterio.equalsIgnoreCase(nodo.getContacto().getCorreoElectronico())) {
            imprimirContacto(nodo.getContacto());
            return nodo.getContacto();
        }
        Contacto izdoResult = buscar(nodo.getIzdo(), criterio);
        return (izdoResult != null) ? izdoResult : buscar(nodo.getDcho(), criterio);
    }

    // Método para eliminar un contacto del árbol
    public void eliminarContacto(String nombre) {
        this.raiz = eliminar(this.raiz, nombre);
    }

    // Método recursivo para eliminar un nodo del árbol
    private NodoContacto eliminar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setIzdo(eliminar(nodo.getIzdo(), nombre));
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            nodo.setDcho(eliminar(nodo.getDcho(), nombre));
        } else {
            if (nodo.getIzdo() == null) {
                return nodo.getDcho();
            } else if (nodo.getDcho() == null) {
                return nodo.getIzdo();
            }
            NodoContacto temp = minValorNodo(nodo.getDcho());
            nodo.setContacto(temp.getContacto());
            nodo.setDcho(eliminar(nodo.getDcho(), temp.getContacto().getNombre()));
        }
        return nodo;
    }

    // Método para encontrar el nodo con el valor mínimo
    private NodoContacto minValorNodo(NodoContacto nodo) {
        NodoContacto actual = nodo;
        while (actual.getIzdo() != null) {
            actual = actual.getIzdo();
        }
        return actual;
    }

    // Getters y Setters para la raíz del árbol
    public NodoContacto getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoContacto raiz) {
        this.raiz = raiz;
    }
}
