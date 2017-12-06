package lv.st.sbogdano.sunshinemvp.weather;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import java.util.List;
import lv.st.sbogdano.sunshinemvp.data.Weather;
import lv.st.sbogdano.sunshinemvp.weather.WeatherContract.Presenter;

/**
 * Displays the weather data.
 */
public class WeatherFragment extends Fragment implements WeatherContract.View{

  public WeatherFragment() {
  }

  @NonNull
  public static WeatherFragment newInstance() {
    return new WeatherFragment();
  }

  @Override
  public void setPresenter(Presenter presenter) {

  }

  @Override
  public void setLoadingIndicator(boolean active) {

  }

  @Override
  public void showWeather(List<Weather> weatherList) {

  }

  @Override
  public void showWeatherDetails(String weatherId) {

  }

  @Override
  public void showLoadingWeatherError() {

  }

  @Override
  public void showNoWeather() {

  }
}
