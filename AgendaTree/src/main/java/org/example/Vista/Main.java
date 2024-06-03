package org.example.Vista;

import org.example.Modelo.Contacto;
import org.example.Modelo.NodoContacto;
import org.example.Servicio.Agenda;
import org.example.Servicio.GestorSerializacion;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva agenda
        Agenda agenda = new Agenda();

        // Agregar contactos
        agenda.agregarContacto("Luis", 12345678, "luis@example.com", LocalDate.of(2002, 5, 8));
        agenda.agregarContacto("Mario", 98765432, "mario@example.com", LocalDate.of(2000, 8, 20));
        agenda.agregarContacto("Cindy", 45678912, "cindy@example.com", LocalDate.of(1995, 12, 23));
        agenda.agregarContacto("Henry", 84956251, "henry@example.com", LocalDate.of(2003, 10, 17));

        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        // Buscar un contacto por nombre
        System.out.println("\nBuscando el contacto de Cindy:");
        Contacto contactoNombre = agenda.buscarContacto("Cindy");


        // Buscar un contacto por número de teléfono
        System.out.println("\nBuscando el contacto con el número de teléfono 98765432:");
        Contacto contactoTelefono = agenda.buscarContacto("98765432");


        // Buscar un contacto por correo electrónico
        System.out.println("\nBuscando el contacto con el correo electrónico luis@example.com:");
        Contacto contactoCorreo = agenda.buscarContacto("luis@example.com");


        // Eliminar un contacto
        System.out.println("\nEliminando el contacto de Cindy:");
        agenda.eliminarContacto("Cindy");
        System.out.println("Contacto eliminado con éxito.");

        // Mostrar contactos después de la eliminación
        System.out.println("\nContactos en la agenda después de eliminar a Cindy:");
        agenda.mostrarContactos();

        // Serializar los contactos
        String rutaArchivo = "C:\\Users\\Wicho\\Desktop\\Backup\\Docs\\Semestre 5 y 7\\Progra 3 2024\\Examen Final\\exmP3.dat";
        GestorSerializacion.serializarContactos(agenda.getRaiz(), rutaArchivo);
        System.out.println("\nContactos serializados correctamente en " + rutaArchivo);

        // Deserializar los contactos
        NodoContacto raizDeserializada = GestorSerializacion.deserializarContactos(rutaArchivo);
        Agenda agendaDeserializada = new Agenda();
        agendaDeserializada.setRaiz(raizDeserializada);

        // Mostrar contactos después de la deserialización
        System.out.println("\nContactos después de la deserialización:");
        agendaDeserializada.mostrarContactos();
    }

    // Método auxiliar para mostrar el resultado de la búsqueda
    private static void mostrarResultadoBusqueda(Contacto contacto) {
        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getNombre());
            System.out.println("Teléfono: " + contacto.getTelefono());
            System.out.println("Correo: " + contacto.getCorreoElectronico());
            System.out.println("Fecha: " + contacto.getFechaNacimiento());
            System.out.println();
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }
}
