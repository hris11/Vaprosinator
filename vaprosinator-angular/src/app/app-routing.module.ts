import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthLoginComponent } from './auth-login/auth-login.component';
import { PlayerHomeComponent } from './player-home/player-home.component';
import {GameComponent} from "./game/game.component";

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: AuthLoginComponent},
<<<<<<< HEAD
  {path: 'player', component: PlayerHomeComponent},
  {path: 'game', component: GameComponent},
=======
  {path: 'player/:playerId', component: PlayerHomeComponent}
>>>>>>> 3f32f933e12b6eca25e2faa292a96de7b1aa98e9
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
