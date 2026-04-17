package textEditor.memento;

public class Memento {
    private final String content;
    private final int cursorPosition;

    public Memento(String content, int cursorPosition) {
        this.content = content;
        this.cursorPosition = cursorPosition;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}
