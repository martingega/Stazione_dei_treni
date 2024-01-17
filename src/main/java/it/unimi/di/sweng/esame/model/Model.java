package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Model implements Observable<List<Train>> {

  private @NotNull final Map<String, Train> trains = new HashMap<>();
  private @NotNull final List<Observer<List<Train>>> observers = new ArrayList<>();

  public void readFile() {
    InputStream is = Main.class.getResourceAsStream("/trains.csv");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(",");
      String cod = el[0];
      String destination = el[1];
      String depTime = el[2];
      String delay = el[3];

      //TODO sostituire la stampa con la memorizzazione all'interno del modello con una opportuna struttura dati
      //System.out.printf("cod: [%s] dest: [%s] time: [%s] delay: [%s]\n", cod, destination, depTime, delay);

      trains.put(cod, new Train(
              cod,
              destination,
              LocalTime.parse(depTime, DateTimeFormatter.ofPattern("H:m")),
              Duration.ofMinutes(Integer.parseInt(delay))));
    }
  }


  @Override
  @NotNull
  public List<Train> getState() {
    return new ArrayList<>(trains.values());
  }

  @Override
  public void notifyObservers() {
    for (Observer<List<Train>> observer : observers) {
      observer.update(getState());
    }
  }

  @Override
  public void addObserver(@NotNull Observer<List<Train>> observer) {
    observers.add(observer);
  }

  public void departed(String trainCode) {
    //remove ritorna l'oggetto rimosso se l'ha rimosso, altrimenti ritorna null
    if (trains.remove(trainCode) != null)
      notifyObservers();
  }
}
