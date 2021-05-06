package com.example.app_inventario_ferreteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.app_inventario_ferreteria.RecyclerView.ProductoAdapter;
import com.example.app_inventario_ferreteria.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainInventario extends Activity {

    private RecyclerView rvProducto;
    private ProductoAdapter productoAdapter;
    private List<Producto>mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inventario);

        initView();
        initmdataProducto();
        setupProductoAdapter();
    }

    private void setupProductoAdapter() {
        productoAdapter= new ProductoAdapter(mdata);
        rvProducto.setAdapter(productoAdapter);
    }

    private void initmdataProducto() {
    mdata= new ArrayList<>();
    mdata.add(new Producto("https://www.online-image-editor.com/styles/2019/images/power_girl.png"));
    }

    private void initView(){
        rvProducto=findViewById(R.id.List_Productos);
        rvProducto.setLayoutManager(new LinearLayoutManager(this));
        rvProducto.setHasFixedSize(true);
    }
}