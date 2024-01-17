package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.Train;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainTest {

    @ParameterizedTest
    @CsvSource({
            "12,20,18, 12,22,18",
            "12,24,18, 13,22,18",
            "12,20,18, 12,17,30"
    })
    void compareToLessThan(int ore1, int min1, int del1, int ore2, int min2, int del2){
        Train t1 = createTrain(ore1,min1,del1);
        Train t2 = createTrain(ore2,min2,del2);
        // mi aspetto che t1 sia minore di t2
        assertThat(t1.compareTo(t2)).isLessThan(0);
    }

    @ParameterizedTest
    @CsvSource({
            "12,20,18, 12,20,18",
            "12,24,18, 12,23,19"
    })
    void compareToEqual(int ore1, int min1, int del1, int ore2, int min2, int del2){
        Train t1 = createTrain(ore1,min1,del1);
        Train t2 = createTrain(ore2,min2,del2);
        // mi aspetto che t1 sia minore di t2
        assertThat(t1.compareTo(t2)).isEqualTo(0);
    }

    @NotNull
    private static Train createTrain(int ore, int minuti, int ritardo) {
        return new Train("Cod1", "Dest1", LocalTime.of(ore, minuti), Duration.ofMinutes(ritardo));
    }
}
