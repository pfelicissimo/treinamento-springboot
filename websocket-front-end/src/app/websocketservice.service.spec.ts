import { TestBed } from '@angular/core/testing';

import { WebsocketserviceService } from './websocketservice.service';

describe('WebsocketserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WebsocketserviceService = TestBed.get(WebsocketserviceService);
    expect(service).toBeTruthy();
  });
});
