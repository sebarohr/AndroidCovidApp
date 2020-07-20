package com.example.covidapp;

import java.util.List;
import java.util.Objects;

public class RespuestaRegionWS{
    private String info;
    private Boolean estado;
    private List<Region> regiones;

    public RespuestaRegionWS(){

    }
    public RespuestaRegionWS(String info, Boolean estado, List<Region> regiones) {
        this.info = info;
        this.estado = estado;
        this.regiones = regiones;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaRegionWS that = (RespuestaRegionWS) o;
        return Objects.equals(info, that.info) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(regiones, that.regiones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, estado, regiones);
    }

    @Override
    public String toString() {
        return "RespuestaRegionWS{" +
                "info='" + info + '\'' +
                ", estado=" + estado +
                ", regiones=" + regiones +
                '}';
    }
}
