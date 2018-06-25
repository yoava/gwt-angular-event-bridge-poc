package com.exlibris.gwt.bridge.poc.gwt.demo;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author yoava
 */
public class DemoEvent extends JavaScriptObject {
    protected DemoEvent() {
    }

    public final native String getEvent() /*-{
        return this.event;
    }-*/;

    public final native void setEvent(String event) /*-{
        this.event = event;
    }-*/;

    public final native String getCmd() /*-{
        return this.cmd;
    }-*/;

    public final native void setCmd(String cmd) /*-{
        this.cmd = cmd;
    }-*/;
}
