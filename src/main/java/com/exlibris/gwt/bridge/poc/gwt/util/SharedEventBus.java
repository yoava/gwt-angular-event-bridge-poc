package com.exlibris.gwt.bridge.poc.gwt.util;


/**
 * @author yoava
 */
public class SharedEventBus {
    public SharedEventBus() {
        this("__sharedEventBus");
    }

    public SharedEventBus(String referenceName) {
        init(referenceName);
    }

    private native void init(String referenceName) /*-{
        console.debug("Initiating EventBus using '%s'", referenceName)
        this.refName = referenceName;
        this.eventBus = $wnd[referenceName];
    }-*/;

//    emitAsync(event: string | string[], ...values: any[]): Promise<any[]>;
//    on(event: string | string[], listener: Listener): this;
//    prependListener(event: string | string[], listener: Listener): this;
//    once(event: string | string[], listener: Listener): this;
//    prependOnceListener(event: string | string[], listener: Listener): this;
//    many(event: string | string[], timesToListen: number, listener: Listener): this;
//    prependMany(event: string | string[], timesToListen: number, listener: Listener): this;
//    prependAny(listener: EventAndListener): this;
//    offAny(listener: Listener): this;
//    removeListener(event: string | string[], listener: Listener): this;
//    off(event: string, listener: Listener): this;
//    removeAllListeners(event?: string | eventNS): this;
//    setMaxListeners(n: number): void;
//    eventNames(): string[];
//    listeners(event: string | string[]): Listener[] // TODO: not in documentation by Willian
//    listenersAny(): Listener[] // TODO: not in documentation by Willian

    public native boolean emit(String event, Object... values) /*-{
        console.debug('GWT emitting ', event, JSON.stringify(values));
        return this.eventBus.emit.apply(this.eventBus, [event].concat(values));
    }-*/;

    public native <T> SharedEventBus off(String event, EventListener<T> listener) /*-{
        this.eventBus.off(event, listener);
        return this;
    }-*/;

    public native <T> SharedEventBus on(String event, EventListener<T> listener) /*-{
        this.eventBus.on(event, listener);
        return this;
    }-*/;

    public native <T> SharedEventBus onAny(AnyEventListener<T> listener) /*-{
        this.eventBus.onAny(listener);
        return this;
    }-*/;

    public native <T> SharedEventBus offAny(AnyEventListener<T> listener) /*-{
        this.eventBus.offAny(listener);
        return this;
    }-*/;

}
