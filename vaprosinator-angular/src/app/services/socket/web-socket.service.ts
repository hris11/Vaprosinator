import { Injectable } from '@angular/core';

@Injectable()
export class WebSocketService {
  private chatSocket;

  load(): Promise<any> {
    return this.initSocket();
  }
  public initSocket() {
    return new Promise<any>((resolve, reject) => {
      this.chatSocket = new WebSocket('ws://localhost:9090'); // change to your port

              this.chatSocket.onopen = function (e) {
                console.log('Connected to socket server');
                resolve();
              };

              this.chatSocket.onmessage = function(e) {
                console.log(e.data);
              };

              this.chatSocket.onclose = function(e) {
                console.error('Chat socket closed unexpectedly');
              };
    });
  }
  public send(message): void {
    if (this.chatSocket.readyState === WebSocket.OPEN) {
      this.chatSocket.send(message);
         // this.chatSocket.send(JSON.stringify(message));
    }
  }

}
