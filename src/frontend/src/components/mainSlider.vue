<template>
    <div id="main-slider">
        <carousel :per-page="1" :navigationEnabled="true"
                  navigationNextLabel="<i class='fas fa-chevron-right' style='margin-left:-60px; font-size: 25pt; color:#0756a5'; z-index: 10></i>"
                  navigationPrevLabel="<i class='fas fa-chevron-left'  style='margin-right:-60px; font-size: 25pt; color:#0756a5; z-index: 10'></i>"
                  :paginationEnabled=false
                  :autoplay="true"
                  :autoplayTimeout=6000
                  :loop="true">
            <slide v-for="(banner, index) in banners" :key="index">
                <div class="banner banner-1">
                    <img v-bind:src="banner.image" alt="">
                    <div class="banner-caption text-center">
                        <h1>{{banner.textH}}</h1>
                        <h3 class="white-color font-weak">{{banner.text}}</h3>
                        <button class="primary-btn">{{banner.button}}</button>
                    </div>
                </div>
            </slide>
        </carousel>
    </div>
</template>

<script>
import {Carousel, Slide} from 'vue-carousel'

var banners = [
  {
    image: '../../static/img/banner01.jpg',
    textH: 'Car service',
    text: 'Up to 50% Discount',
    button: 'Shop Now'
  },
  {
    image: '../../static/img/banner02.jpg',
    textH: 'HOT DEAL',
    text: 'Up to 50% OFF',
    button: 'Shop Now'
  },
  {
    image: '../../static/img/banner03.jpg',
    textH: 'New Product',
    text: 'Collection',
    button: 'Shop Now'
  }]
export default ({
  name: 'main-slider',
  data: function () {
    return {
      banners
    }
  },
  created () {
  },
  components: {
    Carousel,
    Slide
  }
})
</script>
