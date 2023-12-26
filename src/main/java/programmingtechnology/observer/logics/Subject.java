package programmingtechnology.observer.logics;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Subject {
    Timer timer;
    private List<Observer> observers = new ArrayList<Observer>();
    int state;
    int d, p;
    public Subject(){
        this.state = 0;
        this.d = 0;
        this. p = 0;
    }
    public void start(int d, int p){
        this.d = d;
        this.p = p;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, d * 1000, p * 1000);
    }
    public void stop(){
        timer.cancel();
    }
    public void clean(){
        state = 0;
        stop();
    }
    private void tick(){
        if(state == 0)
            this.state += d;
        else
            this.state += p;
        notifyAllObservers();
    }
    public int getState(){
        return this.state;
    }
    public void setState(int state){
        this.state = state;
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.subject = this;
            observer.update();
        }
    }
}
