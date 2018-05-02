import { Injectable } from '@angular/core';

@Injectable()
export class WebSocketService {
  private Socket;

  load(): Promise<any> {
    return this.initSocket();
  }
  public initSocket() {
    return new Promise<any>((resolve, reject) => {
      this.Socket = new WebSocket('ws://localhost:9090'); // change to your port

              this.Socket.onopen = function (e) {
                console.log('Connected to socket server');
                resolve();
              };

              this.Socket.onmessage = function(e) {
                console.log(e.data);
              };

              this.Socket.onclose = function(e) {
                console.error('Chat socket closed unexpectedly');
              };
    });
  }
  public send(message): void {
    if (this.Socket.readyState === WebSocket.OPEN) {
  this.Socket.send(message);
         // this.chatSocket.send(JSON.stringify(message));
    }
  }

}
