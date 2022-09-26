import { TestBed } from '@angular/core/testing';

import { CurdHttpService } from './curd-http.service';

describe('CurdHttpService', () => {
  let service: CurdHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurdHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
