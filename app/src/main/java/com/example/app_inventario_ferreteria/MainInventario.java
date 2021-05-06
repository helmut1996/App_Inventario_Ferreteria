package com.example.app_inventario_ferreteria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_inventario_ferreteria.RecyclerView.ProductCallback;
import com.example.app_inventario_ferreteria.RecyclerView.ProductoAdapter;
import com.example.app_inventario_ferreteria.model.Producto;

import java.util.ArrayList;
import java.util.List;
import androidx.core.util.Pair;

public class MainInventario extends Activity  implements ProductCallback {

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
        productoAdapter= new ProductoAdapter(mdata,this);
        rvProducto.setAdapter(productoAdapter);
    }

    private void initmdataProducto() {
    mdata= new ArrayList<>();
    mdata.add(new Producto("https://www.online-image-editor.com/styles/2019/images/power_girl.png"));
    mdata.add(new Producto("https://www.online-image-editor.com/styles/2019/images/power_girl.png"));
      mdata.add(new Producto("https://www.online-image-editor.com/styles/2019/images/power_girl.png"));
    }

    private void initView(){
        rvProducto=findViewById(R.id.List_Productos);
        rvProducto.setLayoutManager(new LinearLayoutManager(this));
        rvProducto.setHasFixedSize(true);
    }

    @Override
    public void onProductoItemClick(int pos,
                                    ImageView imagenContainer,
                                    ImageView imagenProducto,
                                    TextView NombreProducto,
                                    TextView CodigoProducto,
                                    TextView PrecioYuan,
                                    TextView UnidadMedida,
                                    TextView PrecioCompra,
                                    TextView Existencia) {

        Intent intent=new Intent(this,MainDetalleProducto.class);
        intent.putExtra("productoObject",mdata.get(pos));


        Pair<View,String> p1=Pair.create((View)imagenContainer,"ContainerTM");
        Pair<View,String> p2=Pair.create((View)imagenProducto,"ProductoImagenTM");
        Pair<View,String> p3=Pair.create((View)NombreProducto,"NombreTM");
        Pair<View,String> p4=Pair.create((View)CodigoProducto,"codigoTM");
        Pair<View,String> p5=Pair.create((View)PrecioYuan,"precioYTM");
        Pair<View,String> p6=Pair.create((View)UnidadMedida,"UnidadMedidaTM");
        Pair<View,String> p7=Pair.create((View)PrecioCompra,"PrecioCTM");
        Pair<View,String> p8=Pair.create((View)imagenContainer,"ExistenciaTM");

        ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3,p4,p5,p6,p7,p8);
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                    startActivity(intent,optionsCompat.toBundle());
                }else {
                    startActivity(intent);
                }
    }
}