package weather.models;

/**
 * code - внутренний параметр
 * message - внутренний параметр
 * cnt - количество строк, возвращаемых вызовом API
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private float message;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<DataObject> dataObject = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public java.util.List<DataObject> getDataObjectList() {
        return dataObject;
    }

    public void setDataObject(java.util.List<DataObject> dataObject) {
        this.dataObject = dataObject;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
