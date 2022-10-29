package com.routerpasswords.utils;

public class RouterDefaultPasswords {

    private String manufacturer;
    private String modelName;
    private String protocol;
    private String username;
    private String password;

    public RouterDefaultPasswords(String manufacturer,String modelName, String protocol,String username,String password) {
        this.manufacturer=manufacturer;
        this.modelName = modelName;
        this.protocol=protocol;
        this.username = username;
        this.password=password;
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

    public String getManufacturerName() {
        return manufacturer;
    }

    public void setManufacturerName(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
