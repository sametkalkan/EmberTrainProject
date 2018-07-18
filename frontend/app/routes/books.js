import Route from '@ember/routing/route';

export default Route.extend({
  queryParams: {
    query: {
      replace: true
    }
  },

  model(){
    //return this.get('ajax').request('http://localhost:8080/books');
    return this.store.findAll('book');
  },


});
