package com.example.apustruv.AdapterClass;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.Model.NotificationModel;
import com.example.apustruv.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.dataholder> {

    private Context context;
    List<NotificationModel> arrayList=new ArrayList<>();
    public NotificationAdapter(Context context ) {
        this.context = context;
    }



    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notfi_recyccle, parent, false);
        return new dataholder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {
        NotificationModel model=arrayList.get(position);

        holder.Desc.setText(model.getDesc());
        holder.Head.setText(model.getHead());
        holder.Time.setText(model.getTime());

    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItems(List<NotificationModel> list){
        arrayList.clear();
        arrayList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class dataholder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView Desc, Head, Time;


        public dataholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.i_mage);
            Desc = itemView.findViewById(R.id.D_esc);
            Head = itemView.findViewById(R.id.H_ead);
            Time = itemView.findViewById(R.id.T_ime);


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {



                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.custom_dialogbox_delete);
                    TextView noClick = (TextView) dialog.findViewById(R.id.noID);
                    TextView yesClick = (TextView) dialog.findViewById(R.id.YesID);
                    // if button is clicked, close the custom dialog
                    noClick.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    yesClick.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String url = "http://www.apustrov.com/api/v1/user/deleteNotification";
                            RequestQueue requestQueue;
                            requestQueue = Volley.newRequestQueue(v.getContext());

                            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {


                                    try {
                                        Integer code = response.getInt("code");
                                        if (code == 1) {
                                            Toast.makeText(v.getContext(), response.getString("message"), Toast.LENGTH_LONG);
                                        } else {
                                            Toast.makeText(v.getContext(), response.getString("message"), Toast.LENGTH_LONG);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }

                            })
                            {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("id", "1");
                                    return params;
                                }

                                @Override
                                public Map<String, String> getHeaders() throws AuthFailureError {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("auth-token", "user_XJijJtlOWrt4D8o");
                                    return params;
                                }};

                            requestQueue.add(jsonObjectRequest);

                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    return true;
                }
            });




        }
    }
}
