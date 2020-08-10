package com.kostya_zinoviev.wowbottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import es.dmoral.toasty.Toasty;
//Kostya Zinoviev 15 years,13 jule,2020
public class MainActivity extends AppCompatActivity {
//В этом проетке присутствует 2 вида bottom nav,советую 1,MainActivity,так же customToast...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new TwoFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment).commit();
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.mipmap.ic_launcher, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.mipmap.ic_launcher, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.mipmap.ic_launcher, R.color.color_tab_3);

        //  Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        //  Change(менять) colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        // Управление заголовками
        // bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE); // Показывать,когда боттом нав активна
        // bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW); // Всегода показывать
        // bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE); // Всегда скрывать

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);

        //  Используйте цветную навигацию с эффектом кругового раскрытия

        //  Установить текущий элемент программно
        bottomNavigation.setCurrentItem(1);


        //  Используйте цветную навигацию с эффектом кругового раскрытия
        bottomNavigation.setColored(true);

        //  Набор слушателей

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new OneFragment();
                        Toasty.error(getApplicationContext() ,"This is an error toast" , Toast.LENGTH_SHORT, true).show();
                        break;
                    case 1:
                        fragment = new TwoFragment();
                        Toasty.warning(getApplicationContext() ,"This is an warning toast" , Toast.LENGTH_SHORT, true).show();
                        break;
                    case 2:
                        fragment = new ThreeFragment();
                        Toasty.custom(getApplicationContext(),"My custom toast",R.mipmap.ic_launcher,R.color.color_tab_2,Toast.LENGTH_SHORT,true,true).show();
                        break;
                }
                if (fragment != null) {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, fragment).commit();
                } else {
                    Toast.makeText(MainActivity.this, "Don t fragment", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {

            }
        });

        //  Customize notification (title, background, typeface)
        //bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

//  Add or remove notification for each item
        //bottomNavigation.setNotification(" 1 ", 3);
//  OR
        AHNotification notification = new AHNotification.Builder()
                .setText("1")
                .setBackgroundColor(getResources().getColor(R.color.color_notification_back))
                .setTextColor(getResources().getColor(R.color.color_notification_text))
                .build();
        bottomNavigation.setNotification(notification, 1);
    }

}
