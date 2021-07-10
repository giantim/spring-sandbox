package com.example.jpapractice.woowa.domain.weather;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Weather {

    private double value;
    @Column
    @Convert(converter = WeatherTypeConverter.class)
    private WeatherType weatherType;

    public Weather(double value, WeatherType weatherType) {
        this.value = value;
        this.weatherType = weatherType;
    }

    public static Weather allWeather() {
        return new Weather(0, WeatherType.ALL);
    }

    public static Weather normalWeather() {
        return new Weather(0, WeatherType.NORMAL);
    }

    public static Weather of(double value, String weatherType) {
        Weather instance = new Weather();
        instance.value = value;
        instance.weatherType = WeatherType.valueOf(weatherType);
        return instance;
    }

    public String getWeatherTypeDesc() {
        return weatherType.getDesc();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Weather weather = (Weather) object;
        return Double.compare(weather.value, value) == 0
                && weatherType.equals(weather.weatherType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weatherType);
    }

}
