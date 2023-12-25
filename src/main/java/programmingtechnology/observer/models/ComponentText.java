package programmingtechnology.observer.models;

import javafx.scene.control.TextField;
import programmingtechnology.observer.logics.Observer;
import programmingtechnology.observer.logics.Subject;

public class ComponentText extends Observer {
    String text;
    public TextField dindon;
    Boolean state;
    public ComponentText(Subject subject, TextField dindon){
        this.text = "Прошло _ с";
        this.state = false;
        this.dindon = dindon;
        this.subject = subject;
        this.subject.attach(this);
    }
    public void onComp() {
        this.state = true;
    }
    public void offComp(){
        this.state = false;
    }
    public void delComp(Subject st){
        st.detach(this);
        dindon.setText("Прошло _ с");
    }
    @Override
    public void update(){
        if(state){
            text = "Прошло "+this.subject.getState()+" c";
            dindon.setText(text);
        }
    }
}
