package patterns.behavioral.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObserverTest {

    private class StringManipulatingObserver implements Observer<String> {

        private final String addition;
        private String data;

        private StringManipulatingObserver(String addition) {
            this.addition = addition;
        }

        @Override
        public void update(String s) {
            data = s + addition;
        }

    }

    @Test
    public void test() throws Exception {
        StringManipulatingObserver o1 = new StringManipulatingObserver("1");
        StringManipulatingObserver o2 = new StringManipulatingObserver("2");
        ConcreteSubject<String> subject = ConcreteSubject.newConcreteSubject();
        subject.registerObserver(o1);
        subject.registerObserver(o2);
        subject.setData("hi");
        subject.updateObservers();
        assertEquals("hi1", o1.data);
        assertEquals("hi2", o2.data);
        subject.removeObserver(o2);
        subject.setData("bye");
        subject.updateObservers();
        assertEquals("bye1", o1.data);
        assertEquals("hi2", o2.data);
    }

}
