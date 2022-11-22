package com.example.order;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T>{

    List<T> ObtenerOrdenes();
    T crearOrden(T t);
    T actualizarOrden(T t);
    void eliminarOrden(int id);
    boolean existeOrden(int id);


}
