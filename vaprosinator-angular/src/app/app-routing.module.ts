import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { PlayerHomeComponent } from './player-home/player-home.component';
import {GameComponent} from "./game/game.component";

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: AuthLoginComponent},
  {path: 'player', component: PlayerHomeComponent},
  {path: 'game', component: GameComponent},
  {path: 'player/:playerId', component: PlayerHomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
