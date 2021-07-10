package com.example.jpapractice.woowa.domain;

import com.example.jpapractice.woowa.controller.TestController;
import com.example.jpapractice.woowa.domain.weather.Weather;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"weatherType", "level"})
})
@Entity
public class WeatherExtraFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Weather standardWeather;

    private int level;

    private int extraFee;


    public WeatherExtraFee(TestController.Request request) {
        this.standardWeather = Weather.of(request.getValue(), request.getWeatherType());
        this.level = request.getLevel();
        this.extraFee = 1000;
    }

}
