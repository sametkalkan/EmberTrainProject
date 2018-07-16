import DS from 'ember-data';

export default DS.Model.extend({
  isbn: DS.attr(),
  title: DS.attr(),
  author: DS.attr(),
  category: DS.attr(),
  publisher: DS.attr(),
  publishDate: DS.attr(),
  npage: DS.attr()
});
