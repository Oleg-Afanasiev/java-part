package com.academy.lesson08;

public enum Season {
    SPRING( "Весна" ),
    SUMMER( "Лето" ),
    AUTUMN( "Осень" ),
    WINTER( "Зима" );
    private String name;

    Season(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    //Метод получения предыдущего сезона
    public String getPreviousSeason() {
        if (this.name.equals( SPRING.name ))
            return WINTER.name;
        if (this.name.equals( SUMMER.name ))
            return SPRING.name;
        if (this.name.equals( AUTUMN.name ))
            return SUMMER.name;
        if (this.name.equals( WINTER.name ))
            return AUTUMN.name;
        return "Ошибка";
    }

    //Метод получения следующего сезона
    public String geNextSeason() {
        if (this.name.equals( SPRING.name ))
            return SUMMER.name;
        if (this.name.equals( SUMMER.name ))
            return AUTUMN.name;
        if (this.name.equals( AUTUMN.name ))
            return WINTER.name;
        if (this.name.equals( WINTER.name ))
            return SPRING.name;

        return "Ошибка";
    }
}
