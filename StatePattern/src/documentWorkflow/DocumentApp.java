package documentWorkflow;

import documentWorkflow.resource.Document;

//This class interacts with the document
//this should be able to do few operations.  like editDocument, approveDocument, submitDocumentForReview, rejectDocument, approveDocument, unpublishDocument
public class DocumentApp {
    public static void main(String[] args) {
        Document doc = new Document();

        doc.edit("First draft of the article.");
        doc.approve();              // Rejected: cannot approve a draft
        doc.submitForReview();
        doc.edit("Trying to edit");  // Rejected: under review
        doc.reject();                // Back to draft
        doc.edit("Revised draft.");
        doc.submitForReview();
        doc.approve();               // Published
        doc.edit("Trying to edit");  // Rejected: published
        doc.unPublish();             // Back to draft
    }
}
