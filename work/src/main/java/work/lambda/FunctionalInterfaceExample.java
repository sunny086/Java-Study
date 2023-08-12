package work.lambda;

/**
 * 注解测试@FunctionalInterface
 *
 * @author: gorilla
 * @date: 2023/8/12 16:45
 */
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        FunctionalInterfaceExample tester = new FunctionalInterfaceExample();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + performOperation(addition, 10, 5));
        System.out.println("10 - 5 = " + performOperation(subtraction, 10, 5));
        System.out.println("10 x 5 = " + performOperation(multiplication, 10, 5));
        System.out.println("10 / 5 = " + performOperation(division, 10, 5));
    }

    public static int performOperation(MathOperation operation, int a, int b) {
        return operation.operate(a, b);
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
