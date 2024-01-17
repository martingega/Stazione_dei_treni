package it.unimi.di.sweng.esame;

import it.unimi.di.sweng.esame.model.Train;
import it.unimi.di.sweng.esame.presenter.DeparturePresenter;
import it.unimi.di.sweng.esame.view.DepartureView;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.mockito.Mockito.*;

public class DeparturePresenterTest {

    @Test
    void updateTest(){

        DepartureView view = mock(DepartureView.class);
        DeparturePresenter SUT = new DeparturePresenter(view, 0);
        // mock dei treni
        Train train1 = mock(Train.class);
        when(train1.toString()).thenReturn("Cod1 Milano 14:12 10");
        Train train2 = mock(Train.class);
        when(train2.toString()).thenReturn("Da stampare nella vista");

        SUT.update(List.of(train1, train2));

        verify(view).set(0, "Cod1 Milano 14:12 10");
        verify(view).set(1, "Da stampare nella vista");
    }
}
