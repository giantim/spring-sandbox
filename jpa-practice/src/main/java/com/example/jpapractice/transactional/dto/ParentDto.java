package com.example.jpapractice.transactional.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ParentDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate endDate;

    public boolean isSameMonth() {
        return getStartDateMonth().equals(getEndDateMonth());
    }

    public String getStartDateYear() {
        return Integer.toString(startDate.getYear());
    }

    public String getStartDateMonth() {
        String month = Integer.toString(startDate.getMonthValue());
        return appendZero(month);
    }

    public String getStartDateDay() {
        String day = Integer.toString(startDate.getDayOfMonth());
        return appendZero(day);
    }

    public String getEndDateYear() {
        return Integer.toString(endDate.getYear());
    }

    public String getEndDateMonth() {
        String month = Integer.toString(endDate.getMonthValue());
        return appendZero(month);
    }

    public String getEndDateDay() {
        String day = Integer.toString(endDate.getDayOfMonth());
        return appendZero(day);
    }

    private String appendZero(String number) {
        if (number.length() == 1) {
            return "0" + number;
        }
        return number;
    }

}
