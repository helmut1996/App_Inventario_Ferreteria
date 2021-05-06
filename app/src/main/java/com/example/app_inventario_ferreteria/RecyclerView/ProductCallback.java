package com.example.app_inventario_ferreteria.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;

public interface ProductCallback {
    void onProductoItemClick(  int pos,
                               ImageView imagenContainer,
                               ImageView imagenProducto,
                               TextView NombreProducto,
                               TextView CodigoProducto,
                               TextView PrecioYuan,
                               TextView UnidadMedida,
                               TextView PrecioCompra,
                               TextView Existencia);


}
