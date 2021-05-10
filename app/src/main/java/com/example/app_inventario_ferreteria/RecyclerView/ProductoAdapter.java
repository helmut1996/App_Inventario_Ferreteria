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

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

List<Producto>mdata;
    ProductCallback callback;
String URL_IMAGE="https://www.online-image-editor.com/styles/2019/images/power_girl.png";

    public ProductoAdapter(List<Producto> mdata,ProductCallback callback) {

        this.mdata = mdata;
        this.callback=callback;
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
         holder.tvnombre.setText(item.getNombreP());
          holder.tvcodigo.setText( String.valueOf(item.getCodigoP()));
          holder.tvprecioy.setText(String.valueOf(item.getPrecioY()));
          holder.tvexistencia.setText(String.valueOf(item.getExistenciaP()));
          holder.tvunidadmedida.setText(item.getUnidadM());
          holder.tvpreciocompra.setText(String.valueOf(item.getPrecioCompra()));

        Picasso.get().load(URL_IMAGE+item.getImg())
                // .error(R.drawable.error)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void filterList(ArrayList<Producto> filterList) {

        mdata=filterList;
        notifyDataSetChanged();
    }


    public class ProductoViewHolder extends RecyclerView.ViewHolder{

        ImageView image,imageContainer;
        TextView tvnombre,tvcodigo,tvprecioy,tvunidadmedida,tvexistencia,tvpreciocompra;

        public ProductoViewHolder(@NonNull View itemView) {

            super(itemView);

            imageContainer=itemView.findViewById(R.id.ImagenContainer2);
            image=itemView.findViewById(R.id.ImagenProducto);
            tvnombre=itemView.findViewById(R.id.NombreProducto);
            tvcodigo=itemView.findViewById(R.id.CodigoProducto);
            tvprecioy=itemView.findViewById(R.id.PrecioY);
            tvunidadmedida=itemView.findViewById(R.id.UnidadMedida);
            tvexistencia=itemView.findViewById(R.id.Existencia);
            tvpreciocompra=itemView.findViewById(R.id.PrecioCompra1);






            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onProductoItemClick(getAdapterPosition(),
                            imageContainer,
                            image,
                            tvnombre,
                            tvcodigo,
                            tvprecioy,
                            tvunidadmedida,
                            tvexistencia,
                            tvpreciocompra);
                }
            });
        }
    }
}
