package com.exlibris.gwt.bridge.poc.gwt.util;


/**
 * @author yoava
 */
public class EventBus {
    public EventBus() {
        this("__sharedEventBus");
    }

    public EventBus(String referenceName) {
        init(referenceName);
    }

    private native void init(String referenceName) /*-{
        console.debug("Initiating EventBus using '%s'", referenceName)
        this.refName = referenceName;
        this.eventBus = $wnd[referenceName];
    }-*/;

//    emit(event: string | string[], ...values: any[]): boolean;
//    emitAsync(event: string | string[], ...values: any[]): Promise<any[]>;
//    addListener(event: string, listener: Listener): this;
//    on(event: string | string[], listener: Listener): this;
//    prependListener(event: string | string[], listener: Listener): this;
//    once(event: string | string[], listener: Listener): this;
//    prependOnceListener(event: string | string[], listener: Listener): this;
//    many(event: string | string[], timesToListen: number, listener: Listener): this;
//    prependMany(event: string | string[], timesToListen: number, listener: Listener): this;
//    onAny(listener: EventAndListener): this;
//    prependAny(listener: EventAndListener): this;
//    offAny(listener: Listener): this;
//    removeListener(event: string | string[], listener: Listener): this;
//    off(event: string, listener: Listener): this;
//    removeAllListeners(event?: string | eventNS): this;
//    setMaxListeners(n: number): void;
//    eventNames(): string[];
//    listeners(event: string | string[]): Listener[] // TODO: not in documentation by Willian
//    listenersAny(): Listener[] // TODO: not in documentation by Willian

    public native boolean emit(String eventName, Object event) /*-{
        console.debug('GWT emitting ', eventName, event);
        return this.eventBus.emit(eventName, event);
    }-*/;
}
