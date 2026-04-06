package documentWorkflow.resource;

import com.sun.org.apache.bcel.internal.generic.DREM;
import documentWorkflow.state.DocumentState;
import documentWorkflow.state.DraftState;

public class Document {
    private String content;
    private DocumentState state;

    public Document() {
        this.state = new DraftState();
    }
    public void setState(DocumentState state){
        this.state = state;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }

    public void edit(String content){
        this.state.edit(this,content);
    }
    public void submitForReview(){
        this.state.submitForReview(this);
    }
    public void approve(){
        this.state.approve(this);
    }
    public void reject(){
        this.state.reject(this);
    }
    public void unPublish(){
        this.state.unpublish(this);
    }
}
