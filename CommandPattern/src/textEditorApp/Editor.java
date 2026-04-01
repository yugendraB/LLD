package textEditorApp;

import textEditorApp.commands.Command;
import textEditorApp.commands.DeleteCommand;
import textEditorApp.commands.TypeCommand;
import textEditorApp.resource.Page;

import java.util.Stack;

public class Editor {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private final Page page;

    public Editor() {
        page = new Page();
    }

    public void type(String text){
        TypeCommand command = new TypeCommand(page, text);
        command.execute();
        undoStack.add(command);
        redoStack.add(command);
    }

    public void delete(int count){
        DeleteCommand command = new DeleteCommand(page, count);
        command.execute();
        undoStack.add(command);
        redoStack.add(command);
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            System.out.println("Undo Initiated!!");
            Command command = undoStack.pop();
            command.undo();
            System.out.println("Undo Completed!!");
        }
        else{
            System.out.println("Nothing to undo!!");
        }

    }

    public void redo(){
        if(!redoStack.isEmpty()){
            System.out.println("Undo Initiated!!");
            Command command = redoStack.pop();
            command.execute();
            System.out.println("Undo Completed!!");
        }
        else{
            System.out.println("Nothing to redo!!");
        }
    }
}
