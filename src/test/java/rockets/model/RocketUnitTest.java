package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RocketUnitTest {
    private Rocket target;

    @BeforeEach
    void setUp() {
        target = new Rocket("abc","US", "Tesla");
    }

    //Name
    @DisplayName("Should throw exception when pass a null name to create rocket object")
    @Test
    public void shouldThrowWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new Rocket(null, "US", "Tesla"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty name to create rocket object")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Rocket(name, "US", "Tesla"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    //Country
    @DisplayName("Should throw exception when pass a null country to create rocket object")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new Rocket("abc", null, "Tesla"));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty country to create rocket object")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Rocket("abc", country, "Tesla"));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when initialize country with uncapitalized words")
    @ParameterizedTest
    @ValueSource(strings = {"the unit state", "the people Republic of china", "british"})
    public void shouldThrowExceptionWhenSetCountryToUncapitalized(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Rocket("abc", country,
                "Tesla"));
        assertEquals("Country should be capitalized on each word", exception.getMessage());
    }

    //manufacturer
    @DisplayName("Should throw exception when initialize manufacturer into null")
    @Test
    public void shouldThrowExceptionWhenSetManufacturerToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> new Rocket("abc", "US", null));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when when initialize manufacturer into empty string")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetManufacturerToEmpty(String manufacturer) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> new Rocket("abc", "US", manufacturer));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    //massToLEO
    @DisplayName("Should throw exception when pass a null to setMassToLEO function")
    @Test
    public void shouldThrowExceptionWhenSetMassToLEOToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> target.setMassToLEO(null));
        assertEquals("mass to LEO cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty string to setMassToLEO function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToLEOToEmpty(String massToLEO) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToLEO(massToLEO));
        assertEquals("mass to LEO cannot be null or empty", exception.getMessage());
    }

    //massToGTO
    @DisplayName("Should throw exception when pass a null to setMassToGTO function")
    @Test
    public void shouldThrowExceptionWhenSetMassToGTOToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> target.setMassToGTO(null));
        assertEquals("mass to GTO cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty string to setMassToGTO function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToGTOToEmpty(String massToGTO) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToGTO(massToGTO));
        assertEquals("mass to GTO cannot be null or empty", exception.getMessage());
    }

    //massToOther
    @DisplayName("Should throw exception when pass a null to setMassToOther function")
    @Test
    public void shouldThrowExceptionWhenSetMassToOtherToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, ()
                -> target.setMassToOther(null));
        assertEquals("mass to Other cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty string to setMassToOther function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToOtherToEmpty(String massToOther) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToOther(massToOther));
        assertEquals("mass to Other cannot be null or empty", exception.getMessage());
    }
}