import Route from '@ember/routing/route';

export default Route.extend({

  actions:{

    showHome(){
      window.location.href = '/home';
    },
    showBooks(){
      window.location.href = '/books';
    },
    showContact(){
      window.location.href = '/contact';
    }

  }

});
