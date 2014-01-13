package patterns.behavioral.observer;

public interface Subject<Data> {
    void registerObserver(Observer<Data> observer);
    void removeObserver(Observer<Data> observer);
    void updateObservers();
}
