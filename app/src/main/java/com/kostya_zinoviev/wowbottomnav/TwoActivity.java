package com.kostya_zinoviev.wowbottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
       // initilize
        final BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        // create item
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Home")) // drawable & string
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, " Books"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Music"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, " Movies & TV"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, " Games"))
                // Какой элемент будет активирован
                .setFirstSelectedPosition(1)
                // init
                .initialise();

        //слушатели

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected( int position) {
                //актив
                switch (position){
                    case 0:
                        Toast.makeText(TwoActivity.this, "item " + position + " is actived", Toast.LENGTH_SHORT).show();
                        bottomNavigationBar.setActiveColor(R.color.color_tab_1);
                        break;
                    case 1:
                        Toast.makeText(TwoActivity.this, "item " + position + " is actived", Toast.LENGTH_SHORT).show();
                        bottomNavigationBar.setActiveColor(R.color.color_tab_2);
                        break;
                    case 2:
                        Toast.makeText(TwoActivity.this, "item " + position + " is actived", Toast.LENGTH_SHORT).show();
                        bottomNavigationBar.setActiveColor(R.color.color_tab_3);
                        break;
                    case 3:
                        Toast.makeText(TwoActivity.this, "item " + position + " is actived", Toast.LENGTH_SHORT).show();
                        bottomNavigationBar.setActiveColor(R.color.color_tab_1);
                        break;
                    case 4:
                        Toast.makeText(TwoActivity.this, "item " + position + " is actived", Toast.LENGTH_SHORT).show();
                        bottomNavigationBar.setActiveColor(R.color.color_tab_2);
                        break;
                }
            }
            @Override
            public void onTabUnselected( int position) {
                //неактив
            }
            @Override
            public void onTabReselected( int position) {
                //переактивирован
            }
        });
    }
}
