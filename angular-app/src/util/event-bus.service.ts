import {Injectable} from '@angular/core';
import {EventEmitter2} from 'eventemitter2';


@Injectable({
  providedIn: 'root',
})
export class EventBus extends EventEmitter2 {

  constructor() {
    super({wildcard: true});
  }
}
