package github.vatsal.easyweatherdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.pwittchen.weathericonview.WeatherIconView;
import github.vatsal.easyweather.EasyWeatherUtil;
import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.retrofit.api.WeatherMap;
import github.vatsal.easyweather.retrofit.models.CurrentWeatherResponseModel;
import github.vatsal.easyweather.retrofit.models.DailyForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.Weather;
import trikita.log.Log;

public class MainActivity extends AppCompatActivity {

    public final String APP_ID = BuildConfig.OWM_API_KEY;
    public final String lang = "fr";
    String city = "San Francisco";

    @BindView(R.id.weather_title)
    TextView weatherTitle;
    @BindView(R.id.weather_icon)
    ImageView weatherIcon;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.condition)
    TextView condition;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.tvHumidity)
    TextView tvHumidity;
    @BindView(R.id.tvPressure)
    TextView tvPressure;
    @BindView(R.id.tvWind)
    TextView tvWind;
    @BindView(R.id.tvWindDeg)
    TextView tvWindDeg;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.textLayout)
    LinearLayout textLayout;
    @BindView(R.id.humidity_desc)
    TextView humidityDesc;
    @BindView(R.id.pres_desc)
    TextView presDesc;
    @BindView(R.id.ws_desc)
    TextView wsDesc;
    @BindView(R.id.wd_desc)
    TextView wdDesc;
    @BindView(R.id.ll_extraWeather)
    LinearLayout llExtraWeather;
    @BindView(R.id.weatherCard)
    CardView weatherCard;
    @BindView(R.id.weatherIconViewCurrent)
    WeatherIconView weatherIconViewCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadWeather(city);
    }

    @OnClick(R.id.weatherIconViewCurrent)
    public void refresh() {
        loadWeather(city);
    }

    private void loadWeather(String city) {
        WeatherMap weatherMap = new WeatherMap(this, APP_ID, lang);
        weatherMap.getCityWeather(city, new WeatherCallback<CurrentWeatherResponseModel>() {
            @Override
            public void success(CurrentWeatherResponseModel response) {
                Log.i(response.toString());
                populateWeather(response);
                String weatherIcon = response.getWeather()[0].getIcon();
                String weatherId = response.getWeather()[0].getId();
                weatherIconViewCurrent.setIconResource(EasyWeatherUtil.getWeatherIcon(MainActivity.this, weatherId, weatherIcon));
            }

            @Override
            public void failure(String message) {
                Log.i(message);
            }
        });

        weatherMap.getCityForecast(city, new WeatherCallback<ForecastResponseModel>() {
            @Override
            public void success(ForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {
                Log.i(message);
            }
        });

        weatherMap.getCityDailyForecast(city, "3", new WeatherCallback<DailyForecastResponseModel>() {
            @Override
            public void success(DailyForecastResponseModel response) {
                Log.i(response.toString());
            }

            @Override
            public void failure(String message) {
                Log.i(message);
            }
        });
    }

    private void populateWeather(CurrentWeatherResponseModel response) {

        Weather weather[] = response.getWeather();
        condition.setText(weather[0].getMain());
        temp.setText(TempUnitConverter.convertToCelsius(response.getMain().getTemp()).intValue() + " °C");
        location.setText(response.getName());

        tvHumidity.setText(response.getMain().getHumidity() + "%");
        tvPressure.setText(response.getMain().getPressure() + " hPa");
        tvWind.setText(response.getWind().getSpeed() + "m/s");
        tvWindDeg.setText(response.getWind().getDeg() + "°");

        String link = weather[0].getIconLink();
        Picasso.with(this).load(link).into(weatherIcon);
    }

    @OnClick(R.id.tv_go)
    public void go() {
        city = etCity.getText().toString().trim();
        loadWeather(city);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
