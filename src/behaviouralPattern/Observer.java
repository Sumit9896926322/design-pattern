package behaviouralPattern;

import java.util.ArrayList;
import java.util.Arrays;


interface IEventManager {
    void subscribe(User... user);

    void unsubscribe(User... user);

    void notifyEvent(Event event);
}

class EventManager implements IEventManager {
    ArrayList<User> users = new ArrayList<User>();

    @Override
    public void subscribe(User... user) {
        for(User u:user){
            System.out.println(u.name+ " starts listening");
        }
        users.addAll(Arrays.asList(user));
    }

    @Override
    public void unsubscribe(User... user) {
        for(User u:user){
            System.out.println(u.name+ " stops listening");
        }
        users.removeAll(Arrays.asList(user));
    }

    @Override
    public void notifyEvent(Event event) {
        for (User user : users) {
            user.notifier(event);
        }
    }
}

enum EventType {
    MOUSECLICK,
    KEYBOARDCLICK
}

abstract class Event {
    EventType type;
    int hitCount;

    public void setType(EventType type) {
        this.type = type;
    }

    void click() {
        this.hitCount++;
    }
}

class MouseClick extends Event {
    MouseClick() {
        setType(EventType.MOUSECLICK);
    }

}

class KeyboardClick extends Event {
    KeyboardClick() {
        setType(EventType.KEYBOARDCLICK);
    }

}

class User {
    String name;

    User(String name) {
        this.name = name;
    }

    public void notifier(Event event) {
        System.out.print(this.name + " is listening ");
        System.out.println("Event occurs " + event.type + " " + event.hitCount + " times");
        System.out.println("=====");
    }
}

public class Observer {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        User bob = new User("bob");
        User marry = new User("marry");
        MouseClick mouseClickEvent = new MouseClick();
        KeyboardClick keyboardClick = new KeyboardClick();

        eventManager.subscribe(bob);
        eventManager.subscribe(marry);
        //bob and marry will listen mouse and keyboard click

        mouseClickEvent.click();
        keyboardClick.click();
        eventManager.notifyEvent(mouseClickEvent);
        eventManager.notifyEvent(keyboardClick);

        eventManager.unsubscribe(bob); //bob stops listening after this

        mouseClickEvent.click();
        keyboardClick.click();
        eventManager.notifyEvent(mouseClickEvent);
        eventManager.notifyEvent(keyboardClick);

    }
}



