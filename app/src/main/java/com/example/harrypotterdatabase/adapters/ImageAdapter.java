package com.example.harrypotterdatabase.adapters;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ImageAdapter {


    @BindingAdapter({"app:url"})
    public static void loadImage(ImageView view, String url){

        Picasso.get().load(url).into(view);

    }
}
