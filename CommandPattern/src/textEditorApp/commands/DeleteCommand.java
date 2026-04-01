package textEditorApp.commands;

import textEditorApp.Editor;
import textEditorApp.resource.Page;

public class DeleteCommand implements Command{

    private final Page page;
    private final int count;
    private String deletedText;

    public DeleteCommand(Page page, int count) {
        this.page = page;
        this.count = count;
    }

    @Override
    public void execute() {
        deletedText = page.deleteLast(count);
        System.out.println("Delete Command executed succesfully for count: " + count);
    }

    @Override
    public void undo() {
        page.append(deletedText);
        System.out.println("Delete Command Undo Succesfull for count: " + count);
    }
}
