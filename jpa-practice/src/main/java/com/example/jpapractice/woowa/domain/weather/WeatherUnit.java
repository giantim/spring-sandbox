package com.example.jpapractice.woowa.domain.weather;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WeatherUnit {

    NONE("단위 없음"),
    HIGH_TEMPERATURE("기온", "℃") {
        @Override
        public boolean validateRange(double value) {
            return value >= -100 && value <= 100;
        }
    },
    LOW_TEMPERATURE("기온", "℃") {
        @Override
        public boolean validateRange(double value) {
            return value >= -100 && value <= 100;
        }
    },
    RAINFALL("강수량", "mm"),
    SNOWFALL("적설량", "cm"),
    WIND_SPEED("풍속", "m/s");

    private String desc;
    private String unit;

    WeatherUnit(String desc) {
        this.desc = desc;
    }

    WeatherUnit(String desc, String unit) {
        this.desc = desc;
        this.unit = unit;
    }

    public static WeatherUnit findByDesc(String desc) {
        return Arrays.stream(values())
                .filter(w -> w.desc.equals(desc))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean validateRange(double value) {
        return value >= 0;
    }

}
