package weather.utilities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import weather.models.Forecast;

public interface Apis {

    /**
     * Получение данных прогноза погоды по названию города
     * @GET - запрос
     * @Query - задает имя ключа запроса со значением параметра
     *
     * q - название города
     * APPID - ключ
     * units - еденицы измерения
     */
    @GET("forecast")
    Call<Forecast> getWeatherForecastData(@Query("q") StringBuilder cityName, @Query("APPID")
            String APIKEY, @Query("units") String TempUnit);

}
