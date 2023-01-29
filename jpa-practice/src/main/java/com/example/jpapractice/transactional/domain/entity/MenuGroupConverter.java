package com.example.jpapractice.transactional.domain.entity;

import javax.persistence.AttributeConverter;

public class MenuGroupConverter implements AttributeConverter<Order.MenuGroup, String> {

    @Override
    public String convertToDatabaseColumn(Order.MenuGroup attribute) {
        return null;
    }

    @Override
    public Order.MenuGroup convertToEntityAttribute(String dbData) {
        return null;
    }
}
