import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { PlayerHomeComponent } from './player-home/player-home.component';
import {GameComponent} from './game/game.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { PlayerLogComponent } from './player-log/player-log.component';
import { QuestionComponent } from './question/question.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: AuthLoginComponent},
  {path: 'player', component: PlayerHomeComponent},
  {path: 'game/:playerId', component: GameComponent},
  {path: 'player/:playerId', component: PlayerHomeComponent},
  {path: 'player/:playerId/gamelog', component: PlayerLogComponent},
  {path: 'leaderboard', component: LeaderboardComponent},
  {path: 'create-question/:playerId', component: QuestionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
