package com.example.jpapractice.woowa.domain.weather;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class WeatherConverter implements AttributeConverter<Weather, String> {

    private static final String DELIMITER = ":";

    @Override
    public String convertToDatabaseColumn(Weather attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return String.format("%s%s%f%s%s%s%s",
                attribute.getWeatherType().getDesc(), DELIMITER,
                attribute.getValue(), DELIMITER,
                attribute.getWeatherType().getWeatherUnit().getDesc(), DELIMITER,
                attribute.getWeatherType().getWeatherUnit().getUnit());
    }

    @Override
    public Weather convertToEntityAttribute(String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        String[] split = dbData.split(DELIMITER);
        return new Weather(Double.parseDouble(split[1]), WeatherType.findByDesc(split[0]));
    }

}
