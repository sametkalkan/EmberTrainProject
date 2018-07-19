import Route from '@ember/routing/route';

export default Route.extend({
  queryParams: {
    query: {
      replace: true
    }
  },
/*
  init(){
    this._super();
    console.log("init");
    this.send("initSorgula");
  },

  actions:{
    initSorgula(){
      console.log("d");
      this.send("sorgula", "");
    }
  }*/
});
