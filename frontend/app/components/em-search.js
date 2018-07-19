import Component from '@ember/component';
import EmberObject from '@ember/object';

export default Component.extend({
  query:"",
  actions: {
    keyPress() {
      console.log("keyPress");
      this.sendAction('sorgula', this.get('query'));
    }
  }
});
