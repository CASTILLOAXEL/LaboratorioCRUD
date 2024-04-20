package org.example.Conexion.CRUD;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.example.Conexion.MongoDBConnection;

public class PersonaCRUD {

    private static final String DB_NAME = "LaboratorioCRUD";
    private static final String COLLECTION_NAME = "personas";
    private final MongoCollection<Document> collection;
    // Constructor para inicializar la colección
    public PersonaCRUD(MongoCollection<Document> collection) {
        this.collection = collection;
    }
    public PersonaCRUD() {
        MongoClient mongoClient = MongoDBConnection.getInstance();
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        this.collection = database.getCollection(COLLECTION_NAME);
    }

    public void insertarPersona(String nombre,String Apellido, int edad, String ciudad) {
        Document persona = new Document("nombre", nombre)
                .append("Apellido", Apellido)
                .append("edad", edad)
                .append("ciudad", ciudad);
        collection.insertOne(persona);
        System.out.println("Persona insertada: " + persona);

    }

    public void mostrarPersonas() {
        System.out.println("Listado de personas:");
        collection.find().forEach(document -> System.out.println(document.toJson()));
    }

    public void actualizarPersona(String nombreActual, String nuevoNombre) {
          // Verificar si la persona existe antes de intentar actualizarla
            long count = collection.countDocuments(Filters.eq("nombre", nombreActual));


      collection.updateOne(new Document("nombre", nombreActual), new Document("$set", new Document("nombre", nuevoNombre)));
      System.out.println("Persona actualizada: " + nuevoNombre);
 }

public void eliminarPersona(String nombre) {
    // Verificar si la persona existe antes de intentar eliminarla
    long count = collection.countDocuments(Filters.eq("nombre", nombre));
    if (count > 0) {
        collection.deleteOne(new Document("nombre", nombre));
        System.out.println("Persona eliminada: " + nombre);
    } else {
        System.out.println("La persona no existe en la base de datos.");
    }
}
}

