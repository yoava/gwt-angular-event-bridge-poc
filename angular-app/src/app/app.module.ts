import {NgModule} from '@angular/core';
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

  constructor(eventBus: EventBus) {

    // share EventBus globally
    window['__sharedEventBus'] = eventBus;
  }
}
