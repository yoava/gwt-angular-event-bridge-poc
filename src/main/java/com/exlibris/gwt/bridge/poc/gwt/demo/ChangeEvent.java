package com.exlibris.gwt.bridge.poc.gwt.demo;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author yoava
 */
public class ChangeEvent extends GwtEvent<ChangeEvent.Handler> {

    private static final Type<Handler> TYPE = new Type<>();

    public ChangeEvent() {
    }

    public static Type<Handler> getType() {
        return TYPE;
    }

    @Override
    public final Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onChange(this);
    }

    public interface Handler extends EventHandler {
        void onChange(ChangeEvent event);
    }
}
