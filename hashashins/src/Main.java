import java.io.File;

public class Main {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager("./hashashins/input");

        System.out.println(inputManager.getInputFileByName("a_example"));
    }

}
