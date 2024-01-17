package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.Model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ModelTest {

    @Test
    void getStateEmpty(){
        Model SUT = new Model();
        assertThat(SUT.getState()).isEmpty();
    }

}
