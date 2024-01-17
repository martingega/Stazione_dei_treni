package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public class Train implements Comparable<Train>{
    private final @NotNull String code;
    private final @NotNull String destination;
    private final @NotNull LocalTime time;
    private final @NotNull Duration delay;

    public Train(@NotNull String code, @NotNull String destination, @NotNull LocalTime time, @NotNull Duration delay) {
        this.code = code;
        this.destination = destination;
        this.time = time;
        this.delay = delay;
    }

    @Override
    public String toString() {
        return String.format("%-9s %-25s %s %2d", code, destination, time, delay.toMinutes());
    }

    public @NotNull String code() {
        return code;
    }

    public @NotNull String destination() {
        return destination;
    }

    public @NotNull LocalTime time() {
        return time;
    }

    public @NotNull Duration delay() {
        return delay;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Train) obj;
        return Objects.equals(this.code, that.code) &&
                Objects.equals(this.destination, that.destination) &&
                Objects.equals(this.time, that.time) &&
                Objects.equals(this.delay, that.delay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, destination, time, delay);
    }


    @Override
    public int compareTo(@NotNull Train o) {
        return time.plus(delay).compareTo(o.time.plus(o.delay));
    }
}
