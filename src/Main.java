import controller.SwitchObservable;
import view.*;

public class Main {
    public static void main(String[] args) {
        SwitchObservable switchObservable = SwitchObservable.getInstance();
        switchObservable.addSwitchObserver(new Components("TV", 870, 40));
        switchObservable.addSwitchObserver(new Components("Speaker", 250, 40));
        switchObservable.addSwitchObserver(new Components("Light", 870, 540));
        switchObservable.addSwitchObserver(new Components("Window", 250, 540));


        new MainSwitchWindow();
        new LocalTimeWindow();
    }
}