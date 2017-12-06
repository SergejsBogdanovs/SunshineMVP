package lv.st.sbogdano.sunshinemvp.data.source.remote;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import lv.st.sbogdano.sunshinemvp.data.Result;
import lv.st.sbogdano.sunshinemvp.data.source.WeatherDataSource;

/**
 * Implements loading weather data from remote server.
 */

public class WeatherRemoteDataSource implements WeatherDataSource{

  private static WeatherRemoteDataSource INSTANCE;

  private final static Result RESULT_SERVICE_DATA = new Result();

  public static WeatherRemoteDataSource newInstance() {
    if (INSTANCE == null) {
      INSTANCE = new WeatherRemoteDataSource();
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
