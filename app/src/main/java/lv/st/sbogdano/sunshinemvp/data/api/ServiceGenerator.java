package lv.st.sbogdano.sunshinemvp.data.api;

import lv.st.sbogdano.sunshinemvp.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {

  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

  private static Retrofit.Builder builder = new Builder()
      .baseUrl(BuildConfig.API_ENDPOINT)
      .addConverterFactory(GsonConverterFactory.create());

  private static Retrofit retrofit = builder.build();

  private static HttpLoggingInterceptor logging =
      new HttpLoggingInterceptor().setLevel(Level.BODY);

  public static <S> S createService(Class<S> serviceClass) {

    // Firstly, make sure you're not accidentally adding the interceptor multiple times.
    if (!httpClient.interceptors().contains(logging)) {
      httpClient.addInterceptor(logging);
      builder.client(httpClient.build());
      retrofit = builder.build();
    }

    return retrofit.create(serviceClass);
  }

}
