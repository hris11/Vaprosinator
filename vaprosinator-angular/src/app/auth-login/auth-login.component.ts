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
        this.playerService.createPlayer(player).subscribe(data => {
          this.route.navigate(['player', data.id]);
        });
      }
    );
  }
}
