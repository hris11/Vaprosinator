import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';


@Injectable()
export class QuestionAndTopicService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(private http: HttpClient) {
  }

  // topics
  getTopic(topicId) {
    return this.http.get<Topic>(environment.baseUrl + `topic/${topicId}`);
  }

  getTopics() {
    return this.http.get<Topic[]>(environment.baseUrl + 'topic');
  }

  createTopic(topic) {
    return this.http.post<Topic>(environment.baseUrl + 'topic', JSON.stringify(topic), this.httpOptions);
  }

  // question
  getQuestion(questionId) {
    return this.http.get<Question>(environment.baseUrl + `question/${questionId}`);
  }

  getQuestions() {
    return this.http.get<Question[]>(environment.baseUrl + `question`);
  }

  createQuestion(question) {
    return this.http.post<Question>(environment.baseUrl + 'question', JSON.stringify(question), this.httpOptions);
  }
}


export interface Topic {
  id;
  information;
  questions;
}

export interface Question {
  id?;
  creatorId;
  question;
  answers;
  topicId;
}

export interface Answer {
  id?;
  questionId?;
  content?;
  correct?;
}
