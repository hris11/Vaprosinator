import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  getPlayer(playerId) {
    return this.http.get<Player>(`localhost:8080/playerinformation`);
  }

}

export interface Player {
  id;
  username;
  interface;
}
