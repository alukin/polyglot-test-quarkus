package ua.cn.al.tst;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 *
 * @author alukin@gmail.com
 *
 */
@QuarkusMain
public class Main {

    public static void main(String... args) {
        System.out.println("Running main method. Go with a browser to http://localhost:8080/hello");
        System.out.println("It should say: Fron JS: 42");
        Quarkus.run(args);
    }
}
