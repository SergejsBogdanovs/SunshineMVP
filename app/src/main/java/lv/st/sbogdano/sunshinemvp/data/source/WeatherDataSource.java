package lv.st.sbogdano.sunshinemvp.data.source;


import android.support.annotation.NonNull;
import lv.st.sbogdano.sunshinemvp.data.Result;

/**
 * Main entry point to access weather data.
 * <p>
 * For simplicity, only getWeather() and getWeatherDetails() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 */
public interface WeatherDataSource {

  interface LoadWeatherCallback {

    void onWeatherLoaded(Result result);

    void onDataNotAvailable();
  }

  interface GetWeatherDetailsCallback {

    void onWeatherDeatilsLoaded(Result resultDetails);

    void onDataNotAvailable();
  }

  void getWeather(@NonNull LoadWeatherCallback callback);

  void getWeatherDetails(@NonNull String weatherId, @NonNull GetWeatherDetailsCallback callback);

  void refreshWeather();

}
