package weather.utilities;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Клиентский класс создает модифицированный экземпляр клиента и доступен для
 * отправки сетевых запросов к API
 * (Retrofit - осуществление запроса к api
 */
public class Client {
    private static Retrofit client = null;

    public static Retrofit getClient() {
        if (client == null) {
            client = new Retrofit.Builder() //  задание определения конейной точки url
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return client;
    }
}