package textEditorApp.resource;

public class Page {
    private final StringBuilder page;

    public Page() {
        this.page = new StringBuilder();
    }
    public void append(String text){
        this.page.append(text);
        System.out.println("Page: " + page.toString());
    }
    public String deleteLast(int n){
        int start = Math.max(0,page.length()-n);
        String deleted = page.substring(start);
        page.delete(start,page.length());
        System.out.println("Page: " + page);
        return deleted;
    }
}
