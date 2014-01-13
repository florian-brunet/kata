package patterns.behavioral.observer;

import com.google.common.collect.Sets;

import java.util.Set;

public class ConcreteSubject<Data> implements Subject<Data> {

    public static <T> ConcreteSubject<T> newConcreteSubject() {
        return new ConcreteSubject<T>();
    }

    private Set<Observer<Data>> observers = Sets.newHashSet();
    private Data currentData;

    @Override
    public void registerObserver(Observer<Data> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<Data> observer) {
        observers.remove(observer);
    }

    @Override
    public void updateObservers() {
        for (Observer<Data> observer : observers) {
            observer.update(currentData);
        }
    }

    public void setData(Data newData ) {
        currentData = newData;
    }

}
