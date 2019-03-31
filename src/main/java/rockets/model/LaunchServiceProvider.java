package rockets.model;

import com.google.common.collect.Sets;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notBlank;

public class LaunchServiceProvider extends Entity {
    private String name;

    private int yearFounded;

    private String country;

    private String headquarters;

    private Set<Rocket> rockets;

    public LaunchServiceProvider(String name, int yearFounded, String country) {
        notBlank(name, "name cannot be null or empty");
        notBlank(country, "country cannot be null or empty");
        this.name = name;
        if (is4Digits(yearFounded)) {
            if (isValidYear(yearFounded)) {
                this.yearFounded = yearFounded;
            }
            else {
                throw new IllegalArgumentException("year can only be set up from 1900 to current year");
            }
        }
        else {
            throw new IllegalArgumentException("year should only be 4 digits");
        }
        if (isCapitalized(country)) {
            this.country = country;

        }
        else {
            throw new IllegalArgumentException("Each word in the name of country should be capitalized");
        }
        rockets = Sets.newLinkedHashSet();
    }

    public boolean setYearFounded(int yearFounded) {
        notBlank(name, "year founded cannot be null or empty");
        if(is4Digits(yearFounded)){
            if(isValidYear(yearFounded))
            {
                this.yearFounded = yearFounded;
                return true;
            }
            else
                throw new IllegalArgumentException("yearFounded should be in the range of 1900 to current year");
        }
        else
            throw new IllegalArgumentException("year should only be 4 digits");
    }

    public boolean setCountry(String country) {
        notBlank(country, "country cannot be null or empty");
        if(isCapitalized(country))
        {
            this.country = country;
            return true;
        }
        else
            throw new IllegalArgumentException("country name should be capitalized");
    }

    public boolean setName(String name){
        notBlank(name, "name cannot be null or empty");
        this.name = name;
        return true;
    }
    public String getName() {
        return name;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public Set<Rocket> getRockets() {
        return rockets;
    }

    public boolean setHeadquarters(String headquarters) {
        notBlank(headquarters, "headquarters cannot be null or empty");
        this.headquarters = headquarters;
        return true;
    }

    public boolean setRockets(Set<Rocket> rockets) {
        this.rockets = rockets;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaunchServiceProvider that = (LaunchServiceProvider) o;
        return yearFounded == that.yearFounded &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, yearFounded, country);
    }

    private boolean isValidYear(int year) {
        return 1900 <= year && year <= LocalDate.now().getYear();
    }

    private boolean is4Digits(int year) {
        return String.valueOf(year).length() == 4;
    }
}
