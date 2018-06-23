package com.exlibris.gwt.bridge.poc.gwt.demo;

import com.exlibris.gwt.bridge.poc.gwt.util.EventBus;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GwtAppEntryPoint implements EntryPoint {
    public void onModuleLoad() {
        RootPanel.get("gwtApp").add(new EventBusDemoPanel(new EventBus()));
    }
}
