package com.example.poke.congif;

public class PropConfig {

    private String pokeUrl;

    public PropConfig() {
    }

    public PropConfig(String pokeUrl) {
        this.pokeUrl = pokeUrl;
    }

    public String getPokeUrl() {
        return pokeUrl;
    }

    public void setPokeUrl(String pokeUrl) {
        this.pokeUrl = pokeUrl;
    }

    @Override
    public String toString() {
        return "PropConfig{" +
                "pokeUrl='" + pokeUrl + '\'' +
                '}';
    }
}