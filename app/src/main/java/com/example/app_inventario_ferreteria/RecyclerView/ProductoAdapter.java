package com.example.app_inventario_ferreteria.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_inventario_ferreteria.R;
import com.example.app_inventario_ferreteria.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

List<Producto>mdata;
String URL_IMAGE="https://www.online-image-editor.com/styles/2019/images/power_girl.png";

    public ProductoAdapter(List<Producto> mdata) {
        this.mdata = mdata;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext())
              .inflate(R.layout.item_producto,parent,false);

      return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        final Producto item= mdata.get(position);
      //  holder.tvnombre.setText(item.getNombreP());
       //   holder.tvcodigo.setText(item.getCodigoP());
        //  holder.tvprecioy.setText(String.valueOf(item.getPrecioY()));
       // holder.tvexistencia.setText(item.getExistenciaP());
       // holder.tvunidadmedida.setText(item.getUnidadM());

        Picasso.get().load(URL_IMAGE+item.getImg())
                // .error(R.drawable.error)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tvnombre,tvcodigo,tvprecioy,tvunidadmedida,tvexistencia;

        public ProductoViewHolder(@NonNull View itemView) {

            super(itemView);

            image=itemView.findViewById(R.id.ImagenProducto);
            tvnombre=itemView.findViewById(R.id.NombreProducto);
            tvcodigo=itemView.findViewById(R.id.CodigoProducto);
            tvprecioy=itemView.findViewById(R.id.PrecioY);
            tvunidadmedida=itemView.findViewById(R.id.UnidadMedida);
            tvexistencia=itemView.findViewById(R.id.Existencia);
        }
    }
}
