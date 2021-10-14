
export default {
  methods: {
    removeFromCart: function (item) {
      this.$store.commit('removeFromCart', item)
    },
    addToCart: function (entry) {
      console.log('entry which added to cart from button pushing:' + entry)
      var cartEntry = {
        id: entry.id,
        name: entry.name,
        code: entry.code,
        trademark: entry.trademark.description,
        price: '0,00',
        quantity: 1
      }
      return this.$store.commit('addToCart', cartEntry)
    }
  }
}
