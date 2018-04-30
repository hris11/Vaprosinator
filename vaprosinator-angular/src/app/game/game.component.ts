import { Component, OnInit } from '@angular/core';

@Component({
selector: 'app-game',
templateUrl: './game.component.html',
styleUrls: ['./game.component.css']
})

export class GameComponent implements OnInit {


  constructor() {
  }

  ngOnInit() {
    var chatSocket = new WebSocket('ws://localhost:9999/socket');

    chatSocket.onopen = function (e) {
      console.log("asdddddddd")
    };

    chatSocket.onmessage = function(e) {
      console.log(e)
    };

    chatSocket.onclose = function(e) {
      console.error('Chat socket closed unexpectedly');
    };
  }
}
