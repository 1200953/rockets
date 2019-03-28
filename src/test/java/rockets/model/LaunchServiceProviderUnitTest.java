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
    private void setUp() {
        target = new LaunchServiceProvider("abc", 2019, "US");
    }

    //name
    @DisplayName("should throw exception when initialize name to null")
    @Test
    public void shouldThrowWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider(null, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize country to an empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider(name, 2019, "US"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    //yearFounded
    @DisplayName("should throw exception when initialize yearFounded outside of 1900 to current year")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(ints = {1000, 1899, 2020})
    public void shouldThrowWhenSetYearFoundedToNull(int yearFounded) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", yearFounded, "US"));
        assertEquals("year can only be set up from 1900 to current year", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize yearFounded other than 4 digits")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(ints = {1, 999, 10000})
    public void shouldThrowWhenSetYearFoundedNotIn4Digits(int yearFounded) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", yearFounded, "US"));
        assertEquals("year should only be 4 digits", exception.getMessage());
    }

    @DisplayName("should return true when pass valid to initialize yearFounded")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(ints = {1900, 1901, 1950, 2018, 2019})
    public void shouldReturnTrueWhenSetYearFoundedToValidValue(int yearFounded) {
        target.setYearFounded(yearFounded);
        assertEquals(yearFounded, target.getYearFounded());
    }

    //country
    @DisplayName("should throw exception when initialize country name to null")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new LaunchServiceProvider("abc", 2019, null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize country name to an empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new LaunchServiceProvider("abc", 2019, country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize country with uncapitalized words")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
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
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetHeadquartersToEmpty(String headquarters) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setHeadquarters(headquarters));
        assertEquals("headquarters cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid name to setHeadquarters function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Goddard Space Flight Center", "Kennedy Space Center", "Vandenberg Air Force Base"})
    public void shouldReturnHeadquartersWhenSetValidHeadquarters(String headquarters) {
        assertTrue(target.setHeadquarters(headquarters));
    }

    @DisplayName("should return true when pass a valid name to setName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Antrix Corporation", "Arianespace", "China Aerospace Science and Technology Corporation"})
    public void shouldReturnTrueIfValidName(String name) {
        assertTrue(target.setName(name));
    }

    @DisplayName("should return true when pass a valid country to setCountry function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"China", "Canada", "United States"})
    public void shouldReturnHeadquartersWhenSetValidCountry(String country) {
        assertTrue(target.setCountry(country));
    }
}