package github.vatsal.easyweather.retrofit.models;

import java.util.Arrays;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --17/06/16 at
 * --3:16 PM in
 * --PopularMoviesApp
 */
public class CurrentWeatherResponseModel {

    private String id;

    private String dt;

    private Clouds clouds;

    private Coord coord;

    private Wind wind;

    private String cod;

    private Sys sys;

    private String name;

    private String base;

    private Weather[] weather;

    private Rain rain;

    private Snow snow;

    private Main main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "CurrentWeatherResponseModel{" +
                "id='" + id + '\'' +
                ", dt='" + dt + '\'' +
                ", clouds=" + clouds +
                ", coord=" + coord +
                ", wind=" + wind +
                ", cod='" + cod + '\'' +
                ", sys=" + sys +
                ", name='" + name + '\'' +
                ", base='" + base + '\'' +
                ", weather=" + Arrays.toString(weather) +
                ", rain=" + rain +
                ", snow=" + snow +
                ", main=" + main +
                '}';
    }
}
