import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-player-log-game',
  templateUrl: './player-log-game.component.html',
  styleUrls: ['./player-log-game.component.css']
})
export class PlayerLogGameComponent implements OnInit {

  @Input() finishDate: null;
  @Input()answeredQuestions: null;
  @Input() mistakenQuestions: null;
  @Input() won: null;

  constructor() { }

  ngOnInit() {
  }

}
