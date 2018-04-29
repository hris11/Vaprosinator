import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../services/player/player.service';

@Component({
  selector: 'app-player-home',
  templateUrl: './player-home.component.html',
  styleUrls: ['./player-home.component.css'],
  providers: [PlayerService]
})
export class PlayerHomeComponent implements OnInit {
  username = 'kaskata';
  wins = 0;

  constructor(
    private  playerService: PlayerService
  ) {}

  ngOnInit() {
    // this.playerService.getPlayer(1);
  }
}
