/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

//    private View numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);


        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}

//        // Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//
//        numbers.setOnClickListener(new View.OnClickListener() {
//
//                // The code in this method will be executed when the numbers category is clicked on.
//                @Override
//                public void onClick(View view) {
//                    // Create a new intent to open the {@link NumbersActivity}
//                    Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//
//                    // Start the new activity
//                    startActivity(numbersIntent);
//                }
//            });
//
//            // Find the View that shows the family category
//            TextView family = (TextView) findViewById(R.id.family);
//
//            // Set a click listener on that View
//        family.setOnClickListener(new View.OnClickListener() {
//                // The code in this method will be executed when the family category is clicked on.
//                @Override
//                public void onClick(View view) {
//                    // Create a new intent to open the {@link FamilyActivity}
//                    Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
//
//                    // Start the new activity
//                    startActivity(familyIntent);
//                }
//            });
//
//            // Find the View that shows the colors category
//            TextView colors = (TextView) findViewById(R.id.colors);
//
//            // Set a click listener on that View
//        colors.setOnClickListener(new View.OnClickListener() {
//                // The code in this method will be executed when the colors category is clicked on.
//                @Override
//                public void onClick(View view) {
//                    // Create a new intent to open the {@link ColorsActivity}
//                    Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
//
//                    // Start the new activity
//                    startActivity(colorsIntent);
//                }
//            });
//
//            // Find the View that shows the phrases category
//            TextView phrases = (TextView) findViewById(R.id.phrases);
//
//            // Set a click listener on that View
//             phrases.setOnClickListener(new View.OnClickListener() {
//                // The code in this method will be executed when the phrases category is clicked on.
//                @Override
//                public void onClick(View view) {
//                    // Create a new intent to open the {@link PhrasesActivity}
//                    Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
//
//                    // Start the new activity
//                    startActivity(phrasesIntent);
//                }
//    });


