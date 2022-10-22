package com.routerpasswords.utils;

public class RouterDefaultPasswords {

    private String modelName;
    private String username;

    public RouterDefaultPasswords(String modelName, String username) {
        this.modelName = modelName;
        this.username = username;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
