package com.example.covidapp;

import java.util.Arrays;
import java.util.Objects;

public class RespuestaRegionesWS {
    private String info;
    private String fecha;
    private Boolean estado;
    private Reporte[] reporte;

    public RespuestaRegionesWS() {

    }

    public RespuestaRegionesWS(String info, String fecha, Boolean estado, Reporte[] reporte) {
        this.info = info;
        this.fecha = fecha;
        this.estado = estado;
        this.reporte = reporte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Reporte[] getReporte() {
        return reporte;
    }

    public void setReporte(Reporte[] reporte) {
        this.reporte = reporte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaRegionesWS that = (RespuestaRegionesWS) o;
        return Objects.equals(info, that.info) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(estado, that.estado) &&
                Arrays.equals(reporte, that.reporte);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(info, fecha, estado);
        result = 31 * result + Arrays.hashCode(reporte);
        return result;
    }

    @Override
    public String toString() {
        return "RespuestaRegionesWS{" +
                "info='" + info + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                ", reporte=" + Arrays.toString(reporte) +
                '}';
    }
}
