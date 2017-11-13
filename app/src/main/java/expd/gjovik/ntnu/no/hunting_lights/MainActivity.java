package expd.gjovik.ntnu.no.hunting_lights;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import expd.gjovik.ntnu.no.hunting_lights.lightpollution.LightPollutionFragment;
import expd.gjovik.ntnu.no.hunting_lights.magnetfield.MagnetFieldFragment;
import expd.gjovik.ntnu.no.hunting_lights.route.RouteFragment;
import expd.gjovik.ntnu.no.hunting_lights.weather.WeatherFragment;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectFragment(item);
            return false;
        }
    };

    private void setupNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        if (bottomNavigationView != null) {
            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupNavigationView();
    }

    /**
     * Perform action when any item is selected.
     *
     * @param item Item that is selected.
     */
    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navigation_route:
                // Action to perform when Home Menu item is selected.
                pushFragment(RouteFragment.newInstance());
                break;
            case R.id.navigation_light_pollution:
                // Action to perform when Bag Menu item is selected.
                pushFragment(LightPollutionFragment.newInstance());
                break;
            case R.id.navigation_magnetfield:
                // Action to perform when Account Menu item is selected.
                pushFragment(MagnetFieldFragment.newInstance());
                break;
            case R.id.navigation_weather:
                // Action to perform when Account Menu item is selected.
                pushFragment(WeatherFragment.newInstance());
                break;
        }
    }

    /**
     * Method to push any fragment into given id.
     *
     * @param fragment An instance of Fragment to show into the given id.
     */
    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.fragment_frame, fragment);
                ft.commit();
            }
        }
    }

}
