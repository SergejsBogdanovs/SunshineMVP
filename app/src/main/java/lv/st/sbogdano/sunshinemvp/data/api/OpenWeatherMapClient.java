package lv.st.sbogdano.sunshinemvp.data.api;

import lv.st.sbogdano.sunshinemvp.data.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapClient {

  @GET()
  Call<Result> getWeatherFromOWM(
      @Query("q") String city,
      @Query("mode") String mode,
      @Query("units") String units,
      @Query("cnt") String dayCount,
      @Query("appid") String appId
  );

}
