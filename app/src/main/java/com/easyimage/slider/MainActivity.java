package com.easyimage.slider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.easyimageslider.EasyImageSlider;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyImageSlider slider = findViewById(R.id.slider);

        slider.put("https://i2.wp.com/beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg?resize=640%2C426");
        slider.put(R.drawable.demo);
        slider.put("https://static.wamiz.fr/images/news/facebook/article/sans-titre-69-fb-5a3b86ea88b62.jpg");

        slider.with(this);
    }
}