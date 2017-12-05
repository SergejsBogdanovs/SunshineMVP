package lv.st.sbogdano.sunshinemvp.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import lv.st.sbogdano.sunshinemvp.R;

public class WeatherActivity extends AppCompatActivity {

  private WeatherPresenter mWeatherPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);


  }
}
