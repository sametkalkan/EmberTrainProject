import Component from '@ember/component';
import EmberObject from '@ember/object';

export default Component.extend({
  query:"",
  actions: {
    keyPress() {
      this.sendAction('queryByTitle', this.get('query'));
    }
  }
});
