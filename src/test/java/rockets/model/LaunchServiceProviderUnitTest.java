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
    @DisplayName("should throw exception when pass a null name to create LaunchServiceProvider object")
    @Test
    public void shouldThrowWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider(null, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty name to create LaunchServiceProvider object")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider(name, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    //yearFounded
    @DisplayName("should throw exception when pass a year founded not between 1900 to present year to create " +
            "LaunchServiceProvider object")
    @ParameterizedTest
    @ValueSource(ints = {1, 1899, 2020})
    public void shouldThrowWhenSetYearFoundedToNull(int yearFounded) {
        RuntimeException exception = assertThrows(RuntimeException.class, ()
                -> new LaunchServiceProvider("abc", yearFounded, "US"));
        assertEquals("year founded should invalid (between 1900 to present year)", exception.getMessage());
    }

    //country
    @DisplayName("should throw exception when pass a null country to create LaunchServiceProvider object")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider("abc", 2019, null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty country to create LaunchServiceProvider object")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", 2019, country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an uncapitalized country to create LaunchServiceProvider object")
    @ParameterizedTest
    @ValueSource(strings = {"the unit state", "the people Republic of china", "british"})
    public void shouldThrowExceptionWhenSetCountryToUncapitalized(String country) {
        RuntimeException exception = assertThrows(RuntimeException.class, ()
                -> new LaunchServiceProvider("abc", 2019, country));
        assertEquals("Country should be capitalized on each word", exception.getMessage());
    }

    //headquarters
    @DisplayName("should throw exception when pass a null value to setHeadquarters")
    @Test
    public void shouldThrowExceptionWhenSetHeadquartersToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> target.setHeadquarters(null));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty value to setHeadquarters")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetHeadquartersToEmpty(String headquarters) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setHeadquarters(headquarters));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return headquarters when pass a valid headquarters")
    @ParameterizedTest
    @ValueSource(strings = {"A's", "adage", "garb"})
    public void shouldReturnHeadquartersWhenSetValidHeadquarters(String headquarters) {
        target.setHeadquarters(headquarters);
        assertEquals(headquarters, target.getHeadquarters());
    }
}