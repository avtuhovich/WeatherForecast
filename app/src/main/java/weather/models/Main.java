package weather.models;

/**
 * temp - температура
 * tempMin - минимальная температура
 * tempMax - максимальная температура
 * pressure - атмосферное давление на уровне моря по усолчанию
 * seaLevel - атмосферное давление на уронне моря
 * grndLevel - атмосферное давление на уровне земли
 * humidity - влажность
 * tempKf - внутренний параметр
 */

public class Main {

    private float temp;
    private float tempMin;
    private float tempMax;
    private float pressure;
    private float seaLevel;
    private float grndLevel;
    private int humidity;
    private float tempKf;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(float seaLevel) {
        this.seaLevel = seaLevel;
    }

    public float getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(float grndLevel) {
        this.grndLevel = grndLevel;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTempKf() {
        return tempKf;
    }

    public void setTempKf(float tempKf) {
        this.tempKf = tempKf;
    }

}
