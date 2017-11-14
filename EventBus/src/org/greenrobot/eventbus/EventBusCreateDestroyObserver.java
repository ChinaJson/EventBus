package org.greenrobot.eventbus;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;


public class EventBusCreateDestroyObserver implements LifecycleObserver {

    private final LifecycleOwner lifecycleOwner;
    private final EventBus eventBus;

    public EventBusCreateDestroyObserver(LifecycleOwner lifecycleOwner, EventBus eventBus) {
        this.lifecycleOwner = lifecycleOwner;
        this.eventBus = eventBus;
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    void start() {
        eventBus.register(lifecycleOwner);
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    void stop() {
        eventBus.unregister(lifecycleOwner);
    }

}
