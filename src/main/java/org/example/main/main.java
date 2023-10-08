package org.example.main;
import org.example.main.model.Empleados;
import org.example.main.repository.BaseRepository;
import org.example.main.repository.EmpleadoRepository;
import org.example.main.util.DatabaseConnection;
import org.example.main.view.SwingApp;


import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {

        try(Connection con = DatabaseConnection.getInstance()){
            BaseRepository<Empleados> repository = new EmpleadoRepository();


//            repository.findAll().forEach(System.out::println);


//            System.out.println("----------------------");
//
//            Empleados empleados = new Empleados();

//            empleados.setId(6);
//            empleados.setNombre("elio");
//            empleados.setApellido("pinales");
//            empleados.setEdad(40);
//            empleados.setPosicion("QA");
//            empleados.setSalario(90000);
//
//            repository.save(empleados);
        }




    }
}
