package patterns.structural.composite;

import com.google.common.collect.Lists;

public class Example {

    public static void main(String[] args) {

        Greeter greeter = new CompositeGreeter(Lists.newArrayList(new EnglishGreeter(), new SpanishGreeter()));
        greeter.greet();

    }

}
