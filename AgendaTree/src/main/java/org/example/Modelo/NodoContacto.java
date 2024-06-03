package org.example.Modelo;

import java.io.Serializable;

public class NodoContacto implements Serializable {
    private Contacto contacto;
    private NodoContacto izdo;
    private NodoContacto dcho;

    // Constructor para inicializar el nodo con un contacto
    public NodoContacto(Contacto contacto) {
        this.contacto = contacto;
        this.izdo = null;
        this.dcho = null;
    }

    // Getter y Setter para el contacto
    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    // Getter y Setter para el nodo izquierdo
    public NodoContacto getIzdo() {
        return izdo;
    }

    public void setIzdo(NodoContacto izdo) {
        this.izdo = izdo;
    }

    // Getter y Setter para el nodo derecho
    public NodoContacto getDcho() {
        return dcho;
    }

    public void setDcho(NodoContacto dcho) {
        this.dcho = dcho;
    }
}
