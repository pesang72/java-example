package du.study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> consumer = s -> System.out.println(s);
//        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");

        ConsumerDto test1 = new ConsumerDto();
        ConsumerDto test2 = new ConsumerDto();

        ifPresent("name1", test1::setName);
        ifPresent(null, test2::setName);

        System.out.println(test1.getName());
        System.out.println(test2.getName());

        // andThen TEST
        List<Integer> ints = Arrays.asList(1,2,3);

        Consumer<List<Integer>> doubleNumber = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i)*list.get(i));
            }
        };

        Consumer<List<Integer>> println = list -> {
            for (Integer fruit : list) {
                System.out.println(fruit);
            }
        };
        doubleNumber.andThen(println).accept(ints);

    }


    public static void ifPresent(String str, Consumer<String> consumer){
        // StringUtils 를 임포트 안해놔서..
        if(str != null){
            consumer.accept(str);
        }
    }
}

class ConsumerDto{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
