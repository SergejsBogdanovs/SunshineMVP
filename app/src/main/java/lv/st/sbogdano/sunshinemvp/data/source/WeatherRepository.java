package lv.st.sbogdano.sunshinemvp.data.source;

import static com.google.common.base.Preconditions.checkNotNull;

import android.support.annotation.NonNull;
import lv.st.sbogdano.sunshinemvp.data.Result;

/**
 * Concrete implementation to load weather from data source into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */
public class WeatherRepository implements WeatherDataSource{

  private static WeatherRepository INSTANCE = null;

  private final WeatherDataSource mWeatherRemoteDataSource;

  private final WeatherDataSource mWeatherLocalDataSource;

  /**
   * This variable has package local visibility so it can be accessed from tests.
   */
  Result mCachedResult;

  /**
   * Marks the cache is invalid, to force an update the next time data is requested.
   */
  boolean mCacheIsDirty = false;

  // Prevent direct instantiation.
  private WeatherRepository(@NonNull WeatherDataSource weatherRemoteDataSource,
      @NonNull WeatherDataSource weatherLocalDataSource) {

    mWeatherRemoteDataSource = checkNotNull(weatherRemoteDataSource);
    mWeatherLocalDataSource = checkNotNull(weatherLocalDataSource);
  }

  public static WeatherRepository getInstance(WeatherDataSource weatherRemoteDataSource,
                                              WeatherDataSource weatherLocalDataSource) {
    if (INSTANCE == null) {
      INSTANCE = new WeatherRepository(weatherRemoteDataSource, weatherLocalDataSource);
    }
    return INSTANCE;
  }

  /**
   * Used to force {@link #getInstance(WeatherDataSource, WeatherDataSource)} to create new instance
   * next time it's called.
   */
  public static void destroyInstance() {
    INSTANCE = null;
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
