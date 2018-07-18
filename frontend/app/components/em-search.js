import Component from '@ember/component';
import EmberObject from '@ember/object';

export default Component.extend({
  query:"",
  actions: {
    keyPres() {
      console.log(this.get('query'));
      this.sendAction('sorgula', this.get('query'));
    }
  }
});
