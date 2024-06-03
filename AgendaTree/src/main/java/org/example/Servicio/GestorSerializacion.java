package org.example.Servicio;

import org.example.Modelo.NodoContacto;
import java.io.*;

public class GestorSerializacion {
    // Método para serializar los contactos en un archivo
    public static void serializarContactos(NodoContacto raiz, String nombreArchivo) {
        // Bloque para asegurar que los recursos se cierren automáticamente
        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Wicho\\Desktop\\Backup\\Docs\\Semestre 5 y 7\\Progra 3 2024\\Examen Final\\exmP3.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(raiz); // Serializa el objeto raíz y lo escribe en el archivo
            System.out.println("Los contactos han sido serializados correctamente.");
        } catch (IOException e) { // Captura cualquier excepción de entrada/salida
            System.out.println("Error al serializar los contactos: " + e.getMessage());
        }
    }

    // Método para deserializar los contactos desde un archivo
    public static NodoContacto deserializarContactos(String nombreArchivo) {
        NodoContacto raiz = null; // Inicializa la variable raíz

        // Bloque para asegurar que los recursos se cierren automáticamente
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            raiz = (NodoContacto) objectIn.readObject(); // Deserializa el objeto y lo asigna a raíz
            System.out.println("Los contactos han sido deserializados correctamente.");
        } catch (IOException | ClassNotFoundException e) { // Captura excepciones de entrada/salida y de clase no encontrada
            System.out.println("Error al deserializar los contactos: " + e.getMessage());
        }
        return raiz; // Retorna el objeto deserializado
    }
}
