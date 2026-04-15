package textEditor.app;

import textEditor.memento.Memento;
import textEditor.memento.MementoManager;
import textEditor.resource.File;

import java.util.HashMap;
import java.util.Map;

public class TextEditor {
    private final Map<String, File> files = new HashMap<>();
    private final Map<String , MementoManager> managers = new HashMap<>();
    private File currentFile;

    public void openFile(String fileName){
        System.out.println("TextEditor: Opening file '" + fileName + "'");
        if(!files.containsKey(fileName)){
            System.out.println("TextEditor: File '" + fileName + "' does not exist. Creating new file.");
            File newFile = new File(fileName);
            MementoManager newManager = new MementoManager();
            files.put(fileName, newFile);
            managers.put(fileName, newManager);
            currentFile = newFile;
        }
        else{
            System.out.println("TextEditor: File '" + fileName + "' found. Switching context.");
            currentFile = files.get(fileName);
        }
    }

    public void editFile(String text){
        if(null!=text && !text.isEmpty()){
            System.out.println("TextEditor: Editing file '" + currentFile.getFileName() + "' -> Appending: '" + text + "'");
            currentFile.append(text);
        }
    }

    public void save(){
        System.out.println("TextEditor: Saving file '" + currentFile.getFileName() + "'");
        Memento mem = new Memento(currentFile.getContent(), currentFile.getCursorPosition());
        managers.get(currentFile.getFileName()).save(mem);
    }

    public void undo(){
        System.out.println("TextEditor: Undoing last operation on file '" + currentFile.getFileName() + "'");
        Memento mem = managers.get(currentFile.getFileName()).undo();
        if(mem != null) {
            currentFile.restore(mem);
        } else {
            System.out.println("TextEditor: Nothing to undo for file '" + currentFile.getFileName() + "'");
        }
    }

    public void setCursorPosition(int position){
        System.out.println("TextEditor: Setting cursor position to " + position + " for file '" + currentFile.getFileName() + "'");
        if(position > 0 && position<= currentFile.getContentLength()){
            currentFile.setCursorPosition(position-1);
        }
    }
}
