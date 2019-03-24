package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LaunchUnitTest {
    private Launch target;

    @BeforeEach
    public void setUp() {
        target = new Launch();
    }

    //Launch Date
    @DisplayName("Should throw exception when pass a null launch date to setLaunchDate function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchDateToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchDate(null));
        assertEquals("launch date cannot be null", exception.getMessage());
    }

    @DisplayName("Should throw exception when set a launch date before 1900-01-01")
    @Test
    public void shouldNotBefore19000101() {
        assertEquals("launch date cannot before 1900-01-01",
                target.setLaunchDate(LocalDate.of(1899,12,31)));
    }

    @DisplayName("Should return date format in YYYY-MM-DD")
    @Test
    public void shouldReturnSpecificFormat() {
        target.setLaunchDate(LocalDate.of(2019, 3, 23));
        assertEquals("2019-03-23", target.getLaunchDate().toString());
    }

    //Payload
    @DisplayName("Should throw exception when pass a null payload to setPayload function")
    @Test
    public void shouldThrowExceptionWhenSetPayloadToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPayload(null));
        assertEquals("payload cannot be null", exception.getMessage());
    }

    //TODO - Payload need to be updated instead of pass empty value
//    @DisplayName("Should throw exception when pass an empty payload to setPayload function")
//    @Test
//    public void shouldThrowExceptionWhenSetPayloadToEmpty() {
//        Set<String> set = new HashSet<>();
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setPayload(set));
//        assertEquals("payload cannot be null or empty", exception.getMessage());
//    }

    //Launch Site
    @DisplayName("Should throw exception when pass a null launch site to setLaunchSite function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchSiteToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchSite(null));
        assertEquals("launch site cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty launch site to setLaunchSite function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLaunchSiteToEmpty(String launchSite) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setLaunchSite(launchSite));
        assertEquals("launch site cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return launch site when pass a valid launch site")
    @ParameterizedTest
    @ValueSource(strings = {"A's", "adage", "garb"})
    public void shouldReturnLaunchSiteWhenSetValidLaunchSite(String launchSite) {
        target.setLaunchSite(launchSite);
        assertEquals(launchSite, target.getLaunchSite());
    }

    //Orbit
    @DisplayName("Should throw exception when pass a null orbit to setOrbit function")
    @Test
    public void shouldThrowExceptionWhenSetOrbitToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setOrbit(null));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty orbit to setOrbit function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetOrbitToEmpty(String orbit) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setOrbit(orbit));
        assertEquals("orbit cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return orbit when pass a valid orbit")
    @ParameterizedTest
    @ValueSource(strings = {"A's", "adage", "garb"})
    public void shouldReturnOrbitWhenSetValidOrbit(String orbit) {
        target.setOrbit(orbit);
        assertEquals(orbit, target.getOrbit());
    }

    //Function
    @DisplayName("Should throw exception when pass a null function to setFunction function")
    @Test
    public void shouldThrowExceptionWhenSetFunctionToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFunction(null));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("Should throw exception when pass an empty function to setFunction function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFunctionToEmpty(String function) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setFunction(function));
        assertEquals("function cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return function when pass a valid function")
    @ParameterizedTest
    @ValueSource(strings = {"A's", "adage", "garb"})
    public void shouldReturnFunctionWhenSetValidFunction(String function) {
        target.setFunction(function);
        assertEquals(function, target.getFunction());
    }

    //Price
    @DisplayName("Should throw exception when pass a null price to setPrice function")
    @Test
    public void shouldThrowExceptionWhenSetPriceToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPrice(null));
        assertEquals("price cannot be null", exception.getMessage());
    }

    @DisplayName("Should not be negative price")
    @Test
    public void shouldThrowExceptionWhenSetPriceToNegative() {
        BigDecimal price = new BigDecimal("-1");
        assertEquals("price cannot be negative", target.setPrice(price));
    }

    @DisplayName("should return price when pass a valid price")
    @ParameterizedTest
    @ValueSource(longs = {15325336, 375975982, 459348538})
    public void shouldReturnPriceWhenSetValidPrice(long price) {
        target.setPrice(BigDecimal.valueOf(price));
        assertEquals(BigDecimal.valueOf(price), target.getPrice());
    }

    //Launch Outcome
    @DisplayName("Should throw exception when pass a null launch outcome to setLaunchOutcome function")
    @Test
    public void shouldThrowExceptionWhenSetLaunchOutcomeToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchOutcome(null));
        assertEquals("launch outcome cannot be null", exception.getMessage());
    }

    @DisplayName("Should return set value")
    @ParameterizedTest
    @ValueSource(strings = {"SUCCESSFUL", "FAILED"})
    public void shouldReturnSetValue(String launchOutcome) {
        target.setLaunchOutcome(Launch.LaunchOutcome.valueOf(launchOutcome));
        assertEquals(Launch.LaunchOutcome.valueOf(launchOutcome), target.getLaunchOutcome());
    }

    @DisplayName("should return SUCCESSFUL when pass a SUCCESSFUL launch outcome")
    @Test
    public void shouldReturnSUCCESSFUL() {
        target.setLaunchOutcome(Launch.LaunchOutcome.SUCCESSFUL);
        assertEquals(Launch.LaunchOutcome.SUCCESSFUL, target.getLaunchOutcome());
    }

    @DisplayName("should return FAILED when pass a FAILED launch outcome")
    @Test
    public void shouldReturnFAILED() {
        target.setLaunchOutcome(Launch.LaunchOutcome.FAILED);
        assertEquals(Launch.LaunchOutcome.FAILED, target.getLaunchOutcome());
    }

    //TODO - Cannot figure it out
//    @DisplayName("Should throw exception when pass a value not SUCCESSFUL or FAILED")
//    @ParameterizedTest
//    @ValueSource(strings = {"INVALID"})
//    public void shouldThrowExceptionWhenSetLaunchOutcomeToInvalidValue(String launchOutcome) {
//        Exception exception = assertThrows(Exception.class, ()
//                -> target.setLaunchOutcome(Launch.LaunchOutcome.valueOf(launchOutcome)));
//        assertEquals("launch outcome cannot be set in invalid value", exception.getMessage());
//    }
}