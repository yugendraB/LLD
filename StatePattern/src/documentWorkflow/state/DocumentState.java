package documentWorkflow.state;

import documentWorkflow.resource.Document;

public interface DocumentState {
    public void edit(Document context, String content);
    public void submitForReview(Document context);
    public void approve(Document context);
    public void reject(Document cotext);
    public void unpublish(Document context);
}
