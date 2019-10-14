package com.example.cureeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class PatientHome extends AppCompatActivity {

    CarouselView carouselView;
    int[] imageSamples = {R.drawable.tip1, R.drawable.tip2, R.drawable.tip3};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imageSamples[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_patient);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(imageSamples.length);
        carouselView.setImageListener(imageListener);
    }

}
