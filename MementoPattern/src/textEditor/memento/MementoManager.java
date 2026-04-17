package textEditor.memento;

import java.util.Stack;

public class MementoManager {
    Stack<Memento> history = new Stack<Memento>();

    public Memento undo() {
        System.out.println("MementoManager: Attempting to undo... History size: " + history.size());
        if (history.size() > 1) {
            history.pop();
            Memento m = history.peek();
            System.out.println("MementoManager: Undo successful. Retreived memento.");
            return m;
        } else if (history.size() == 1) {
            history.pop();
            System.out.println("MementoManager: Undo successful. Reverted to initial empty state.");
            return new Memento("", 0);
        }
        System.out.println("MementoManager: Undo failed. History is empty.");
        return null;
    }

    public void save(Memento memento) {
        history.push(memento);
        System.out.println("MementoManager: Saved memento. History size now: " + history.size());
    }
}
