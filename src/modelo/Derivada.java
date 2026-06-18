package modelo;

import java.util.Date;

public class Derivada {

    private int id;
    private String funcion;
    private String derivada;
    private String factorizacion;
    private Date fechaRegistro;

    //====================================================
    // CONSTRUCTORES
    //====================================================

    public Derivada() {
    }

    public Derivada(int id,
                    String funcion,
                    String derivada,
                    String factorizacion,
                    Date fechaRegistro) {

        this.id = id;
        this.funcion = funcion;
        this.derivada = derivada;
        this.factorizacion = factorizacion;
        this.fechaRegistro = fechaRegistro;
    }

    //====================================================
    // GETTERS Y SETTERS
    //====================================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getDerivada() {
        return derivada;
    }

    public void setDerivada(String derivada) {
        this.derivada = derivada;
    }

    public String getFactorizacion() {
        return factorizacion;
    }

    public void setFactorizacion(String factorizacion) {
        this.factorizacion = factorizacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    //====================================================
    // toString()
    //====================================================

    @Override
    public String toString() {

        return "Derivada{" +
                "id=" + id +
                ", funcion='" + funcion + '\'' +
                ", derivada='" + derivada + '\'' +
                ", factorizacion='" + factorizacion + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';

    }
}   