import { TestBed } from '@angular/core/testing';

import { Techicr7Service } from './techicr7.service';

describe('Techicr7Service', () => {
  let service: Techicr7Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Techicr7Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
