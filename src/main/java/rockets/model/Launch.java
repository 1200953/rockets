package rockets.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

public class Launch extends Entity {
    public enum LaunchOutcome {
        FAILED, SUCCESSFUL
    }

    private LocalDate launchDate;

    private Rocket launchVehicle;

    private LaunchServiceProvider launchServiceProvider;

    private Set<Payload> payloads;

    private String launchSite;

    private String orbit;

    private String function;

    private BigDecimal price;

    private LaunchOutcome launchOutcome;

    public Set<Payload> getPayloads() {
        return payloads;
    }

    public void setPayload(Set<Payload> payload) {
        this.payloads = payload;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public boolean setLaunchDate(LocalDate launchDate) {
        notNull(launchDate,"launch date cannot be null");
        if (isNotBefore19000101(launchDate)){
            this.launchDate = launchDate;
            return true;
        }
        else {
            throw new IllegalArgumentException("launch date should pass 1900-01-01");
        }
    }

    public Rocket getLaunchVehicle() {
        return launchVehicle;
    }

    public void setLaunchVehicle(Rocket launchVehicle) {
        this.launchVehicle = launchVehicle;
    }

    public LaunchServiceProvider getLaunchServiceProvider() {
        return launchServiceProvider;
    }

    public void setLaunchServiceProvider(LaunchServiceProvider launchServiceProvider) {
        this.launchServiceProvider = launchServiceProvider;
    }

    public String getLaunchSite() {
        return launchSite;
    }

    public boolean setLaunchSite(String launchSite) {
        notBlank(launchSite, "launch site cannot be null or empty");
        this.launchSite = launchSite;
        return true;
    }

    public String getOrbit() {
        return orbit;
    }

    public boolean setOrbit(String orbit) {
        notBlank(orbit, "orbit cannot be null or empty");
        this.orbit = orbit;
        return true;
    }

    public String getFunction() {
        return function;
    }

    public boolean setFunction(String function) {
        notBlank(function, "function cannot be null or empty");
        this.function = function;
        return true;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String setPrice(BigDecimal price) {
        notNull(price, "price cannot be null");
        if (isPositive(price)) {
            this.price = price;
            return null;
        }
        return "price cannot be negative or 0";
    }

    public LaunchOutcome getLaunchOutcome() {
        return launchOutcome;
    }

    public void setLaunchOutcome(LaunchOutcome launchOutcome) {
        notNull(launchOutcome, "launch outcome cannot be null");
        this.launchOutcome = launchOutcome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Launch launch = (Launch) o;
        return Objects.equals(launchDate, launch.launchDate) &&
                Objects.equals(launchVehicle, launch.launchVehicle) &&
                Objects.equals(launchServiceProvider, launch.launchServiceProvider) &&
                Objects.equals(orbit, launch.orbit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(launchDate, launchVehicle, launchServiceProvider, orbit);
    }

    private boolean isNotBefore19000101(LocalDate date) {
        return date.isAfter(LocalDate.of(1899, 12, 31));
    }

    private boolean isPositive(BigDecimal price) {
        BigDecimal zero = new BigDecimal(0);
        return price.compareTo(zero) > 0;
    }
}
