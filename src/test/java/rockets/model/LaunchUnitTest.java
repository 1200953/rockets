package rockets.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LaunchUnitTest {
    private Launch target;

    @BeforeEach
    public void setUp() {
        target = new Launch();
    }

    //id
    @DisplayName("should throw exception when pass a null value to setId function")
    @Test
    public void shouldThrowExceptionWhenSetIdToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setId(null));
        assertEquals("id cannot be null", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid id to setId function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(longs = {0, 123, 1234567})
    public void shouldPassWhenSetValidId(long id) {
        assertTrue(target.setId(id));
    }

    //Launch Date
    @DisplayName("should return true when pass a valid launch date to setLaunchDate function")
    @ParameterizedTest(name = "Test case #{index}: {0}-{1}-{2}")
    @CsvSource({"1900,01,01","1950,02,02","2018,03,03"})
    public void shouldPassWhenSetValidDate(int year, int mon, int day) {
        assertTrue(target.setLaunchDate(LocalDate.of(year, mon, day)));
    }

    @DisplayName("should throw exception when pass a null launch date to setLaunchDate function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchDateToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchDate(null));
        assertEquals("launch date cannot be null", exception.getMessage());
    }

    @DisplayName("should throw exception when set a launch date before 1900-01-01")
    @ParameterizedTest(name = "Test case #{index}: {0}-{1}-{2}")
    @CsvSource({"1899,12,31","1000,12,31","200,12,31"})
    public void shouldNotBefore19000101(int year, int month, int day) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setLaunchDate(LocalDate.of(year, month, day)));
        assertEquals("launch date should pass 1900-01-01", exception.getMessage());
    }

    @DisplayName("should return true when pass the date in correct format yyyy-MM-dd")
    @Test
    public void shouldReturnSpecificDateFormat() {
        target.setLaunchDate(LocalDate.of(2019, 3, 23));
        assertEquals("2019-03-23", target.getLaunchDate().toString());
    }

    //Launch Site
    @DisplayName("should return true when pass a valid launch site to setLaunchSite function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Vandenberg Air Force Base", "Mid-Atlantic Regional Spaceport ", "Kennedy Space Center"})
    public void shouldPassWhenSetValidMassToOther(String site) {
        assertTrue(target.setLaunchSite(site));
    }

    @DisplayName("should throw exception when pass a null launch site to setLaunchSite function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchSiteToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchSite(null));
        assertEquals("launch site cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty launch site to setLaunchSite function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLaunchSiteToEmpty(String launchSite) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setLaunchSite(launchSite));
        assertEquals("launch site cannot be null or empty", exception.getMessage());
    }

    //Orbit
    @DisplayName("should throw exception when pass a null orbit to setOrbit function")
    @Test
    public void shouldThrowExceptionWhenSetOrbitToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setOrbit(null));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty orbit to setOrbit function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetOrbitToEmpty(String orbit) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setOrbit(orbit));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid orbit to setOrbit function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"LEO", "MEO", "HEO"})
    public void shouldReturnOrbitWhenSetValidOrbit(String orbit) {
        assertTrue(target.setOrbit(orbit));
    }

    //Function
    @DisplayName("should throw exception when pass a null function to setFunction function")
    @Test
    public void shouldThrowExceptionWhenSetFunctionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFunction(null));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass an empty string to setFunction function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFunctionToEmpty(String function) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setFunction(function));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid string to setFunction function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"weaponry", "ejection seats", "human spaceflight"})
    public void shouldReturnFunctionWhenSetValidFunction(String function) {
        assertTrue(target.setFunction(function));
    }

    //Price
    @DisplayName("should throw exception when pass a null price to setPrice function")
    @Test
    public void shouldThrowExceptionWhenSetPriceToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPrice(null));
        assertEquals("price cannot be null", exception.getMessage());
    }

    @DisplayName("should return true if the price is set to be negative or 0")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"-1000","-1","0"})
    public void shouldReturnTrueWhenSetPriceToNegative(String price_t) {
        BigDecimal price = new BigDecimal(price_t);
        assertEquals("price cannot be negative or 0", target.setPrice(price));
    }

    @DisplayName("should return true when pass a valid price to setPrice function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"1", "8888888", "8888888888888888"})
    public void shouldReturnPriceWhenSetValidPrice(String price) {
        target.setPrice(new BigDecimal(price));
        assertEquals(new BigDecimal(price), target.getPrice());
    }

    //Launch Outcome
    @DisplayName("should throw exception when pass a null launch outcome to setLaunchOutcome function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchOutcomeToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> target.setLaunchOutcome(null));
        assertEquals("launch outcome cannot be null", exception.getMessage());
    }

    @DisplayName("should return true when Enum Types are correct")
    @ParameterizedTest(name = "Enum type: {0}")
    @EnumSource(value = Launch.LaunchOutcome.class,
            names = {"SUCCESSFUL", "FAILED"})
    public void shouldReturnTrueIfEnumTypesAreCorrect(Launch.LaunchOutcome launch) {
        assertNotNull(launch);
    }
}