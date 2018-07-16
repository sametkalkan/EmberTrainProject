import Controller from '@ember/controller';

export default Controller.extend({
  actions:{
    delete(book){
      let self = this;
      console.log(book.id);
      Ember.$.ajax({
          url: `http://localhost:8080/delete/${book.id}`,
          type: "DELETE",
          headers: {
              'Content-Type': 'application/json'
            }
        }).then(function(resp){
          window.location.href = '/books'
        }).catch(function(error){
          console.log("negative");
        });
    }

  }
});
