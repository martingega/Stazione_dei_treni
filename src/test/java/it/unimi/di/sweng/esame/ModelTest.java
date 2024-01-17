package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Train;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;


public class ModelTest {

    @Test
    void getStateEmpty(){
        Model SUT = new Model();
        assertThat(SUT.getState()).isEmpty();
    }

    @Test
    void getStateAfterReadFile(){
        Model SUT = new Model();
        SUT.readFile();
        List<Train> trains = SUT.getState();
        assertThat(trains.size()).isEqualTo(20); // perche' ci sono 20 treni nel file
        assertThat(trains)
                .extracting("code", "destination")
                .contains(tuple("TN 10471","STRADELLA"));
        assertThat(trains.toString()).contains("TN 10471 STRADELLA 14:54 10");
    }

}
