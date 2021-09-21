package com.example.apustruv.AdapterClass;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apustruv.Activity.CommentRepliesActivity;
import com.example.apustruv.Constant.Constants;
import com.example.apustruv.Interface.OnItemClickListener;
import com.example.apustruv.Model.CommentData;
import com.example.apustruv.Model.HomeDataModel;
import com.example.apustruv.Model.likeDislikeModel;
import com.example.apustruv.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.dataViewHolder> {

    List<Integer> data;
    Context context;
    LayoutInflater layoutInflater;
    String totalcount;

    List<HomeDataModel> arrayList = new ArrayList<>();



    public HomeAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public dataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_home_layout, parent, false);

        return new dataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataViewHolder holder, @SuppressLint("RecyclerView") int position) {
        HomeDataModel model = arrayList.get(position);
//        String userName = sharedPreferences.getString("username","");
//        String profileImage = sharedPreferences.getString("profile_img","");
        //  holder.profileName.setText(data.get(position).getProfileName());
        //  holder.like.setText(data.get(position).getLikeIncrement());
        // Picasso.get().load(data.get(position).getProfilePhoto()).into(holder.profileImage);

        try {
            Picasso.get().load(model.getPostUrl()).into(holder.postImage);
//           holder.profileName.setText(userName);
//            Picasso.get().load(profileImage).into(holder.profileImage);


        } catch (Exception e) {
            e.printStackTrace();
        }


        CommentAdapter commentAdapter = new CommentAdapter();
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));


        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,model.getPostUrl());

                sendIntent.setType("text/plain");
                Intent.createChooser(sendIntent,"Share via");
                context.startActivity(sendIntent);
            }
        });

        // holder.postImage.setImageResource(data.get(position));

        holder.likeButtonHeart.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                if(likeButton.isLiked()){
                    likedataupdate(model.getId());
                    holder.like.setText(totalcount);

                }else{

                    likedataupdate(model.getId());
                    holder.like.setText(totalcount);
                }

            }

            @Override
            public void unLiked(LikeButton likeButton) {

                if(!(likeButton.isLiked())){

                    likedataupdate(model.getId());
                    holder.like.setText(totalcount);
                }else{
                    likedataupdate(model.getId());
                    holder.like.setText(totalcount);
                }
            }
        });


        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.llactionComment.getVisibility() == View.GONE) {
                    holder.llactionComment.setVisibility(View.VISIBLE);
                } else {
                    holder.llactionComment.setVisibility(View.GONE);
                }
            }
        });

        EmojiPopup popup = EmojiPopup.Builder.fromRootView(holder.emojiLl).build(holder.edtComment);

        holder.emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.toggle();
            }
        });

        holder.ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = holder.edtComment.getText().toString().trim();
                // holder.commentmsg.setText(inputValue);

                addComment(String.valueOf(model.getId()), inputValue, holder.recyclerView, commentAdapter, holder.edtComment);
            }
        });

        holder.showMoreReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), CommentRepliesActivity.class);
                intent.putExtra("postID",model.getId());
                holder.itemView.getContext().startActivity(intent);

            }
        });

        holder.reportDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.reportLayout.getVisibility() == View.GONE){
                    holder.reportLayout.setVisibility(View.VISIBLE);
                }else{
                    holder.reportLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void likedataupdate(Integer id) {
        List<CommentData> commentList = new ArrayList<>();
        String url = Constants.LIKE_DISLIKE;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);

        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonArray = jsonObject.getJSONObject("payload");
                    totalcount = jsonArray.getString("total_counts");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> jsonBody = new HashMap<>();
                jsonBody.put("post_id", Integer.toString(id));
                return jsonBody;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> heads = new HashMap<String, String>();
                heads.put("auth-token", Constants.AUTH_TOKEN);
                return heads;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }


    public void addItems(List<HomeDataModel> list) {
        arrayList.clear();
        arrayList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class dataViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImage, postImage, comment, share, refresh, heart, ivSend, emoji;
        TextView profileName, follow, like, reportDot, notes, showMoreReply,time,date;
        LinearLayout llactionComment,emojiLl;
        RelativeLayout reportLayout;
        LikeButton  likeButtonHeart;
        EditText edtComment;
        RecyclerView recyclerView;


        public dataViewHolder(@NonNull View itemView) {
            super(itemView);


            profileImage = itemView.findViewById(R.id.statusImageHome);
            postImage = itemView.findViewById(R.id.postImageID);
            profileName = itemView.findViewById(R.id.profileNameID);
          //  heart = itemView.findViewById(R.id.clickLike);
            likeButtonHeart = itemView.findViewById(R.id.likeButtonHeart);
            like = itemView.findViewById(R.id.likeInc);
            comment = itemView.findViewById(R.id.commentIconID);
            llactionComment = itemView.findViewById(R.id.ll_action_coment_layout);
            edtComment = itemView.findViewById(R.id.edt_comment);
            ivSend = itemView.findViewById(R.id.iv_send);
            emoji = itemView.findViewById(R.id.iv_emoji);
            showMoreReply = itemView.findViewById(R.id.showMoreCommentID);
            recyclerView = itemView.findViewById(R.id.commentSectionRecyclerViewID);
            share = itemView.findViewById(R.id.shareID);
            time  = itemView.findViewById(R.id.timeID);
            date = itemView.findViewById(R.id.dateID);
            reportLayout = itemView.findViewById(R.id.reportID);
            reportDot = itemView.findViewById(R.id.reportDotID);
            emojiLl = itemView.findViewById(R.id.rootViewID);

        }
    }

    private void addComment(String post_id, String inputValue, RecyclerView recyclerView, CommentAdapter commentAdapter, EditText edtComment) {
        List<CommentData> commentList = new ArrayList<>();
        String url = Constants.ADD_COMMENT;
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(context);

        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("payload");

                    if (jsonArray.length() > 0) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            CommentData commentData = new CommentData();
                            commentData.setName(jsonArray.getJSONObject(i).getString("name"));
                            commentData.setProfileImg(jsonArray.getJSONObject(i).getString("profile_img"));
                            commentData.setContent(jsonArray.getJSONObject(i).getString("content"));
                            commentData.setCreatedTime(jsonArray.getJSONObject(i).getString("created_time"));
                            commentList.add(commentData);
                        }
                        recyclerView.setAdapter(commentAdapter);
                        commentAdapter.addItems(commentList);
                        edtComment.setText("");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> jsonBody = new HashMap<>();
                jsonBody.put("post_id", post_id);
                jsonBody.put("content", inputValue);
                return jsonBody;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> heads = new HashMap<String, String>();
                heads.put("auth-token", Constants.AUTH_TOKEN);
                return heads;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }
}
