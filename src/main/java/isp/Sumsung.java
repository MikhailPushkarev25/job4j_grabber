package isp;

/**
 * @author Mikhail Pushkarev
 * @since 30.06.2021
 * @version 2.2
 */
public class Sumsung implements Tv {

    @Override
    public void play() {

    }

    @Override
    public void stamp() {

    }

    @Override
    public void diagonal() {

    }

    @Override
    public void pixel() {

    }

    /**
     * В этом классе я нарушаю isp - так как для проетора нужна диагональ и плэй
     */
    public static class Projector implements Tv {

        @Override
        public void play() {

        }

        @Override
        public void stamp() {

        }

        @Override
        public void diagonal() {

        }

        @Override
        public void pixel() {

        }
    }
}
