package hr.dreamfactory.playground.issueanalyzer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import hr.dreamfactory.playground.issueanalyzer.model.github.SearchAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FeignBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignBuilder.class);

    public static final String GITHUB_API = "https://api.github.com";

    private final OkHttpClient okHttpClient;
    private static final HttpLoggingInterceptor loggingInterceptor;

    static {
        loggingInterceptor =  new HttpLoggingInterceptor((msg) -> LOGGER.info(msg));
        loggingInterceptor.setLevel(Level.BASIC);
    }

    public FeignBuilder() {
        this.okHttpClient = buildNoAuthClient();
    }

    public SearchAPI buildSearchAPI(){
        return createFeignBuilder()
                .target(SearchAPI.class, GITHUB_API);
    }

    private Feign.Builder createFeignBuilder() {
        Gson gson = createSnakeCaseGson();

        return Feign.builder()
                .client(new feign.okhttp.OkHttpClient(okHttpClient))
                .encoder(new GsonEncoder(gson))
                .decoder(new GsonDecoder(gson));
    }

    private OkHttpClient buildNoAuthClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    private Gson createSnakeCaseGson() {
        return new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
    }
}
