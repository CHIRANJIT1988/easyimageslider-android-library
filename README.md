# EasyImageSlider

EasyImageSlider is a image slider library with indicator.


# Installation

EasyImageSlider is installed by adding the following dependency to your build.gradle file:

```
dependencies {
    implementation 'com.chiranjit.ui:easyimageslider:1.0.0'
}
```

Note that EasyImageSlider depends on Android Support Library 27.1.1 so you will need to use compileSdkVersion 27 or higher. This change should be safe as compileSdkVersion does not change app behavior.

# Usage

To begin using EasyImageSlider, have your Activity (or Fragment):

## Image Resources

* **Drawable Image**
* **Network Image**
* **Bitmap Image**

### Methods

```
put() - pass image url or resource
```

```
with() - pass activity reference
```

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyImageSlider slider = findViewById(R.id.slider);

        slider.put(URL);
        slider.put(R.drawable.demo);
        slider.put(URL);

        slider.with(this);
    }
}
```

Layout file:

```
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.easyimageslider.EasyImageSlider
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:scaleType="centerCrop"
        app:layout_collapseMode="parallax" />

</RelativeLayout>
```

### Glide Version

Glide dependency used for this library for loading image. This information may helpful if found any glide dependancy conflict on your project

```
com.github.bumptech.glide:glide:4.7.1
```

## LICENSE

```
Copyright 2017 Chiranjit

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
