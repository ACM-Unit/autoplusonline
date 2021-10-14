<template>
    <ul class="custom-menu" v-if="$store.state.cart.length > 0">
        <div id="shopping-cart">
            <div class="shopping-cart-list">
                <div class="product product-widget" v-for="part in $store.state.cart" :key="part.id">
                    <div class="product-thumb">
                        <img :src="'/static/img/categoties/'+part.parent+'.png'" alt="">
                    </div>
                    <div class="product-body">
                        <span><a href="#">{{ part.name }} x{{ part.quantity }} - ${{ part.totalPrice }}</a></span>
                        <span>{{part.code}} </span>
                        <span> {{part.trademark.description}}</span>
                    </div>
                    <button class="cancel-btn" @click.prevent="removeFromCart(part)"><i class="fa fa-trash"></i>
                    </button>
                </div>
            </div>
            <div class="shopping-cart-btns">
                <button class="main-btn">View Cart</button>
                <button class="primary-btn">Checkout <i class="fa fa-arrow-circle-right"></i></button>
            </div>
        </div>
    </ul>
</template>

<script>
export default {
  name: 'cart',
  computed: {
    totalPrice () {
      let total = 0

      for (let item of this.$store.state.cart) {
        total += item.totalPrice
      }

      return total.toFixed(2)
    }
  },
  methods: {
    removeFromCart (item) {
      this.$store.commit('removeFromCart', item)
    }
  }
}
</script>

<style scoped>

</style>
