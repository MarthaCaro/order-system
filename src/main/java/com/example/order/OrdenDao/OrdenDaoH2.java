package com.example.order.OrdenDao;

import com.example.order.IDao;
import com.example.order.model.entidad.Orden;
import com.example.order.model.persistencia.ConfiguracionJDBC;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdenDaoH2 implements IDao<Orden> {

    private final static String TABLE ="ordenes";
    static Connection connection = ConfiguracionJDBC.getConnection();



    @Override
    public List<Orden> ObtenerOrdenes() {
        List<Orden> respuesta= new ArrayList<>();
        String query = "SELECT * FROM " + TABLE;

        PreparedStatement stmt;
        try {
            stmt= connection.prepareStatement(query);
            ResultSet resultSet= stmt.executeQuery();

            while (resultSet.next()){
                respuesta.add(new Orden(resultSet.getInt("id"),
                        resultSet.getInt("cantidad"), resultSet.getString("descripcion"), resultSet.getString("referencia")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  respuesta;

    }

    @Override
    public Orden crearOrden(Orden orden) {
        String insert ="INSERT INTO " +TABLE + " (cantidad, descripcion, referencia) VALUES(?, ?, ?)";
        PreparedStatement stmt;
        try{
            stmt= connection.prepareStatement(insert);
            stmt.setInt(1, orden.getCantidad());
            stmt.setString(2, orden.getDescripcion());
            stmt.setString(3, orden.getReferencia());

            stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orden;
    }

    @Override
    public Orden actualizarOrden(Orden orden) {

        String insert ="UPDATE  " +TABLE + " SET cantidad =?, descripcion=?, referencia=? WHERE id=?";
        PreparedStatement stmt;
        try{
            stmt= connection.prepareStatement(insert);
            stmt.setInt(1, orden.getCantidad());
            stmt.setString(2, orden.getDescripcion());
            stmt.setString(3, orden.getReferencia());
            stmt.setInt(4, orden.getId());

            stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orden;
    }

    @Override
    public void eliminarOrden(int id) {

        String delete= "DELETE FROM " + TABLE + " WHERE id= ?";
        PreparedStatement stmt;
        try {
            stmt= connection.prepareStatement(delete);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public boolean existeOrden(int id) {
        String query = "SELECT * FROM " + TABLE + " WHERE id = ?";
        PreparedStatement stmt;
        try {
            stmt= connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs= stmt.executeQuery();

            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
