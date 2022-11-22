package com.example.order.controller;

import com.example.order.model.entidad.Orden;
import com.example.order.service.OrderServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class OrdenController {

    private final OrderServicio orderServicio;

    public OrdenController(OrderServicio orderServicio) {
        this.orderServicio = orderServicio;
    }

    @GetMapping(value = "/ordenes")
    public ResponseEntity<List<Orden>>  obtenerOrdenes() {
        return new ResponseEntity<>(orderServicio.obtenerOrdenes(), HttpStatus.OK) ;
    }

    @PostMapping(value = "/ordenes")
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        return new ResponseEntity<>(orderServicio.crearOrden(orden), HttpStatus.CREATED);
    }


    @PutMapping(value = "/ordenes")
    public  ResponseEntity<Orden> actualizarOrden(@RequestBody Orden orden) {
        return new ResponseEntity<>(orderServicio.actualizarOrden(orden), HttpStatus.OK);
    }

    @DeleteMapping(value = "/ordenes/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable("id") int id)  {
        orderServicio.eliminarOrden(id);
        return ResponseEntity.ok().build();
    }


}
