import { Component, OnInit } from '@angular/core';
import { PlayerService, Player } from '../services/player/player.service';
import {ActivatedRoute, Router} from '@angular/router';

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
  progressSpinner = true;
  constructor(
    private  playerService: PlayerService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.playerId = +params['playerId'];
    });
    this.getPlayer().then(() => {
      this.progressSpinner = false;
    });
  }

  startGame() {
    this.router.navigate(['game', this.playerId])
  }

  getPlayer() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        this.playerService.getPlayer(this.playerId)
        .subscribe(data => {
          this.player = data;
          console.log(data);
          resolve();
        });
      });
    });
  }
}
