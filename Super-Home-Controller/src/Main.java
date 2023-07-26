import controller.SwitchObservable;
import view.*;

public class Main {
    public static void main(String[] args) {
        SwitchObservable switchObserverble = new SwitchObservable();
        switchObserverble.addSwitchObserver(new Components("TV",870,40));
        switchObserverble.addSwitchObserver(new Components("Speaker",250,40));
        switchObserverble.addSwitchObserver(new Components("Light",870,540));
        switchObserverble.addSwitchObserver(new Components("Window",250,540));


        new MainSwitchWindow(switchObserverble);
        new LocalTimeWindow();
    }
}