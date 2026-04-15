package textEditor;

import textEditor.app.TextEditor;

public class TextEditorClient {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.openFile("Demo");
        editor.editFile("first text has been inserted");
        editor.save();
        editor.openFile("secondFile");
        editor.editFile("this is the second file");
        editor.save();
        editor.openFile("Demo");
        editor.setCursorPosition(6);
        editor.editFile("demo ");
        editor.save();
        editor.undo();
        editor.openFile("secondFile");
        editor.undo();
    }
}
