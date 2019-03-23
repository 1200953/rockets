package rockets.model;

import jdk.nashorn.internal.codegen.types.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LaunchUnitTest {
    private Launch target;

    @BeforeEach
    public void setUp() {
        target = new Launch();
    }

    @Test
    @DisplayName("Should throw exception when pass a null launch date to setLaunchDate function")
    public void shouldThrowExceptionWhenSetLaunchDateToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLaunchDate(null));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when pass an empty launch date to setLuanchDate function")
    public void shouldThrowExceptionWhenSetLaunchDateToEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setLaunchDate(LocalDate.of(0,0,0)));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should return date format in YYYY-MM-DD")
    public void shouldReturnLocalDateFormat() {
        target.setLaunchDate(LocalDate.of(2019, 03, 23));
        assertEquals("2019-03-23", target.getLaunchDate().toString());
    }

    @Test
    @DisplayName("Should throw exception when pass a null payload to setLaunchDate function")
    public void shouldThrowExceptionWhenSetPayloadToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setPayload(null));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when pass an empty launch date to setPayload function")
    public void shouldThrowExceptionWhenSetPayloadToEmpty() {
        Set<String> set = new HashSet<>();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> target.setPayload(set);
        assertEquals("email cannot be null or empty", exception.getMessage());
    }
}