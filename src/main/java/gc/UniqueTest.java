package gc;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;
import java.util.*;

public class UniqueTest {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        check.addAll(Arrays.asList(origin));

        for (String s : text) {
            if (!check.contains(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean isSize(String originText, String duplicateText) {
        boolean rsl = false;
        List<String> list = new ArrayList<>();
        list.add(originText);
        for (String s : list) {
            if (s.equals(duplicateText)) {
                rsl = true;
            }
        }
        return rsl;
    }

    @Benchmark
    public void genTest() {
        isEquals("Покупаю танхаус за городрм", "Покупаю за городом танхаус");
    }

    @Benchmark
    public void genTest2() {
        isSize("Я покупаю", "Я покупаю");
    }

    public static void main(String[] args) throws IOException {
        Main.main(args);
    }
}
