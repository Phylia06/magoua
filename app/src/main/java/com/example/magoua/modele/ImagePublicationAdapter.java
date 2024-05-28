package com.example.magoua.modele;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.magoua.R;

import java.util.ArrayList;
import java.util.List;

public class ImagePublicationAdapter extends RecyclerView.Adapter<ImagePublicationAdapter.ViewHoler1> {
    Context context;
    private List<Drawable> imageList;

    public ImagePublicationAdapter() {
    }

    public ImagePublicationAdapter(List<Drawable> imageList, Context context) {
        this.imageList = imageList;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHoler1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_image,parent,false);
        return new ViewHoler1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler1 holder, int position) {
        Drawable drawable = imageList.get(position);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {

        return imageList.size();
    }


    public class ViewHoler1 extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHoler1(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagepublicate);
        }

    }


}
