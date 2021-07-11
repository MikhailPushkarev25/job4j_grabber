package serialization.json.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "House")
@XmlAccessorType(XmlAccessType.FIELD)
public class House {

    @XmlAttribute
    private boolean rsl;

    @XmlAttribute
    private int num;
    private String street;
    private Concat concat;
    private int[] cell;

    public House() {

    }

    public House(boolean rsl, int num, String street, Concat concat, int... cell) {
        this.rsl = rsl;
        this.num = num;
        this.street = street;
        this.concat = concat;
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "House{"
                + "rsl=" + rsl
                + ", num=" + num
                + ", street='" + street + '\''
                + ", concat=" + concat
                + ", cell=" + Arrays.toString(cell)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        House house = new House(false, 25, "Lucheva", new Concat("D.123"), 1, 2, 3);

        JAXBContext context = JAXBContext.newInstance(House.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(house, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        }
    }
}
