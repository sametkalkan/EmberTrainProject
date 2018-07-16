import Controller from '@ember/controller';

export default Controller.extend({
  needs: ['application'],
  init: function() {
    alert('Current route is ' + this.get('controllers.application.currentPath'));
    this._super();
  }
});
