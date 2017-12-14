package lv.st.sbogdano.sunshinemvp.data.source.local.entity;

import static lv.st.sbogdano.sunshinemvp.data.source.local.entity.WeatherEntity.TABLE_NAME;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * This is the table that will store data about weather
 */
@Entity(
    tableName = TABLE_NAME,
    indices = {@Index(value = {"date"}, unique = true)})
public class WeatherEntity {

  public static final String TABLE_NAME = "weather";

  @PrimaryKey(autoGenerate = true)
  private int id;

  private int date;

  @ColumnInfo(name = "weather_id")
  private int weatherId;

  @ColumnInfo(name = "min")
  private float minTemp;

  @ColumnInfo(name = "max")
  private float maxTemp;

  private float humidity;
  private float pressure;

  @ColumnInfo(name = "wind_speed")
  private float windSpeed;

  private float degrees;

  public WeatherEntity(int id, @NonNull int date, @NonNull int weatherId, @NonNull float minTemp,
      @NonNull float maxTemp, @NonNull float humidity, @NonNull float pressure,
      @NonNull float windSpeed, @NonNull float degrees) {
    this.id = id;
    this.date = date;
    this.weatherId = weatherId;
    this.minTemp = minTemp;
    this.maxTemp = maxTemp;
    this.humidity = humidity;
    this.pressure = pressure;
    this.windSpeed = windSpeed;
    this.degrees = degrees;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public int getWeatherId() {
    return weatherId;
  }

  public void setWeatherId(int weatherId) {
    this.weatherId = weatherId;
  }

  public float getMinTemp() {
    return minTemp;
  }

  public void setMinTemp(float minTemp) {
    this.minTemp = minTemp;
  }

  public float getMaxTemp() {
    return maxTemp;
  }

  public void setMaxTemp(float maxTemp) {
    this.maxTemp = maxTemp;
  }

  public float getHumidity() {
    return humidity;
  }

  public void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public void setPressure(float pressure) {
    this.pressure = pressure;
  }

  public float getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(float windSpeed) {
    this.windSpeed = windSpeed;
  }

  public float getDegrees() {
    return degrees;
  }

  public void setDegrees(float degrees) {
    this.degrees = degrees;
  }
}
