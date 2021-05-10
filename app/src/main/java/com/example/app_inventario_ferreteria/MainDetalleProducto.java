package com.example.app_inventario_ferreteria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.app_inventario_ferreteria.model.Producto;

public class MainDetalleProducto extends Activity {

    ImageView imageProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_producto);

       // imageProducto=findViewById(R.id.)

        Producto item=(Producto) getIntent().getExtras().getSerializable("productoObject");
    }
}