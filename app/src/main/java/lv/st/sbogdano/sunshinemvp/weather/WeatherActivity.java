package lv.st.sbogdano.sunshinemvp.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import lv.st.sbogdano.sunshinemvp.R;
import lv.st.sbogdano.sunshinemvp.util.ActivityUtil;

public class WeatherActivity extends AppCompatActivity {

  @BindView(R.id.toolbar)
  Toolbar mToolbar;

  @BindView(R.id.drawer_layout)
  DrawerLayout mDrawerLayout;

  @BindView(R.id.nav_view)
  NavigationView mNavView;

  private WeatherPresenter mWeatherPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    ButterKnife.bind(this);

    // Set up the Toolbar
    setSupportActionBar(mToolbar);
    ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_menu);
    ab.setDisplayHomeAsUpEnabled(true);

    // Set up the Navigation Drawer.
    mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
    if (mNavView != null) {
      setupDrawerContent(mNavView);
    }

    WeatherFragment weatherFragment =
        (WeatherFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
    if (weatherFragment == null) {
      // Create the fragment.
      weatherFragment = WeatherFragment.newInstance();
      ActivityUtil.addFragmentToActivity(
          getSupportFragmentManager(),
          weatherFragment,
          R.id.contentFrame);
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        mDrawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void setupDrawerContent(NavigationView navView) {
    navView.setNavigationItemSelectedListener(item -> {
      switch (item.getItemId()) {
        case R.id.settings:
          //TODO launch settings activity
          Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
          break;
        case R.id.item_metric:
          //TODO implement Celsius
          Toast.makeText(this, "Celsius", Toast.LENGTH_SHORT).show();
          break;
        case R.id.item_imperial:
          // TODO implement Kelvin
          Toast.makeText(this, "Kelvin", Toast.LENGTH_SHORT).show();
        default:
          break;
      }

      // Close the navigation drawer when an item is selected.
      item.setChecked(true);
      mDrawerLayout.closeDrawers();
      return true;
    });
  }
}
