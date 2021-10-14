
export default {
  name: 'RenderString',
  props: {
    string: {
      required: true,
      type: String
    }
  },
  render (h) {
    const render = {
      template: '<div>' + this.string + '</div>',
      methods: {
        markComplete () {
          console.log('the method called')
        }
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
    return h(render)
  }
}
