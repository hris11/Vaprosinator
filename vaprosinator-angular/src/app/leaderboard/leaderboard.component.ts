import { Component, OnInit } from '@angular/core';
import { PlayerService, Player } from '../services/player/player.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css'],
  providers: [PlayerService]
})
export class LeaderboardComponent implements OnInit {

  players: Player[];

  constructor(
    private playerService: PlayerService
  ) { }

  ngOnInit() {
    this.getLeaderBoard()
  }

  getLeaderBoard() {
    this.playerService.getLeaderBoard()
      .subscribe(data => {
        this.players = data;
        console.log(data);
      });
  }
}
