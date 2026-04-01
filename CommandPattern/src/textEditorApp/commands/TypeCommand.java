package textEditorApp.commands;

import textEditorApp.Editor;
import textEditorApp.resource.Page;

public class TypeCommand implements Command{
    private final Page page;
    private final String text;

    public TypeCommand(Page page, String text) {
        this.page = page;
        this.text = text;
    }

    @Override
    public void undo() {
        page.deleteLast(text.length());
        System.out.println("Type Command Undo Executed for text: " + text);
    }

    @Override
    public void execute() {
        if(text!=null){
            page.append(text);
            System.out.println("Type Command executed for text: " + this.text);
        }
    }
}
