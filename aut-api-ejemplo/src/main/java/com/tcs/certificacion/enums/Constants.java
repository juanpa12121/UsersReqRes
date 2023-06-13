package com.tcs.certificacion.enums;

public enum Constants {
    VALIDATE_MSJ("Valid name"),
    ACTOR_NAME("Administrador"),
    NAME("name"),
    JOB("job");

    private final String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
