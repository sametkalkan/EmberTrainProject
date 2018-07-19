import Controller from '@ember/controller';
import EmberObject from '@ember/object';

export default Controller.extend({
    queryParams: ['query'],
    query: '',
    data:EmberObject.create(),

    init(){
      this.set('data', this.send('queryByTitle', ''));
    },

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

      delete(book) {
        if(confirm('You are about to delete "' + book.title + "\"\n\nAre you sure?")){
          let self = this;
          Ember.$.ajax({
              url: `http://localhost:8080/delete/${book.id}`,
              type: "DELETE",
              headers: {
                  'Content-Type': 'application/json'
                }
            }).then(function(resp){
              window.location.reload(true);
            }).catch(function(error){
            });
        }


      },
      queryByTitle(query){
        var myURL = ""
        if(query === "")
          myURL = 'http://localhost:8080/books';
        else {
          myURL = 'http://localhost:8080/books/title/' + query;
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
