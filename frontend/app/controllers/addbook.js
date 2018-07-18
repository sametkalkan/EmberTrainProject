import Controller from '@ember/controller';

export default Controller.extend({
  actions:{
    add(){
      let self = this;
      Ember.$.ajax({
          url: 'http://localhost:8080/create',
          type: "POST",
          data: JSON.stringify({
              isbn: self.get('isbn'),
              title: self.get('title'),
              publisher: self.get('publisher'),
              author: self.get('author'),
              category: self.get('category'),
              publishDate: self.get('publishDate'),
              npage: self.get('npage')
          }),
          headers: {
              'Content-Type': 'application/json'
            }
        }).then(function(resp){
          console.log(resp);
          self.transitionToRoute("books");
        }).catch(function(error){
          alert(error.responseText)
          self.set("errorr", error.responseText);
          console.log(self.get("errorr"));
          console.log("negative");
        });
    }
  }
});
