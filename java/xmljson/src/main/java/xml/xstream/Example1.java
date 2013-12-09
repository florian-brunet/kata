package xml.xstream;

import com.thoughtworks.xstream.XStream;
import common.bean.Dude;

public class Example1 {

    public static void main(String[] args) {

        Dude dude = new Dude();
        dude.setFirstName("Joe");
        dude.setLastName("Doe");

        XStream xStream = new XStream();
        xStream.alias("dude", Dude.class);

        System.out.println(xStream.toXML(dude));
        System.out.println();

        xStream.useAttributeFor(Dude.class, "firstName");
        xStream.useAttributeFor(Dude.class, "lastName");

        System.out.println(xStream.toXML(dude));

    }

}
