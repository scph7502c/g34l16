
package task4;

import java.util.List;

public interface Calculator extends Runnable {
    void calculate(List<Integer> numbers);
}