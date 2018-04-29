import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Injectable()
export class PlayerService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  constructor(private http: HttpClient) {
  }

  getPlayer(playerId) {
    return this.http.get<Player>(environment.baseUrl + '');
  }

  createPlayer(player) {
    return this.http.post<Player>(environment.baseUrl + 'player', JSON.stringify(player), this.httpOptions);
  }

}

export interface Player {
  id;
  nickname;
  email;
}
