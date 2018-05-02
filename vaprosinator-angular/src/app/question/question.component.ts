import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {QuestionAndTopicService, Topic, Question, Answer} from '../services/question-and-topic/question-and-topic.service'


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css'],
  providers: [QuestionAndTopicService]
})
export class QuestionComponent implements OnInit {

  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  question;
  answers: Answer[] = [
    {},
    {},
    {}
  ];
  correctAnswer;
  topics: Topic[];
  topic;
  private playerId;
  private sub: any;

  constructor(private _formBuilder: FormBuilder,
    private _route: ActivatedRoute,
    private _questionAndTopicService: QuestionAndTopicService
  ) { }

  ngOnInit() {
    console.log(this.answers[0]);
    this.sub = this._route.params.subscribe(params => {
      this.playerId = +params['playerId'];
    });
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

    this._questionAndTopicService.getTopics().subscribe(
      data => {
        this.topics = data;
    });
  }

  createQuestion() {
    console.log(this.correctAnswer);
    this.answers[this.correctAnswer].correct = true;
    const question: Question = {
      creatorId: this.playerId,
      question: this.question,
      answers: this.answers,
      topicId: this.topic.id
    };
    this._questionAndTopicService.createQuestion(question).subscribe(
      data => {
        console.log(data);
      }
    );
  }

}
