import {ApplicationRef, NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {EventBus} from '../util/event-bus.service';

import {AppComponent} from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [EventBus],
  bootstrap: [AppComponent]
})
export class AppModule {

  constructor(eventBus: EventBus, applicationRef: ApplicationRef) {

    // share EventBus globally
    window['__sharedEventBus'] = eventBus;

    // refresh after any event
    eventBus.onAny(() => setTimeout(() => applicationRef.tick(), 0))
  }
}
