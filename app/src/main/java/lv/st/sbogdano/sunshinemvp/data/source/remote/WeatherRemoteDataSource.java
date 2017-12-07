package lv.st.sbogdano.sunshinemvp.data.source.remote;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import lv.st.sbogdano.sunshinemvp.BuildConfig;
import lv.st.sbogdano.sunshinemvp.data.Result;
import lv.st.sbogdano.sunshinemvp.data.api.OpenWeatherMapClient;
import lv.st.sbogdano.sunshinemvp.data.source.WeatherDataSource;
import lv.st.sbogdano.sunshinemvp.util.SunshinePreferences;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Implements loading weather data from remote server.
 */

public class WeatherRemoteDataSource implements WeatherDataSource{

  private Context context;

  private static WeatherRemoteDataSource INSTANCE;

  private static Result RESULT_SERVICE_DATA = new Result();

  /* The format we want our API to return */
  private static final String format = "json";
  /* The units we want our API to return */
  private static final String units = "metric";
  /* The number of days we want our API to return */
  private static final String numDays = "14";


  private WeatherRemoteDataSource(@NonNull Context context) {
    this.context = context;
  }

  public static WeatherRemoteDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) {
      INSTANCE = new WeatherRemoteDataSource(context);
    }
    return INSTANCE;
  }

  @Override
  public void getWeather(@NonNull LoadWeatherCallback callback) {

    Retrofit.Builder builder = new Builder()
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    OpenWeatherMapClient client = retrofit.create(OpenWeatherMapClient.class);

    Call<Result> call = client.getWeatherFromOWM(
        SunshinePreferences.getPreferredWeatherLocation(context),
        format,
        units,
        numDays,
        BuildConfig.API_ENDPOINT);

    call.enqueue(new Callback<Result>() {
      @Override
      public void onResponse(Call<Result> call, Response<Result> response) {
        callback.onWeatherLoaded(response.body());
      }

      @Override
      public void onFailure(Call<Result> call, Throwable t) {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override
  public void getWeatherDetails(@NonNull String weatherId,
      @NonNull GetWeatherDetailsCallback callback) {

  }

  @Override
  public void refreshWeather() {

  }
}
