package example1;

import com.thoughtworks.xstream.XStream;
import example1.object.Dude;

public class Example1 {

    public static void main(String[] args) {

        Dude dude = new Dude("Joe", "Doe");

        XStream xStream = new XStream();
        System.out.println(xStream.toXML(dude));

    }

}
