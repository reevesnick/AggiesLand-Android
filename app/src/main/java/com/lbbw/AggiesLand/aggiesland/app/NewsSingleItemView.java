package com.lbbw.AggiesLand.aggiesland.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.Parse;

/**
 * Created by BTX17-1 on 6/13/2014.
 */
public class NewsSingleItemView extends Activity {
    String dateLabel;
    String titleLabel;
    String bodyLabel;
    String imageLabel;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.newssingleitemview);


        Intent i = getIntent();
        // Get the result of rank
        dateLabel = i.getStringExtra("Date");
        // Get the result of country
        titleLabel = i.getStringExtra("Title");
        // Get the result of population
        bodyLabel = i.getStringExtra("Body");
        // Get the result of flag
        imageLabel = i.getStringExtra("imageFile");

        // Locate the TextViews in singleitemview.xml
        TextView txtdate = (TextView) findViewById(R.id.date);
        TextView txttitle = (TextView) findViewById(R.id.title);
        TextView txtbody = (TextView) findViewById(R.id.body);

        // Locate the ImageView in singleitemview.xml
        ImageView img = (ImageView) findViewById(R.id.image);

        // Set results to the TextViews
        txtdate.setText(dateLabel);
        txttitle.setText(titleLabel);
        txtbody.setText(bodyLabel);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(imageLabel, img);
    }

}
