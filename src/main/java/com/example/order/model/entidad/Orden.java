package com.example.order.model.entidad;

public class Orden {

    private int id;
    private int cantidad;
    private String descripcion;
    private String referencia;

    public Orden() {
    }

    public Orden(int id, int cantidad, String descripcion, String referencia) {
        this.id = id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.referencia = referencia;
    }

    public Orden(int cantidad, String descripcion, String referencia) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.referencia = referencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
