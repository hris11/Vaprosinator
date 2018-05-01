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
    var chatSocket = new WebSocket('ws://localhost:9090'); //change to your port

    chatSocket.onopen = function (e) {
      console.log("Connected to socket server");
    };

    chatSocket.onmessage = function(e) {
      console.log(e.data);
    };

    chatSocket.onclose = function(e) {
      console.error('Chat socket closed unexpectedly');
    };
  }
}
