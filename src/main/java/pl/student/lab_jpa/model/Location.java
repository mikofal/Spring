package pl.student.lab_jpa.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<WeatherData> weatherData;

    public Location() {}

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public Long getId() { return id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public List<WeatherData> getWeatherData() { return weatherData; }
    public void setWeatherData(List<WeatherData> weatherData) { this.weatherData = weatherData; }
}