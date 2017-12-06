package lv.st.sbogdano.sunshinemvp.util;

import static com.google.common.base.Preconditions.checkNotNull;

import android.content.Context;
import android.support.annotation.NonNull;
import lv.st.sbogdano.sunshinemvp.data.source.WeatherRepository;
import lv.st.sbogdano.sunshinemvp.data.source.local.WeatherLocalDataSource;
import lv.st.sbogdano.sunshinemvp.data.source.remote.WeatherRemoteDataSource;

/**
 * Enables injection of mock implementations for
 * {@link WeatherDataSource} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

  public static WeatherRepository provideWeatherRepository(@NonNull Context context) {
    checkNotNull(context);

    return WeatherRepository.getInstance(
        WeatherRemoteDataSource.getInstance(),
        WeatherLocalDataSource.getInstance(context));
  }
}
