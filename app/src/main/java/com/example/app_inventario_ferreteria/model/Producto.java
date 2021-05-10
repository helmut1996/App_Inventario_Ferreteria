package com.example.app_inventario_ferreteria.model;

import java.io.Serializable;

public class Producto implements Serializable {
 private String nombreP;
 private int CodigoP;
 private double PrecioY;
 private String unidadM;
 private int ExistenciaP;
 private String img;
 private double PrecioCompra;
 private  int idproducto;
 private double PrecioC1;
 private double PrecioC2;
 private double PrecioC3;
 private double PrecioC4;
 private double PrecioC5;
 private double PrecioD1;
 private double PrecioD2;
 private double PrecioD3;
 private double PrecioD4;
 private double PrecioD5;

    public Producto(String nombre, String cod_producto, double pCompraY, String um, int stock, String imagenApk, double pCompraD, int idInventario, double precio1, double precio2, double precio3, double precio4, double precio5, double precioDolar1, double precioDolar2, double precioDolar3, double precioDolar4, double precioDolar5) {
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

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        PrecioCompra = precioCompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getPrecioC1() {
        return PrecioC1;
    }

    public void setPrecioC1(double precioC1) {
        PrecioC1 = precioC1;
    }

    public double getPrecioC2() {
        return PrecioC2;
    }

    public void setPrecioC2(double precioC2) {
        PrecioC2 = precioC2;
    }

    public double getPrecioC3() {
        return PrecioC3;
    }

    public void setPrecioC3(double precioC3) {
        PrecioC3 = precioC3;
    }

    public double getPrecioC4() {
        return PrecioC4;
    }

    public void setPrecioC4(double precioC4) {
        PrecioC4 = precioC4;
    }

    public double getPrecioC5() {
        return PrecioC5;
    }

    public void setPrecioC5(double precioC5) {
        PrecioC5 = precioC5;
    }

    public double getPrecioD1() {
        return PrecioD1;
    }

    public void setPrecioD1(double precioD1) {
        PrecioD1 = precioD1;
    }

    public double getPrecioD2() {
        return PrecioD2;
    }

    public void setPrecioD2(double precioD2) {
        PrecioD2 = precioD2;
    }

    public double getPrecioD3() {
        return PrecioD3;
    }

    public void setPrecioD3(double precioD3) {
        PrecioD3 = precioD3;
    }

    public double getPrecioD4() {
        return PrecioD4;
    }

    public void setPrecioD4(double precioD4) {
        PrecioD4 = precioD4;
    }

    public double getPrecioD5() {
        return PrecioD5;
    }

    public void setPrecioD5(double precioD5) {
        PrecioD5 = precioD5;
    }
}
