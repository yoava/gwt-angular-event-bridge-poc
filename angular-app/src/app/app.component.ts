import {Component} from '@angular/core';
import {EventBus} from '../util/event-bus.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  eventJson: string = JSON.stringify({"event": "demo", "cmd": "doStuff"});
  logMessages: string[] = [];

  constructor(private eventBus: EventBus) {
    this.log('Press [Send] to send message to GWT.');

    this.eventBus.onAny((eventName, event) => {
      this.log(`Received event '${eventName}': <span class="event">${JSON.stringify(event)}</span>`)
    });
  }

  onSendButtonClicked() {
    this.log("Sending message: <span class='event'>" + this.eventJson + "</span> to GWT...");
    const event = JSON.parse(this.eventJson);
    this.eventBus.emit(event.event, event);
  }

  private log(message) {
    this.logMessages.push(message);
  }
}
