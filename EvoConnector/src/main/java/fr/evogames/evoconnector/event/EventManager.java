package fr.evogames.evoconnector.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class EventManager {

    private Set<Listener> listeners;

    public EventManager() {
        this.listeners = new HashSet<>();
    }

    public void registerListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void callEvent(Event event) {
        listeners.forEach(listener -> {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (isEventHandler(method)) {
                    try {
                        if (method.getParameterCount() == 1 && method.getParameters()[0].getType().equals(event.getClass()))
                            method.invoke(listener, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean isEventHandler(Method method) {
        return method.isAnnotationPresent(EventHandler.class);
    }
}
