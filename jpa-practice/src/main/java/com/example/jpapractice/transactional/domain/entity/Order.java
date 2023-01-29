package com.example.jpapractice.transactional.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Getter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "json")
    @Convert(converter = MenuGroupConverter.class)
    private MenuGroup menuGroup;

    @Getter
    public static class MenuGroup {

        private Set<String> menus;
    }

    protected Order() {
    }
}
