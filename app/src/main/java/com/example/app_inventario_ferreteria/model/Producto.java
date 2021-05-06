package com.example.app_inventario_ferreteria.model;

public class Producto {
 private String nombreP;
 private int CodigoP;
 private double PrecioY;
 private String unidadM;
 private int ExistenciaP;
 private String img;


    public Producto(String s) {
    }

    public Producto(String nombreP, int codigoP, double precioY, String unidadM, int existenciaP, String img) {
        this.nombreP = nombreP;
        CodigoP = codigoP;
        PrecioY = precioY;
        this.unidadM = unidadM;
        ExistenciaP = existenciaP;
        this.img = img;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public int getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(int codigoP) {
        CodigoP = codigoP;
    }

    public double getPrecioY() {
        return PrecioY;
    }

    public void setPrecioY(double precioY) {
        PrecioY = precioY;
    }

    public String getUnidadM() {
        return unidadM;
    }

    public void setUnidadM(String unidadM) {
        this.unidadM = unidadM;
    }

    public int getExistenciaP() {
        return ExistenciaP;
    }

    public void setExistenciaP(int existenciaP) {
        ExistenciaP = existenciaP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
