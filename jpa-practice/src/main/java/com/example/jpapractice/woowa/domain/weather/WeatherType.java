package com.example.jpapractice.woowa.domain.weather;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum WeatherType {

    ALL("전체", WeatherUnit.NONE),
    NORMAL("양호", WeatherUnit.NONE),
    RAINING("우천", WeatherUnit.RAINFALL),
    SNOWING("설천", WeatherUnit.SNOWFALL),
    TOO_HOT("폭염", WeatherUnit.HIGH_TEMPERATURE),
    TOO_COLD("한파", WeatherUnit.LOW_TEMPERATURE),
    STRONG_WIND("강풍", WeatherUnit.WIND_SPEED);

    public static final List<WeatherType> ALL_WEATHER_TYPES = Arrays.stream(values()).collect(Collectors.toList());
    public static final List<WeatherType> WEATHER_TYPES_FILTER = Arrays.asList(RAINING, SNOWING, TOO_HOT, TOO_COLD, STRONG_WIND);

    private String desc;
    private WeatherUnit weatherUnit;

    WeatherType(String desc, WeatherUnit weatherUnit) {
        this.desc = desc;
        this.weatherUnit = weatherUnit;
    }

    public static WeatherType findByDesc(String desc) {
        return Arrays.stream(values())
                .filter(w -> w.desc.equals(desc))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
