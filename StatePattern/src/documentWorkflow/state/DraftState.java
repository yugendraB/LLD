package documentWorkflow.state;

import documentWorkflow.resource.Document;

public class DraftState implements DocumentState{
    @Override
    public void edit(Document context, String content) {
        System.out.println("Editing the Document");
        context.setContent(content);
        context.setState(new DraftState());
    }

    @Override
    public void submitForReview(Document context) {
        context.setState(new UnderReviewState());
        System.out.println("Document submitter for review");
    }

    @Override
    public void approve(Document context) {
        System.out.println("Please submit the document for review before approving it");
    }

    @Override
    public void reject(Document cotext) {
        System.out.println("Cannot reject the document. Document is yet not submitted");
    }

    @Override
    public void unpublish(Document context) {
        System.out.println("Document is already in draft State");
    }
}
