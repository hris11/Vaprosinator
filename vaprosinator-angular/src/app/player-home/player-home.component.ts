import { Component, OnInit } from '@angular/core';
import { PlayerService, Player } from '../services/player/player.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-player-home',
  templateUrl: './player-home.component.html',
  styleUrls: ['./player-home.component.css'],
  providers: [PlayerService]
})
export class PlayerHomeComponent implements OnInit {
  private sub: any;
  player: Player;
  private playerId;

  constructor(
    private  playerService: PlayerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.playerId = +params['playerId'];
      console.log(this.playerId);
    });
    this.playerService.getPlayer(this.playerId).subscribe(data => {
      this.player = data;
      console.log(data);
    });
  }
}
