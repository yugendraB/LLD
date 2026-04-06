package documentWorkflow.state;

import documentWorkflow.resource.Document;

public class PublishedState implements DocumentState{
    @Override
    public void edit(Document context, String content) {
        System.out.println("Canot edit published document");
    }

    @Override
    public void submitForReview(Document context) {
        System.out.println("Document is already published");
    }

    @Override
    public void approve(Document context) {
        System.out.println("Document is already approved");
    }

    @Override
    public void reject(Document cotext) {
        System.out.println("Document is already approved");
    }

    @Override
    public void unpublish(Document context) {
        context.setState(new DraftState());
        System.out.println("Unpublished the document");
    }
}
