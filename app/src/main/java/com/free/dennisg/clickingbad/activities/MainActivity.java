package com.free.dennisg.clickingbad.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.free.dennisg.clickingbad.fragments.DistributionFragment;
import com.free.dennisg.clickingbad.fragments.ManufacturingFragment;
import com.free.dennisg.clickingbad.R;
import com.free.dennisg.clickingbad.adapters.MainViewPagerAdapter;
import com.free.dennisg.clickingbad.fragments.StatsFragment;
import com.free.dennisg.clickingbad.fragments.StoreFragment;
import com.squareup.otto.Bus;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.meth_per_sec_txt)
    TextView methPerSec;
    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    @BindView(R.id.cook_btn)
    Button cookButton;

    private Unbinder unbinder;
    private Bus eventBus;
    private FragmentManager fragmentManager;
    private MenuItem prevMenuItem;
    private int mainTicker = 0;
    private Timer timer;
    private boolean hasBeenPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind butterknife to activity layout components
        unbinder = ButterKnife.bind(this);

        // Register activity to be able to receive events from different classes
        eventBus = new Bus();
        eventBus.register(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_manufacturing:
                        setCurrentFragment(0);
                        return true;
                    case R.id.navigation_distribution:
                        setCurrentFragment(1);
                        return true;
                    case R.id.navigation_store:
                        setCurrentFragment(2);
                        return true;
                }
                return false;
            }

            private void setCurrentFragment(int itemId) {
                viewPager.setCurrentItem(itemId);
            }
        });

        viewPager.setOffscreenPageLimit(4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        setUpFragments(viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        startTicker();
    }

    @Override
    protected void onPause() {
        super.onPause();

        hasBeenPaused = true;
        stopTicker();
    }

    public void setUpFragments(ViewPager viewPager) {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ManufacturingFragment(), getResources().getString(R.string.title_manufacturing));
        adapter.addFragment(new DistributionFragment(), getResources().getString(R.string.title_distribution));
        adapter.addFragment(new StoreFragment(), getResources().getString(R.string.title_store));
        viewPager.setAdapter(adapter);
    }

    public void startTicker(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mainTicker++;
            }
        }, 1000, 1000);
    }

    public void stopTicker(){
        timer.cancel();
    }

    public int getMainTicker(){
        return mainTicker;
    }

    @OnClick(R.id.cook_btn)
    public void cookOnClick(){
        methPerSec.setText(String.valueOf(getMainTicker()));
    }

}
