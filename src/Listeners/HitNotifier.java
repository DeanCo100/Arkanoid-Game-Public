//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package Listeners;

/**
 * The HitNotifier interface represents an object that can notify listeners about hit events.
 */
public interface HitNotifier {
    /**
     * Adds the specified listener to the list of listeners to be notified about hit events.
     *
     * @param hl the listener to be added
     */
    void addHitListener(HitListener hl);


    /**
     * Removes the specified listener from the list of listeners to be notified about hit events.
     *
     * @param hl the listener to be removed
     */
    void removeHitListener(HitListener hl);
}