package dip.onepr;

/**
 * @author Mikhail Pushkarev
 * @since 02.07.2021
 * @version 2.2
 *
 * В класах я нарашую принцип поведения DIP
 * так как у меня верхний класс зависит от нижнего
 * для того что бы исправить, нужно создать интерфейс
 * и тогда зависимость будет  только от интерфейса
 * и код будет гибкий
 */
public class Computer {

    private String name;
    private Game game;

    public Computer(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public void play(String name) {
        game.play();
        System.out.println("Начал играть");
    }
}
