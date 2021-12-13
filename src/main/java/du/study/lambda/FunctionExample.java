package du.study.lambda;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Integer> fun1 = x -> x * x;

        Function<Integer, String> fun2 = Object::toString;

        Function<String, Object> fun3 = x -> {
            if (x == null) {
                return "";
            }
            return x;
        };

        System.out.println(fun1.apply(2)); // 4
        System.out.println(fun2.apply(2)); // 2
        System.out.println(fun3.apply("test")); // "test"
        System.out.println(fun3.apply(null)); // ""

        // 2. compose

        Function<Integer, Integer> multi = x -> x * 5;
        Function<Integer, Integer> add = x -> x + 5;

        Function<Integer, Integer> addThenMultiply = multi.compose(add);
        System.out.println(addThenMultiply.apply(2)); // 35

        // 3. andThen
        Function<Integer, Integer> test_3_multi = (value) -> value * 5;
        Function<Integer, Integer> test_3_add = (value) -> value + 5;

        Function<Integer, Integer> multiplyThenAdd = test_3_multi.andThen(test_3_add);
        System.out.println(multiplyThenAdd.apply(2));


        // 4. identity

        Function<String, String> test_4_fun1 = Function.identity();
        Function<String, String> test_4_fun2 = x -> x; // lambda expression

        System.out.println(test_4_fun1.apply("Test")); // "Test"
        System.out.println(test_4_fun2.apply("Test")); // "Test"
    }
}
