package com.exlibris.gwt.bridge.poc.gwt.demo;

import jsinterop.annotations.JsType;

import static jsinterop.annotations.JsPackage.GLOBAL;

/**
 * @author yoava
 */
@JsType(isNative = true, namespace = GLOBAL, name = "Object")
public class DemoEvent {
    public String event;
    public String cmd;

}
