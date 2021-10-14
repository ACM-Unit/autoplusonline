<template>
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="product product-single">
      <div class="product-thumb">
        <div class="product-label">
          <span class="sale">-20%</span>
        </div>
        <button class="main-btn quick-view"><i class="fa fa-heart"></i></button>
        <img src="../../static/img/product04.jpg" alt="">
      </div>
      <div class="product-body">
        <h3 class="product-price">$32.50 <del class="product-old-price">$45.00</del></h3>
        <div class="product-rating">
          <i class="fa fa-star"></i>
          <i class="fa fa-star"></i>
          <i class="fa fa-star"></i>
          <i class="fa fa-star"></i>
          <i class="fa fa-star-o empty"></i>
        </div>
        <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
        <div class="product-btns">
          <button class="primary-btn add-to-cart"><i class="fa fa-shopping-cart"></i>add to cart</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'part'
}
</script>

<style scoped>

</style>
