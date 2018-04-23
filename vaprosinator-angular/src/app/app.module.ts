import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {
  MatButtonModule
} from '@angular/material';


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
    LobyComponent
  ],
  imports: [
    BrowserModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
