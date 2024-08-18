//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package GameFlowing;

/**
 * The Counter class represents a simple counter that can be increased or decreased.
 */
public class Counter {
    private int value;

    /**
     * Constructs a Counter object with the specified initial value.
     *
     * @param number the initial value of the counter
     */
    public Counter(int number) {
        this.value = number;
    }

    /**
     * Increases the counter by the specified amount.
     *
     * @param number the amount to increase the counter by
     */
    public void increase(int number) {
        this.value += number;
    }


    /**
     * Decreases the counter by the specified amount.
     *
     * @param number the amount to decrease the counter by
     */
    public void decrease(int number) {
        this.value -= number;
    }

    /**
     * Returns the current value of the counter.
     *
     * @return the current value of the counter
     */
    public int getValue() {
        return this.value;
    }
}