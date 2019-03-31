package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RocketUnitTest {
    private Rocket target;

    @BeforeEach
    public void setUp() {
        target = new Rocket("Dragon A", "Dragon", "US", "Tesla");
    }

    //Name
    @DisplayName("should throw exception when initialize name into null")
    @Test
    public void shouldThrowWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> new Rocket(null, "Dragon","US", "Tesla"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize name into an empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket(name, "Dragon", "US", "Tesla"));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize name which does not contain family name")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Falcom", "falcon", "Ares XIII"})
    public void shouldThrowExceptionWhenSetNameNotContainsFamily(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket(name, "Falcon", "US", "Tesla"));
        assertEquals("name should contain family", exception.getMessage());
    }

    @DisplayName("should return true when initialize name with a valid name")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Falcon 5", "Falcon Heavy"})
    public void shouldPassWhenSetValidName(String name) {
        target = new Rocket(name,"Falcon", "US", "Tesla");
        assertEquals(name, target.getName());
    }

    //Family
    @DisplayName("should throw exception when initialize family into null")
    @Test
    public void shouldThrowWhenSetFamilyToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> new Rocket("Dragon A", null,"US", "Tesla"));
        assertEquals("family cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize family with uncapitalized word")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"falcon"})
    public void shouldThrowExceptionWhenSetFamilyUC(String family) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket("falcon 5", family, "US", "Tesla"));
        assertEquals("the first char in the name of rocket family should be upper case", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize family into an empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFamilyToEmpty(String family) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket("Dragon A", family, "US", "Tesla"));
        assertEquals("family cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when initialize family with a valid family name")
    @Test
    public void shouldPassWhenSetValidFamily() {
        String family = "Falcon";
        target = new Rocket("Falcon 9",family, "US", "Tesla");
        assertEquals(family, target.getFamily());
    }

    //Country
    @DisplayName("should throw exception when initialize country into null")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> new Rocket("Dragon A", "Dragon", null, "Tesla"));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize country into an empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket("Dragon A", "Dragon", country, "Tesla"));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when initialize country with uncapitalized words")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"south korea", "Czech republic"})
    public void shouldThrowExceptionWhenSetCountryToUncapitalized(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket("Dragon A", "Dragon", country, "Tesla"));
        assertEquals("country should be capitalized on each word", exception.getMessage());
    }

    @DisplayName("should return true when initialize country with a valid country name")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"South Korea", "Canada"})
    public void shouldPassWhenSetValidCountry(String country) {
        target = new Rocket("Dragon A", "Dragon", country, "Tesla");
        assertEquals(country, target.getCountry());
    }

    //manufacturer
    @DisplayName("should throw exception when initialize manufacturer into null")
    @Test
    public void shouldThrowExceptionWhenSetManufacturerToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> new Rocket("Dragon A", "Dragon", "US", null));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when when initialize manufacturer into empty string")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetManufacturerToEmpty(String manufacturer) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Rocket("Dragon A", "Dragon", "US", manufacturer));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when initialize manufacturer with a valid manufacturer name")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Sierra Nevada Corporation"})
    public void shouldPassWhenSetValidManufacturer(String manufacturer) {
        target = new Rocket("Dragon A", "Dragon", "US", manufacturer);
        assertEquals(manufacturer, target.getManufacturer());
    }

    //massToLEO
    @DisplayName("should throw exception when pass an empty string to setMassToLEO function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToLEOToEmpty(String massToLEO) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToLEO(massToLEO));
        assertEquals("massToLEO cannot be empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid massToLEO to setMassToLEO function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"8.0 t", "310,000 lb"})
    public void shouldPassWhenSetValidMassToLEO(String massToLEO) {
        target.setMassToLEO(massToLEO);
        assertEquals(massToLEO, target.getMassToLEO());
    }

    //massToGTO
    @DisplayName("should throw exception when pass an empty string to setMassToGTO function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToGTOToEmpty(String massToGTO) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToGTO(massToGTO));
        assertEquals("massToGTO cannot be empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid massToGTO to setMassToGTO function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"8.0 t", "310,000 lb"})
    public void shouldPassWhenSetValidMassToGTO(String massToGTO) {
        target.setMassToGTO(massToGTO);
        assertEquals(massToGTO, target.getMassToGTO());
    }

    //massToOther
    @DisplayName("should throw exception when pass an empty string to setMassToOther function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToOtherToEmpty(String massToOther) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setMassToOther(massToOther));
        assertEquals("massToOther cannot be empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid massToOther to setMassToOther function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"13,550 to SSO"})
    public void shouldPassWhenSetValidMassToOther(String massToOther) {
        target.setMassToOther(massToOther);
        assertEquals(massToOther, target.getMassToOther());
    }
}