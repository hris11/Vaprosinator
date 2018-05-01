import { Component, OnInit } from '@angular/core';
import { PlayerService, Game } from '../services/player/player.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-player-log',
  templateUrl: './player-log.component.html',
  styleUrls: ['./player-log.component.css'],
  providers: [PlayerService]
})
export class PlayerLogComponent implements OnInit {
  private sub: any;
  private playerId;
  progressSpinner = true;
  game: Game[];

  constructor(
    private  playerService: PlayerService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.playerId = +params['playerId'];
    });
    /*this.getPlayerLogIngormation().then(() => {
      this.progressSpinner = false;
    });*/
    this.getPlayerLogIngormation();
  }

  getPlayerLogIngormation() {
    this.playerService.getPlayerGameLog(this.playerId)
    .subscribe(data => {
      this.game = data;
      console.log(data);
    });
  }
}
