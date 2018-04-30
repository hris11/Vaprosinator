import { Component, OnInit } from '@angular/core';
import {
  AuthService,
  GoogleLoginProvider
} from 'angular5-social-login';
import {ActivatedRoute, Router} from '@angular/router';
import { PlayerService } from '../services/player/player.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './auth-login.component.html',
  styleUrls: ['./auth-login.component.css'],
  providers: [PlayerService]
})
export class AuthLoginComponent implements OnInit {

  inputNickname = false;
  private playerId;
  private nickname;

  constructor( private socialAuthService: AuthService, private route: Router,   private  playerService: PlayerService) {}

  ngOnInit() {}

  public socialSignIn(socialPlatform: string) {
    let socialPlatformProvider;
    if (socialPlatform === 'google') {
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }

    this.socialAuthService.signIn(socialPlatformProvider).then(
      (userData) => {
        const player = {'email': userData.email};
        console.log(socialPlatform + ' sign in data : ' , userData);
        // Now sign-in with userData
        this.playerService.createPlayer(player).subscribe(
          data => {
            this.playerId = data.id;
            if (data.nickname === null) {
             this.inputNickname = true;
            } else {
              this.navigate();
            }
          }
      );
      }
    );
  }

  navigate() {
    this.route.navigate(['player', this.playerId]);
  }
  setUserName() {
    this.playerService.setNickname(this.playerId, this.nickname).subscribe(
      data => {
        this.navigate();
      });
  }
}
