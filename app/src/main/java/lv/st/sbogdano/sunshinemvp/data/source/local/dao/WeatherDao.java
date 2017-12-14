package lv.st.sbogdano.sunshinemvp.data.source.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;
import lv.st.sbogdano.sunshinemvp.data.source.local.entity.WeatherEntity;

@Dao
public interface WeatherDao {

  @Query("SELECT * FROM " + WeatherEntity.TABLE_NAME)
  LiveData<List<WeatherEntity>> getWeatherFromDb();

  @Query("SELECT * FROM " + WeatherEntity.TABLE_NAME + " WHERE date = :todayDate")
  LiveData<WeatherEntity> getWeatherForToday(int todayDate);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  public void bulkInsertWeather(WeatherEntity... weatherEntities);

}
