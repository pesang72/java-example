package du.study.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        new OptionalExample();
    }

    public OptionalExample(){
        init();
    }

    private void init() {
        // 1. orElse example
        orElseTest();

        // 2. orElseGet example
        orElseGetTest();

        // 3. orElseThrow example
        orElseThrowTest();

        // 4. isPresent example
        isPresentTest();

    }

    private static Optional<String> optionalNullTest(){
        return Optional.ofNullable(null);
    }

    private static Optional<String> optionalValueTest(){
        return Optional.ofNullable("hello world");
    }

    private void orElseTest(){
        String orElse = optionalNullTest().orElse("orElse");
        System.out.println(orElse); // orElse

        orElse = optionalValueTest().orElse("else case");
        System.out.println(orElse); // hello world
    }

    private void orElseGetTest(){
        String orElseGet = optionalNullTest().orElseGet(() -> "orElseGet");
        System.out.println(orElseGet); // orElseGet

        orElseGet = optionalValueTest().orElseGet(() -> "orElseGet");
        System.out.println(orElseGet); // hello world
    }

    private void orElseThrowTest(){
        String orElseThrow = optionalNullTest().orElseThrow(() -> new NoSuchElementException());
        System.out.println(orElseThrow); // Exception in thread "main" java.util.NoSuchElementException

        orElseThrow = optionalValueTest().orElseThrow(() -> new NoSuchElementException());
        System.out.println(orElseThrow); //  hello world
    }

    private void isPresentTest(){
        Optional<String> optionalTest = optionalValueTest();
        if(optionalTest.isPresent()){
            String test = optionalTest.get();
            System.out.println(test); // hello world
        }
    }

}
