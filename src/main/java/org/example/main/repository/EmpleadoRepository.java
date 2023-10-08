package org.example.main.repository;

import org.example.main.model.Empleados;
import org.example.main.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements BaseRepository<Empleados>{

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Override
    public List<Empleados> findAll() throws SQLException {
        List<Empleados> e = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM empleado")){
            while (resultSet.next()){
                Empleados empleados = creadoEmpleado(resultSet);

                e.add(empleados);
            }
        }

        return e;
    }



    @Override
    public Empleados getById(int id) throws SQLException {
        Empleados empleados = null;

        try(PreparedStatement statement = getConnection().prepareStatement("select * from empleado where id = ?")) {
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    empleados = creadoEmpleado(resultSet);
                }
            }
        }
        return empleados;
    }

    @Override
    public void save(Empleados empleados) throws SQLException {

        String sql = "INSERT INTO empleado (id,nombre,apellido,edad,posicion,salario) VALUE (?,?,?,?,?,?)";




        try (   Connection connection = getConnection();
                PreparedStatement statement = getConnection().prepareStatement(sql)){

                statement.setInt(1,empleados.getId());
                statement.setString(2,empleados.getNombre());
                statement.setString(3,empleados.getApellido());
                statement.setInt(4, empleados.getEdad());
                statement.setString(5,empleados.getPosicion());
                statement.setInt(6,empleados.getSalario());
                statement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        try(PreparedStatement statement = getConnection().prepareStatement("DELETE FROM  empleado where id=?");){
            statement.setInt(1,id);
            statement.executeUpdate();
        }

    }

    private Empleados  creadoEmpleado(ResultSet resultSet) throws SQLException {
        Empleados empleados = new Empleados();
        empleados.setId(resultSet.getInt("id"));
        empleados.setEdad(resultSet.getInt("edad"));
        empleados.setSalario(resultSet.getInt("salario"));
        empleados.setNombre(resultSet.getString("nombre"));
        empleados.setApellido(resultSet.getString("apellido"));
        empleados.setPosicion(resultSet.getString("posicion"));

        return empleados;
    }
}
