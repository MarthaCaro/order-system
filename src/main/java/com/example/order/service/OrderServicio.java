package com.example.order.service;

import com.example.order.IDao;
import com.example.order.model.entidad.Orden;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServicio {

    private final IDao<Orden> ordenIDao;

    public OrderServicio(@Qualifier("ordenDaoH2") IDao<Orden> ordenIDao) {
        this.ordenIDao = ordenIDao;
    }


    public List<Orden> obtenerOrdenes(){
        return ordenIDao.ObtenerOrdenes();
    }



    public Orden crearOrden(Orden orden) {
        if( ordenIDao.existeOrden(orden.getId())){
            throw new RuntimeException("la orden ya existe");
        }
        Orden o= ordenIDao.crearOrden(orden);
        return o;
    }


    public Orden actualizarOrden(Orden orden){

        if( ordenIDao.existeOrden(orden.getId())){
            Orden o = ordenIDao.actualizarOrden(orden);
            return o;
        }

        throw new RuntimeException("la orden no existe");
    }


    public void eliminarOrden(int id) {

        if(ordenIDao.existeOrden(id)){
            ordenIDao.eliminarOrden(id);
        }else{
            throw new RuntimeException("la orden no existe");
        }



    }
}
