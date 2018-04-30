import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {
  MatButtonModule
} from '@angular/material';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {
  SocialLoginModule,
  AuthServiceConfig,
  GoogleLoginProvider,
} from 'angular5-social-login';

import { AppComponent } from './app.component';
import { AuthHandlerComponent } from './auth-handler/auth-handler.component';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { AuthRegisterComponent } from './auth-register/auth-register.component';
import {MatInputModule} from '@angular/material/input';
import { PlayerProfileComponent } from './player-profile/player-profile.component';
import { PlayerHomeComponent } from './player-home/player-home.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { QuestionComponent } from './question/question.component';
import { EndGameComponent } from './end-game/end-game.component';
import { LobyComponent } from './loby/loby.component';
import {AppRoutingModule} from './app-routing.module';
import { GameComponent } from './game/game.component';

export function getAuthServiceConfigs() {
  const config = new AuthServiceConfig(
    [
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider('581304647757-j4kg7mva8s27jpfhlddjot016geaov01.apps.googleusercontent.com')
      }
    ]);
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    AuthHandlerComponent,
    AuthLoginComponent,
    AuthRegisterComponent,
    PlayerProfileComponent,
    PlayerHomeComponent,
    LeaderboardComponent,
    QuestionComponent,
    EndGameComponent,
    LobyComponent,
    GameComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    SocialLoginModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    {provide: AuthServiceConfig, useFactory: getAuthServiceConfigs}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
