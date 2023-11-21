package com.example.newsxpress;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsxpress.Models.NewsHeadllines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadllines headllines;
    TextView txt_title,txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        txt_title=findViewById(R.id.text_detail_title);
        txt_author=findViewById(R.id.text_detail_author);
        txt_time=findViewById(R.id.text_detail_time);
        txt_detail=findViewById(R.id.text_detail_detail);
        txt_content=findViewById(R.id.text_detail_content);
        img_news=findViewById(R.id.img_detail_news);


        headllines= (NewsHeadllines) getIntent().getSerializableExtra("data");

        assert headllines != null;
        txt_title.setText(headllines.getTitle());
        txt_author.setText(headllines.getAuthor());
        txt_time.setText(headllines.getPublishedAt());
        txt_detail.setText(headllines.getDescription());
        txt_content.setText(headllines.getContent());
        Picasso.get().load(headllines.getUrlToImage()).into(img_news);
    }
}