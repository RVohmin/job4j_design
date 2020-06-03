package gc;

public class User {

    public User(String name) {
    }

    @Override
    public void finalize() {
        System.out.println("finalize");
    }
}
