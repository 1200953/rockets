package rockets.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class Payload extends Entity {
    private String name;
    private String category;
    private String country;
    private String manufacturer;
    private String function;
    private String mass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        notBlank(name, "name cannot be null or empty");
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        notBlank(category, "category cannot be null or empty");
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        notBlank(country, "country cannot be null or empty");
        if (isCountry(country))
            this.country = country;
        else
            throw new IllegalArgumentException("country should be capitalized on each word");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        notBlank(manufacturer, "manufacturer cannot be null or empty");
        this.manufacturer = manufacturer;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        notBlank(function, "function cannot be null or empty");
        this.function = function;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        notBlank(mass, "mass cannot be null or empty");
        this.mass = mass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Payload that = (Payload) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, manufacturer);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", function='" + function + '\'' +
                ", mass='" + mass + '\'' +
                ", country='" + country + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
