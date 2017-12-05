package lv.st.sbogdano.sunshinemvp.weather;

import android.support.annotation.NonNull;
import java.util.List;
import lv.st.sbogdano.sunshinemvp.BasePresenter;
import lv.st.sbogdano.sunshinemvp.BaseView;
import lv.st.sbogdano.sunshinemvp.data.Weather;

/**
 * This specifies contract between View and Presenter.
 */
public interface WeatherContract {

  interface View extends BaseView<Presenter> {

    void setLoadingIndicator(boolean active);

    void showWeather(List<Weather> weatherList);

    void showWeatherDetails(String weatherId);

    void showLoadingWeatherError();

    void showNoWeather();

  }

  interface Presenter extends BasePresenter {

    void loadWeather(boolean forceUpdate);

    void openWeatherDetails(@NonNull Weather requestedWeather);

  }
}
