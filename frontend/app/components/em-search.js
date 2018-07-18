import Component from '@ember/component';

export default Component.extend({
  ajax: Ember.inject.service(),

  actions: {
    keyPres() {
      var value = this.get('query');
      var model = this.get('ajax').request('http://localhost:8080/books/title/' + value);
      console.log(model);
      this.set('filtered', model);

    }
  }
});
