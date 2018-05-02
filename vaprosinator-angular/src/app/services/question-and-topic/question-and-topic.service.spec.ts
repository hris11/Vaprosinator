import { TestBed, inject } from '@angular/core/testing';

import { QuestionAndTopicService } from './question-and-topic.service';

describe('QuestionAndTopicService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuestionAndTopicService]
    });
  });

  it('should be created', inject([QuestionAndTopicService], (service: QuestionAndTopicService) => {
    expect(service).toBeTruthy();
  }));
});
