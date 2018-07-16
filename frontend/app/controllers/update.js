import Controller from '@ember/controller';

export default Controller.extend({
  actions:{
    update(bookid){
      let self = this;
      Ember.$.ajax({
          url: 'http://localhost:8080/update',
          type: "POST",
          data: JSON.stringify({
              id: bookid,
              isbn: this.get('model.isbn'),
              title: this.get('model.title'),
              publisher: this.get('model.publisher'),
              author: this.get('model.author'),
              category: this.get('model.category'),
              publishDate:  this.get('model.publishDate'),
              npage:  this.get('model.npage'),
          }),
          contentType: "application/json",
        }).then(function(resp){
            console.log("success");
            window.location.href = '/books'
        }).catch(function(error){
          console.log("negative");
        });

    }
  }
});
