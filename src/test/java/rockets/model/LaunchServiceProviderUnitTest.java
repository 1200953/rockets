package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class LaunchServiceProviderUnitTest {
    private LaunchServiceProvider target;

    @BeforeEach
    void setUp() {
        target = new LaunchServiceProvider("abc", 2019, "US");
    }

    //name
    @DisplayName("should throw exception when no parameters is passed to name")
    @Test
    public void shouldThrowWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider(null, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when set name to an empty string")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider(name, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    //yearFounded
    @DisplayName("should throw exception when the year entered is outside of 1900 to current year")
    @ParameterizedTest
    @ValueSource(ints = {1, 1899, 2020})
    public void shouldThrowWhenSetYearFoundedToNull(int yearFounded) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", yearFounded, "US"));
        assertEquals("the year can only be set up from 1900 to current year", exception.getMessage());
    }

    //country
    @DisplayName("should throw exception when no parameter is passed to country")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider("abc", 2019, null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when set country name to an empty string")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", 2019, country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an string with uncapitalized words to")
    @ParameterizedTest
    @ValueSource(strings = {"south korea", "Czech republic", "canada"})
    public void shouldThrowExceptionWhenSetCountryToUncapitalized(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", 2019, country));
        assertEquals("Each word in the name of country should be capitalized", exception.getMessage());
    }

    //headquarters
    @DisplayName("should throw exception when pass a null value to setHeadquarters function")
    @Test
    public void shouldThrowExceptionWhenSetHeadquartersToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> target.setHeadquarters(null));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty string to setHeadquarters function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetHeadquartersToEmpty(String headquarters) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setHeadquarters(headquarters));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return headquarters when pass a valid name to setHeadquarters function")
    @ParameterizedTest
    @ValueSource(strings = {"A's", "adage", "garb"})
    public void shouldReturnHeadquartersWhenSetValidHeadquarters(String headquarters) {
        target.setHeadquarters(headquarters);
        assertEquals(headquarters, target.getHeadquarters());
    }
}