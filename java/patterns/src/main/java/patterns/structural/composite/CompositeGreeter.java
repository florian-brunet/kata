package patterns.structural.composite;

import java.util.List;

public class CompositeGreeter implements Greeter {

    private List<Greeter> greeters;

    public CompositeGreeter(List<Greeter> greeters) {
        this.greeters = greeters;
    }

    @Override
    public void greet() {
        for (Greeter greeter : greeters) {
            greeter.greet();
        }
    }

}
