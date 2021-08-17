package com.example.apustruv.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apustruv.Model.DataModel;
import com.example.apustruv.Fragment.Notification_i_Fragment;
import com.example.apustruv.R;

import java.util.ArrayList;

public class My_adapter extends RecyclerView.Adapter<My_adapter.dataholder> {
    public static View.OnLongClickListener onLongClickListenr;
    ArrayList<DataModel> dataholder;

    public My_adapter(ArrayList<DataModel> dataholder) {
        this.dataholder = dataholder;
    }

    public My_adapter(Context context, ArrayList<DataModel> dataholder, Notification_i_Fragment notification_i) {




    }

    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notfi_recyccle, parent, false);
        return new dataholder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {
        holder.image.setImageResource(dataholder.get(position).getI_mage());
        holder.Desc.setText(dataholder.get(position).getD_esc());
        holder.Head.setText(dataholder.get(position).getH_ead());
        holder.T_ime.setText(dataholder.get(position).getT_ime());






    }


    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class dataholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView Desc, Head, T_ime;


        public dataholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.i_mage);
            Desc = itemView.findViewById(R.id.D_esc);
            Head = itemView.findViewById(R.id.H_ead);
            T_ime = itemView.findViewById(R.id.T_ime);



        }
    }
}
