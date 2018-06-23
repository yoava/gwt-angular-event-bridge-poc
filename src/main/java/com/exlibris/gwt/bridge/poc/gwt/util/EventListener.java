package com.exlibris.gwt.bridge.poc.gwt.util;

import jsinterop.annotations.JsFunction;

/**
 * @author yoava
 */
@JsFunction
public interface EventListener {

    void callEvent(Object event);
}
