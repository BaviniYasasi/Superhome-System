public class main {
    public static void main(String[] args) {
        SuperHomeObserverable observerable=new SuperHomeObserverable();
        observerable.setHomeObserver(new Tv());
        observerable.setHomeObserver(new Speaker());
        observerable.setHomeObserver(new Window());
        observerable.setHomeObserver(new Light());
        new Switch(observerable).setVisible(true);
    }
}
