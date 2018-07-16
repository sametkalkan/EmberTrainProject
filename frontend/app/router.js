import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('/');
  this.route('books');
  this.route('index');
  this.route('addbook');
  this.route('viewbook', { path: "viewbook/:id" });
  this.route('update', { path: "update/:id" });
  this.route('home');
  this.route('contact');
  this.route('about');
});

export default Router;
