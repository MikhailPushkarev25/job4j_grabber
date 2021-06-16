package cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dirFileCache = new DirFileCache("./");
        String name = dirFileCache.get("Names.txt");
        System.out.println(name);
        String address = dirFileCache.get("Address.txt");
        System.out.println(address);
    }
}
