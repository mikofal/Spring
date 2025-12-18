package pl.student.lab_jpa.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Double temperature;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = true)
    private Location location;

    public WeatherData() {}

    public WeatherData(Date date, Double temperature, Location location) {
        this.date = date;
        this.temperature = temperature;
        this.location = location;
    }

    public Long getId() { return id; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}