package expd.gjovik.ntnu.no.hunting_lights;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class RouteActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_highest_chance:
                    mTextMessage.setText(R.string.nav_highest_chance);
                    return true;
                case R.id.navigation_magnetfield:
                    mTextMessage.setText(R.string.nav_magnetfield);
                    return true;
                case R.id.navigation_weather:
                    mTextMessage.setText(R.string.nav_weather);
                    return true;
                case R.id.navigation_light_pollution:
                    mTextMessage.setText(R.string.nav_light_pollution);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
