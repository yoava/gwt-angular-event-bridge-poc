package com.exlibris.gwt.bridge.poc.gwt.demo;

import com.exlibris.gwt.bridge.poc.gwt.util.AnyEventListener;
import com.exlibris.gwt.bridge.poc.gwt.util.SharedEventBus;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.*;

/**
 * @author yoava
 */
public class EventBusDemoPanel extends SimplePanel {
    private HTML logDiv;
    private TextBox messageField;
    private SharedEventBus eventBus;

    public EventBusDemoPanel(SharedEventBus eventBus) {
        this.eventBus = eventBus;

        // message log
        logDiv = new HTML();
        logDiv.addStyleName("log");
        log("Press [Send] to send message to Angular.");

        // message field
        messageField = new TextBox();
        messageField.setValue("{\"event\":\"demo\",\"cmd\":\"doStuff\"}");

        // send button
        final Button sendButton = new Button("Send", (ClickHandler) clickEvent -> onSendButtonClicked());

        // add app panel
        FlowPanel appPanel = new FlowPanel();

        FlowPanel formPanel = new FlowPanel();
        formPanel.addStyleName("form");
        formPanel.add(messageField);
        formPanel.add(sendButton);
        appPanel.add(formPanel);
        appPanel.add(logDiv);

        eventBus.onAny((AnyEventListener<JavaScriptObject>) (eventName, event) ->
            EventBusDemoPanel.this.log("Received event '" + eventName + "': <span class='event'>"
                + JsonUtils.stringify(event) + "</span>"));

        eventBus.on("demo", (DemoEvent event) -> EventBusDemoPanel.this.log("Got DEMO event: cmd: " + event.getCmd()));

        setWidget(appPanel);
    }

    public void log(String text) {
        logDiv.setHTML(logDiv.getHTML() + "<div class='info'>" + text + "</div>");
    }

    private void onSendButtonClicked() {
        String eventJson = messageField.getValue();
        log("Sending message: <span class='event'>" + eventJson + "</span> to Angular...");

        JSONObject jsonValue = (JSONObject) JSONParser.parseStrict(eventJson);
        String eventName = jsonValue.get("event").isString().stringValue();

        eventBus.emit(eventName, jsonValue.getJavaScriptObject());
    }
}
