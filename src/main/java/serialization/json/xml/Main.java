package serialization.json.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        House house = new House(false, 25, "Lucheva", new Concat("D.123"), 1, 2, 3);

        JAXBContext context = JAXBContext.newInstance(House.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String str = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(house, writer);
            str = writer.getBuffer().toString();
            System.out.println(str);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(str)) {
            House result = (House) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
