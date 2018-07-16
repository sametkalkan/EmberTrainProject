import DS from 'ember-data';

export default DS.RESTSerializer.extend({
  normalizeResponse(store, primaryModelClass, payload, id, requestType) {
    payload = {books:payload};
    return this._super(store, primaryModelClass, payload, id, requestType);
  },
  serialize(snapshot, options) {
    return this._super(snapshot, options);

  },
});
