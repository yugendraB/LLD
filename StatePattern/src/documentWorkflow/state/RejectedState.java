package documentWorkflow.state;

import documentWorkflow.resource.Document;

public class RejectedState implements DocumentState{
    @Override
    public void edit(Document context, String content) {
        context.setContent(content);
        context.setState(new DraftState());
        System.out.println("Document edited successfully");
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Cannot submit for review until document is drafted");
    }

    @Override
    public void approve(Document context) {
        System.out.println("Cannot approve a rejected document");
    }

    @Override
    public void reject(Document cotext) {
        System.out.println("Document is already rejected");
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document is not published yet");
    }
}