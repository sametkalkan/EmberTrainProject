import Controller from '@ember/controller';

export default Controller.extend({

  actions: {
    addBook(){
      let self = this;
      self.transitionToRoute("addbook");
    },
    update(id){
      let self = this;
      self.transitionToRoute("/update/" + id);
    },
    delete(id){
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

    }
  }
});
