package com.example.springjava21.utils;

public final class Unit {
    private Unit() {
    }

    private static final Unit INSTANCE = new Unit();

    public static Unit unit() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "Unit";
    }
}