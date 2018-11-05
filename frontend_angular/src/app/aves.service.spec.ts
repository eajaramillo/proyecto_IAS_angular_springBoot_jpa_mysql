import { TestBed, inject } from '@angular/core/testing';

import { AvesService } from './aves.service';

describe('AvesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AvesService]
    });
  });

  it('should be created', inject([AvesService], (service: AvesService) => {
    expect(service).toBeTruthy();
  }));
});
