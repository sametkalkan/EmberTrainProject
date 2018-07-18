import Controller from '@ember/controller';
import EmberObject from '@ember/object';

export default Controller.extend({
  queryParams: ['query'],
  query: '',
  data:EmberObject.create(),

    actions: {
      addBook() {
        let self = this;
        self.transitionToRoute("addbook");
      },
      update(id) {
        console.log(id+"***");
        let self = this;
        self.transitionToRoute("/update/" + id);
      },
      delete(id) {
        let self = this;
        Ember.$.ajax({
            url: `http://localhost:8080/delete/${id}`,
            type: "DELETE",
            headers: {
                'Content-Type': 'application/json'
              }
          }).then(function(resp){
            console.log("successful");
            window.location.reload(true);
          }).catch(function(error){
            console.log(error);
            console.log("negative");
          });

      },
      sorgula(kriter){
        var myURL = ""
        if(kriter === "")
          myURL = 'http://localhost:8080/books';
        else {
          myURL = 'http://localhost:8080/books/title' + kriter;
        }
        Ember.$.ajax({
          url:myURL,
          type:"GET",
          headers: {
              'Content-Type': 'application/json'
            }
        }).then((resp)=>{
            this.set('data', resp);
        })
      }
    }
});
