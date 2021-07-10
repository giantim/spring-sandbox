package com.example.jpapractice.woowa.domain.weather;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class WeatherTypeConverter implements AttributeConverter<WeatherType, String> {

    @Override
    public String convertToDatabaseColumn(WeatherType attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return String.format(attribute.getDesc() + ":" + attribute.getWeatherUnit().getDesc());
    }

    @Override
    public WeatherType convertToEntityAttribute(String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        String[] split = dbData.split(":");
        return WeatherType.findByDesc(split[0]);
    }

}
