package com.exlibris.gwt.bridge.poc.gwt.util;

import jsinterop.annotations.JsFunction;

/**
 * @author yoava
 */
@JsFunction
public interface AnyEventListener<T> {

    void callback(String eventName, T event);
}
