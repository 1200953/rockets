package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTest {
    private User target;

    @BeforeEach
    public void setUp() {
        target = new User();
    }

    //email
    @DisplayName("should throw exception when pass a empty email address to setEmail function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetEmailToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setEmail(email));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setEmail function")
    @Test
    public void shouldThrowExceptionWhenSetEmailToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setEmail(null));
        assertEquals("email cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid email to isValidEmail function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"asjdoanf@gmail.com", "asdad@student.monash.edu"})
    public void shouldReturnTrueWhenPassAValidEmail(String email) {
        assertTrue(target.isValidEmail(email));
    }

    @DisplayName("should return false when pass an invalid email to isValidEmail function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"emailAddress", "emailAddress@.com.au", "email@address@gmail.com"})
    public void shouldReturnFalseWhenPassAnInvalidEmail(String email) {
        assertFalse(target.isValidEmail(email));
    }

    @DisplayName("should return true when two users have the same email")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameEmail() {
        String email = "abc@example.com";
        target.setEmail(email);
        User anotherUser = new User();
        anotherUser.setEmail(email);
        assertEquals(target, anotherUser);
    }

    @DisplayName("should return false when two users have different emails")
    @Test
    public void shouldReturnFalseWhenUsersHaveDifferentEmails() {
        target.setEmail("abc@example.com");
        User anotherUser = new User();
        anotherUser.setEmail("def@example.com");
        assertNotEquals(target, anotherUser);
    }

    @DisplayName("should return true when pass a valid email to setEmail function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"asjdoanf@gmail.com", "asdad@student.monash.edu"})
    public void shouldReturnEmailWhenSetValid(String email) {
        target.setEmail(email);
        assertEquals(email, target.getEmail());
    }

    //password
    @DisplayName("should throw exceptions when pass a null password to setPassword function")
    @Test
    public void shouldThrowExceptionWhenSetPasswordToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> target.setPassword(null));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty password to setPassword function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetPasswordToEmpty(String email) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setPassword(email));
        assertEquals("password cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid password")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"asdASD123!@#"})
    public void shouldReturnTrueWhenPassAValidPassword(String password) {
        assertTrue(target.isValidPassword(password));
    }

    @DisplayName("should return false when pass an invalid email")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"emailAddress", "emailAddress@.com.au", "email@address@gmail.com"})
    public void shouldReturnFalseWhenPassAnInvalidPassword(String password) {
        assertFalse(target.isValidPassword(password));
    }

    @DisplayName("should throw exception when set invalid password")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"asdasd123!@#", "ASDASD123!Q#", "asdASDasd!@#", "asdASD123ASD", "Aa1@#Aa"})
    public void shouldThrowExceptionWhenSetValidValue(String password) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setPassword(password));
       assertEquals("password is invalid \n (at least 1 upper case letter,\n" +
               " at least 1 lowercase letter,\n at least 1 digits,\n at least 1 special character,\n" +
               " length must not less than 8,\n", exception.getMessage());
    }

    @DisplayName("should return true when set valid password")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"asdASD123!@#"})
    public void shouldReturnPasswordWhenSetValidValue(String password) {
        target.setPassword(password);
        assertEquals(password, target.getPassword());
    }

    //firstName
    @DisplayName("should throw exception when pass a empty value to setFirstName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetFirstNameToEmpty(String firstName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setFirstName(firstName));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a null value to setFirstName function")
    @Test
    public void shouldThrowExceptionWhenSetFirstNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setFirstName(null));
        assertEquals("first name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid name to setFirstName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Vincent", "Andy"})
    public void shouldReturnFirstNameWhenSetValidValue(String firstName) {
        target.setFirstName(firstName);
        assertEquals(firstName, target.getFirstName());
    }

    //lastName
    @DisplayName("should throw exception when pass a empty value to setLastName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetLastNameToEmpty(String lastName) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> target.setLastName(lastName));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a null value to setLastName function")
    @Test
    public void shouldThrowExceptionWhenSetLastNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setLastName(null));
        assertEquals("last name cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should return true when pass a valid last name to setLastName function")
    @ParameterizedTest(name = "Test case #{index}: \"{0}\"")
    @ValueSource(strings = {"Du", "Xie"})
    public void shouldReturnLastNameWhenSetValidValue(String lastName) {
        target.setLastName(lastName);
        assertEquals(lastName, target.getLastName());
    }
}