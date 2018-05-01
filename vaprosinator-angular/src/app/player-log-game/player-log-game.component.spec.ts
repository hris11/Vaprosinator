import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerLogGameComponent } from './player-log-game.component';

describe('PlayerLogGameComponent', () => {
  let component: PlayerLogGameComponent;
  let fixture: ComponentFixture<PlayerLogGameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerLogGameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerLogGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
