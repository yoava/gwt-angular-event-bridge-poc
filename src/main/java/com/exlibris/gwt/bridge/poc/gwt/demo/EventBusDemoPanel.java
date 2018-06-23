package com.exlibris.gwt.bridge.poc.gwt.demo;

import com.exlibris.gwt.bridge.poc.gwt.util.SharedEventBus;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * @author yoava
 */
public class EventBusDemoPanel extends SimplePanel {
    private HTML logDiv;
    private TextBox messageField;

    public EventBusDemoPanel(SharedEventBus eventBus) {
        // message log
        logDiv = new HTML();
        logDiv.addStyleName("log");
        log("Press [Send] to send message to Angular.");

        // message field
        messageField = new TextBox();
        messageField.setWidth("100%");
        messageField.setValue("{\"event\":\"demo\",\"cmd\":\"doStuff\"}");

        // send button
        final Button sendButton = new Button("Send", (ClickHandler) clickEvent -> onSendButtonClicked());

        // add app panel
        FlexTable appPanel = new FlexTable();
        appPanel.setWidth("100%");

        appPanel.setWidget(0, 0, messageField);
        appPanel.setWidget(0, 1, sendButton);
        appPanel.setWidget(1, 0, logDiv);
        appPanel.getFlexCellFormatter().setColSpan(1, 0, 2);

        setWidget(appPanel);
    }

    public void log(String text) {
        logDiv.setHTML(logDiv.getHTML() + "<div class='info'>" + text + "</div>");
    }

    private void onSendButtonClicked() {
        String eventJson = messageField.getValue();
        log("Sending message: <span class='event'>" + eventJson + "</span> to Angular...");
    }
}
