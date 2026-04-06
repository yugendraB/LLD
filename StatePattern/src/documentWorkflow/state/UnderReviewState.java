package documentWorkflow.state;

import documentWorkflow.resource.Document;

public class UnderReviewState implements DocumentState{
    @Override
    public void edit(Document context, String content) {
        System.out.println("Cannot edit the document while it is under review");
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Document is already under review");
    }

    @Override
    public void approve(Document context) {
        context.setState(new PublishedState());
        System.out.println("Document approved");
    }

    @Override
    public void reject(Document context) {
        context.setState(new RejectedState());
        System.out.println("Document rejected");
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document is not published yet.");
    }
}
