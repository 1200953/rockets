package rockets.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class Rocket extends Entity {
    private String name;

    private String family;

    private String country;

    private String manufacturer;

    private String massToLEO;

    private String massToGTO;

    private String massToOther;

    /**
     * All parameters shouldn't be null.
     *
     * @param name
     * @param family
     * @param country
     * @param manufacturer
     */
    public Rocket(String name,String family, String country, String manufacturer) {
        notBlank(name, "name cannot be null or empty");
        notBlank(family, "family cannot be null or empty");
        notBlank(country, "country cannot be null or empty");
        notBlank(manufacturer, "manufacturer cannot be null or empty");
        if(isCountry(family))
            this.family = family;
        else
            throw new IllegalArgumentException("the first char in the name of rocket family should be upper case");

        if (containsFamily(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("name should contains family");
        }
        if (isCountry(country)) {
            this.country = country;
        }
        else {
            throw new IllegalArgumentException("country should be capitalized on each word");
        }
        this.manufacturer = manufacturer;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMassToLEO() {
        return massToLEO;
    }

    public String getMassToGTO() {
        return massToGTO;
    }

    public String getMassToOther() {
        return massToOther;
    }

    public void setMassToLEO(String massToLEO) {
        if (massToLEO == null)
            this.massToLEO = null;
        else if (massToLEO.trim().isEmpty())
            throw new IllegalArgumentException("massToLEO cannot be empty");
        else
            this.massToLEO = massToLEO;
    }

    public void setMassToGTO(String massToGTO) {
        if (massToGTO == null)
            this.massToGTO = null;
        else if (massToGTO.trim().isEmpty())
            throw new IllegalArgumentException("massToGTO cannot be empty");
        else
            this.massToGTO = massToGTO;
    }

    public void setMassToOther(String massToOther) {
        if (massToOther == null)
            this.massToOther = null;
        else if (massToOther.trim().isEmpty())
            throw new IllegalArgumentException("massToOther cannot be empty");
        else
            this.massToOther = massToOther;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rocket rocket = (Rocket) o;
        return Objects.equals(name, rocket.name) &&
                Objects.equals(country, rocket.country) &&
                Objects.equals(manufacturer, rocket.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, manufacturer);
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", massToLEO='" + massToLEO + '\'' +
                ", massToGTO='" + massToGTO + '\'' +
                ", massToOther='" + massToOther + '\'' +
                '}';
    }


    private boolean containsFamily (String name) {
        return name.contains(family);
    }
}
