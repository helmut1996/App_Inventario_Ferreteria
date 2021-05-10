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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_inventario_ferreteria.DBConnection.DBConnection;
import com.example.app_inventario_ferreteria.RecyclerView.ProductCallback;
import com.example.app_inventario_ferreteria.RecyclerView.ProductoAdapter;
import com.example.app_inventario_ferreteria.model.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import androidx.core.util.Pair;

public class MainInventario extends Activity  implements ProductCallback {

    private RecyclerView rvProducto;
    private ProductoAdapter productoAdapter;
    private List<Producto>mdata;
    private EditText buscador;
    public static int stock;
    public static int IdInventario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inventario);

        initView();

        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    filter(s.toString());
            }
        });

    }

    private  void filter(String text){
        text = buscador.getText().toString().toUpperCase();

        if (!text.isEmpty()){
            setupProductoAdapter(text);
            ArrayList<Producto>filterList = new ArrayList<>();
            for(Producto item:mdata){
                if (item.getNombreP().toLowerCase().contains(text.toLowerCase())){
                    filterList.add(item);
                }
            }

            productoAdapter.filterList(filterList);
        }else{
            Toast.makeText(getApplicationContext(),"Producto no encontrado",Toast.LENGTH_LONG).show();
        }

    }

    private void setupProductoAdapter(String Buscar) {
        productoAdapter= new ProductoAdapter(mdata,this);
        rvProducto.setAdapter(productoAdapter);
        mdata=llenarProductosBD(Buscar);
    }

    public List<Producto> llenarProductosBD(String Buscar){
        try {

            DBConnection dbConnection = new DBConnection();
            dbConnection.conectar();

            Statement st = dbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("\n" +
                    "select  concat(i.Nombre, ' Y ', i.PCompraY,' ',um.Nombre) as Nombre,i.Nombre as Producto,um.Nombre as UM,i.idInventario, i.ImagenApk,i.Cod_Producto, i.Precio1,i.Precio2,i.Precio3,i.Precio4,i.Precio5,i.PrecioDolar1,i.PrecioDolar2,i.PrecioDolar3,i.PrecioDolar4,i.PrecioDolar5,PCompraY,PCompraD,i.Stock from Inventario i inner join Unidad_Medida um on i.idUndMedida=um.idUnidadMedida inner join InventarioInfoAdic ad on i.idInventario= ad.idInventario where i.Estado = 'Activo' and i.Nombre like '%desarmador%' and Stock >0" );

            while (rs.next()){

                mdata.add(new Producto(rs.getString("Nombre"),
                        rs.getString("Cod_Producto"),
                        rs.getDouble("PCompraY"),
                        rs.getString("UM"),
                        stock= rs.getInt("Stock"),
                        rs.getString("ImagenApk"),
                        rs.getDouble("PCompraD"),
                        IdInventario= rs.getInt("idInventario"),
                        rs.getDouble("Precio1"),
                        rs.getDouble("Precio2"),
                        rs.getDouble("Precio3"),
                        rs.getDouble("Precio4"),
                        rs.getDouble("Precio5"),
                        rs.getDouble("PrecioDolar1"),
                        rs.getDouble("PrecioDolar2"),
                        rs.getDouble("PrecioDolar3"),
                        rs.getDouble("PrecioDolar4"),
                        rs.getDouble("PrecioDolar5")));

            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return mdata;
    }


    private void initView(){
        rvProducto=findViewById(R.id.list_productos);
        buscador=findViewById(R.id.search2);
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