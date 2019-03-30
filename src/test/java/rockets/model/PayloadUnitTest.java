package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PayloadUnitTest {
    private Payload target;

    @BeforeEach
    public void setUp() {
        target = new Payload();
    }

    //Name
    @DisplayName("should throw exception when pass a null to setName function")
    @Test
    public void shouldThrowExceptionWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setName(null));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setName(name));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return false when two payloads have same name")
    @Test
    public void shouldReturnFalseWhenTwoPayloadsSetSameName() {
        String name = "Star A";
        target.setName(name);
        Payload anotherPayload = new Payload();
        anotherPayload.setName(name);
        assertEquals(target, anotherPayload);
    }

    @DisplayName("should return true when two payloads have different name")
    @Test
    public void shouldReturnTrueWhenTwoPayloadsSetDifferentName() {
        target.setName("Star A");
        Payload anotherPayload = new Payload();
        anotherPayload.setName("Star B");
        assertNotEquals(target, anotherPayload);
    }

    @DisplayName("should return true when pass valid name to setName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Star A", "Dragon B", "faith"})
    public void shouldReturnTrueWhenSetValidName(String name) {
        target.setName(name);
        assertEquals(name, target.getName());
    }

    @DisplayName("should return true when two payload have same name")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameName() {
        String name = "Ares";
        target.setName(name);
        Payload payload_2 = new Payload();
        payload_2.setName(name);
        assertEquals(target, payload_2);
    }

    @DisplayName("should return true when two payload have different name")
    @Test
    public void shouldReturnTrueWhenUsersHaveDiffName() {
        String name = "Ares";
        target.setName(name);
        Payload payload_2 = new Payload();
        payload_2.setName("Altas");
        assertNotEquals(target, payload_2);
    }

    //Category
    @DisplayName("should throw exception when pass a null to setCategory function")
    @Test
    public void shouldThrowExceptionWhenSetCategoryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setCategory(null));
        assertEquals("category cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setCategory function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCategoryToEmpty(String category) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setCategory(category));
        assertEquals("category cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return false when two payloads have same category")
    @Test
    public void shouldReturnFalseWhenTwoPayloadsSetSameCategory() {
        String category = "Star A";
        target.setCategory(category);
        Payload anotherPayload = new Payload();
        anotherPayload.setCategory(category);
        assertEquals(target, anotherPayload);
    }

    @DisplayName("should return true when two payloads have different category")
    @Test
    public void shouldReturnTrueWhenTwoPayloadsSetDifferentCategory() {
        target.setCategory("Star A");
        Payload anotherPayload = new Payload();
        anotherPayload.setCategory("Star B");
    }

    @DisplayName("should return true when pass valid category to setCategory function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Probe", "Spacecraft", "Robot"})
    public void shouldReturnTrueWhenSetValidCategory(String category) {
        target.setCategory(category);
        assertEquals(category, target.getCategory());
    }

    //Country
    @DisplayName("should throw exception when pass a null to setCountry function")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setCountry(null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setCountry function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setCountry(country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a country uncapitalized")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"south korea", "Czech republic", "canada"})
    public void shouldThrowExceptionWhenSetCountryToUncapitalized(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setCountry(country));
        assertEquals("country should be capitalized on each word", exception.getMessage());
    }

    @DisplayName("should return true when pass valid country to setCountry function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"South Korea", "Czech Republic", "Canada"})
    public void shouldReturnTrueWhenSetValidCountry(String country) {
        target.setCountry(country);
        assertEquals(country, target.getCountry());
    }

    //Manufacturer
    @DisplayName("should throw exception when pass a null to setManufacturer function")
    @Test
    public void shouldThrowExceptionWhenSetManufacturerToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setManufacturer(null));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setManufacturer function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetManufacturerToEmpty(String manufacturer) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setManufacturer(manufacturer));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass valid manufacturer to setManufacturer function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Tesla", "NASA", "Virgin"})
    public void shouldReturnTrueWhenSetValidManufacturer(String manufacturer) {
        target.setManufacturer(manufacturer);
        assertEquals(manufacturer, target.getManufacturer());
    }

    //Mass
    @DisplayName("should throw exception when pass a null to setMass function")
    @Test
    public void shouldThrowExceptionWhenSetMassToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setMass(null));
        assertEquals("mass cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setMass function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToEmpty(String mass) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setMass(mass));
        assertEquals("mass cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass valid manufacturer to setMass function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"1000 t", "192 t", "123 t"})
    public void shouldReturnTrueWhenSetValidMass(String mass) {
        target.setMass(mass);
        assertEquals(mass, target.getMass());
    }

    //Function
    @DisplayName("should throw exception when pass a null to setFunction function")
    @Test
    public void shouldThrowExceptionWhenSetFunctionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFunction(null));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty value to setFunction function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFunctionToEmpty(String function) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setFunction(function));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass valid function to setFunction function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Explore", "Experiment", "Test"})
    public void shouldReturnTrueWhenSetValidFunction(String function) {
        target.setFunction(function);
        assertEquals(function, target.getFunction());
    }



}