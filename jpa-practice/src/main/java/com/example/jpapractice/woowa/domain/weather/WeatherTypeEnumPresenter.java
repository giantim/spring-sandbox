package com.example.jpapractice.woowa.domain.weather;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode(of = {"code"})
public class WeatherTypeEnumPresenter implements Serializable {
    private String code;
    private String desc;
    private WeatherUnitEnumPresenter weatherUnit;

    public static WeatherTypeEnumPresenter of(WeatherType weatherType) {
        WeatherTypeEnumPresenter instance = new WeatherTypeEnumPresenter();
        instance.code = weatherType.name();
        instance.desc = weatherType.getDesc();
        instance.weatherUnit = WeatherUnitEnumPresenter.of(weatherType.getWeatherUnit());
        return instance;
    }

}
