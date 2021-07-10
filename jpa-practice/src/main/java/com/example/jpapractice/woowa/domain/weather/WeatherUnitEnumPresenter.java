package com.example.jpapractice.woowa.domain.weather;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@EqualsAndHashCode(of = {"code"})
public class WeatherUnitEnumPresenter implements Serializable {
    private String code;
    private String desc;
    private String unit;

    public static WeatherUnitEnumPresenter of(WeatherUnit weatherUnit) {
        WeatherUnitEnumPresenter instance = new WeatherUnitEnumPresenter();
        instance.code = weatherUnit.name();
        instance.desc = weatherUnit.getDesc();
        instance.unit = weatherUnit.getUnit();
        return instance;
    }

}
