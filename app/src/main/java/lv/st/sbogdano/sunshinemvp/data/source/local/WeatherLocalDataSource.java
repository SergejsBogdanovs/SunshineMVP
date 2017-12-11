package lv.st.sbogdano.sunshinemvp.data.source.local;

import static com.google.common.base.Preconditions.checkNotNull;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.PluralsRes;
import lv.st.sbogdano.sunshinemvp.data.source.WeatherDataSource;

public class WeatherLocalDataSource implements WeatherDataSource{

  private static WeatherLocalDataSource INSTANCE;

  private WeatherLocalDataSource(@NonNull Context context) {
    checkNotNull(context);
  }

  public static WeatherLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new WeatherLocalDataSource(context);
    }
    return INSTANCE;
  }

  @Override
  public void getWeather(@NonNull LoadWeatherCallback callback) {

  }

  @Override
  public void getWeatherDetails(@NonNull String weatherId,
      @NonNull GetWeatherDetailsCallback callback) {

  }

  @Override
  public void refreshWeather() {

  }
}
