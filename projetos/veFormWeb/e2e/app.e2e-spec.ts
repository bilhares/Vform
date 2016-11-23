import { VeFormWebPage } from './app.po';

describe('ve-form-web App', function() {
  let page: VeFormWebPage;

  beforeEach(() => {
    page = new VeFormWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
