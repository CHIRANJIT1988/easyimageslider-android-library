package com.easyimageslider;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class EasyImageSlider extends MyViewPager
{
    private static List<Object> resource = new ArrayList<>();
    private int currentPage;


    public EasyImageSlider(@NonNull Context context)
    {
        super(context);
    }

    public EasyImageSlider(@NonNull Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void with(Activity activity)
    {
        /**
         * Code for image swipe slider
         */
        ImageFragmentPagerAdapter imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(((FragmentActivity) activity).getSupportFragmentManager());
        this.pager.setOffscreenPageLimit(resource.size());
        this.pager.setAdapter(imageFragmentPagerAdapter);

        this.tabs.setupWithViewPager(this.pager, true);
    }

    private static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {

        private ImageFragmentPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public int getCount() {
            return resource.size();
        }

        @Override
        public Fragment getItem(int position)
        {
            return SwipeFragment.newInstance(position);
        }
    }


    public static class SwipeFragment extends Fragment implements View.OnClickListener {

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View swipeView = inflater.inflate(R.layout.swipe_fragment, container, false);
            final ImageView imageView = swipeView.findViewById(R.id.imageView);

            Bundle bundle = getArguments();
            imageView.setOnClickListener(this);

            final Object image = resource.get(bundle.getInt("position"));

            try
            {
                Glide.with(this)
                .asBitmap()
                .load(image)
                .thumbnail(0.1f)
                .apply(new RequestOptions().fitCenter())
                .into(new BitmapImageViewTarget(imageView) {

                    @Override
                    protected void setResource(Bitmap drawable)
                    {
                        super.setResource(drawable);
                    }
                });
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

            return swipeView;
        }

        static SwipeFragment newInstance(int position) {

            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);

            return swipeFragment;
        }

        @Override
        public void onClick(View v)
        {
            //Bundle bundle = getArguments();
            //Intent intent = new Intent(getActivity(), ImagePreviewActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.putExtra("URL",  bundle.getString("image"));
            //startActivity(intent);
        }
    }


    private void autoSlide() {

        final Handler handler = new Handler();

        final Runnable Update = new Runnable() {

            public void run() {

                if (currentPage == resource.size()) {
                    currentPage = 0;
                }

                EasyImageSlider.this.pager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();

        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 3000);
    }

    public void put(Object object)
    {
        resource.add(object);
    }
}