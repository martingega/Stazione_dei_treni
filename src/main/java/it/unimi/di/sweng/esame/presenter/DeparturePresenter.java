package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.model.Train;
import it.unimi.di.sweng.esame.view.DepartureView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeparturePresenter implements Observer<List<Train>>{

    private final DepartureView view;

    public DeparturePresenter(DepartureView view) {
        this.view = view;
    }

    @Override
    public void update(@NotNull List<Train> state) {
        int i=0;
        state.sort(null);   // inseriamo null per indicare sort dell'ordine naturale
        for (int j = 0; j < state.size() && j < Main.MAX_ROW_ITEMS_IN_VIEW; j++) {
            Train train = state.get(j);
            view.set(i++, train.toString());
        }
    }
}
