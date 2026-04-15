package textEditor.resource;

import textEditor.memento.Memento;

public class File {
    private String content;
    private int cursorPosition;
    private String fileName;

    public File(String fileName) {
        this.cursorPosition = 0;
        content = "";
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public void append(String text){
        StringBuilder sb = new StringBuilder(this.content);
        sb.insert(cursorPosition, text);
        content = sb.toString();
        cursorPosition = cursorPosition + text.length();
        System.out.println("File [" + fileName + "]: Appended text. Current content: '" + content + "' | Cursor at: " + cursorPosition);
    }

    public void restore(Memento memento){
        content = memento.getContent();
        cursorPosition = memento.getCursorPosition();
        System.out.println("File [" + fileName + "]: Restored from memento. Content: '" + content + "' | Cursor at: " + cursorPosition);
    }

    public int getContentLength(){
        return this.content.length();
    }

}
