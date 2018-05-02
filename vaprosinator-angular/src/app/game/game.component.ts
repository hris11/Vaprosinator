import { Component, OnInit } from '@angular/core';
import { WebSocketService } from '../services/socket/web-socket.service';
@Component({
selector: 'app-game',
templateUrl: './game.component.html',
styleUrls: ['./game.component.css']
})

export class GameComponent implements OnInit {


  constructor(private webSocket: WebSocketService) {
  }

  ngOnInit() {
    this.webSocket.send('asdfsafas');
  }
}
