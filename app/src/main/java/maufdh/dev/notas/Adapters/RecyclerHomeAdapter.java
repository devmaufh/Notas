package maufdh.dev.notas.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.util.List;

import maufdh.dev.notas.Application.App;
import maufdh.dev.notas.Models.ModelPizarra;
import maufdh.dev.notas.R;

public class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.ViewHolder> {
    Context context;
    private  List<ModelPizarra> pizarras;
    private int layout;
    OnItemClickListener itemClickListener;
    public RecyclerHomeAdapter(List<ModelPizarra> pizarras, int layout, OnItemClickListener itemClickListener) {
        this.pizarras = pizarras;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        context=parent.getContext();
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pizarras.get(position),itemClickListener);
    }
    @Override
    public int getItemCount() {
        return pizarras.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle,txtDate,txtNumberNotes;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle=(TextView)itemView.findViewById(R.id.cardview_txtTitle);
            txtDate=(TextView)itemView.findViewById(R.id.cardview_txtNumberNotes);
            txtNumberNotes=(TextView)itemView.findViewById(R.id.cardview_date);
        }
        public void bind(final ModelPizarra pizarra, final OnItemClickListener listener){
            txtTitle.setText(pizarra.getName());
            DateFormat dt=android.text.format.DateFormat.getDateFormat(context);
            txtDate.setText("Fecha de creación: "+dt.format(pizarra.getDate()));
            SQLiteStatement s= App.getSqlInstance().compileStatement("Select count(*)from pizarra;");
            txtNumberNotes.setText(s.simpleQueryForString()+" notas");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClickListener(pizarra,getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void itemClickListener(ModelPizarra pizarra,int position);
    }
}
