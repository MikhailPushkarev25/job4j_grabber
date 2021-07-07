package template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class GeneratorTest {

    @Test
    public void whenGenerate() {
        GenDemo demo = new GenDemo();
        String keys = "I am a ${name}, who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Mikhail");
        map.put("subject", "you");
        String result = "I am a Mikhail, who are you";
        String rsl = demo.produce(keys, map);
        assertThat(rsl, is(result));
    }

    @Test
    public void whenNoKeys() {
        GenDemo demo = new GenDemo();
        String keys = "I am a ${name}, who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("subject", "you");
        String result = demo.produce(keys, map);
    }

    @Test
    public void whenNotParam() {
        GenDemo demo = new GenDemo();
        String keys = "I am a ${name}, who are ${subject}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Mikhail");
        map.put("surname", "you");
        String result = demo.produce(keys, map);
    }
}