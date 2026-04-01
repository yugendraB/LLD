package textEditorApp;

public class TextEditorApp {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.type("The Command design pattern is useful when");
        editor.delete(5);
        editor.undo();
        editor.undo();
        editor.redo();
        editor.redo();

        editor.type(" you need to encapsulate actions as objects.");
        editor.redo();
        editor.redo();
        editor.undo();
        editor.undo();
    }
}
