<template>
  <section >
    <h4 style="text-align: center">ПОПУЛЯРНО</h4>
    <p>Carousel ===== >>>>{{services.size}}</p>
    <carousel :per-page="4" :navigationEnabled="true"
              navigationNextLabel="<i class='fas fa-chevron-right' style='font-size: 25pt; color:white'></i>"
              navigationPrevLabel="<i class='fas fa-chevron-left'  style='font-size: 25pt; color:white'></i>"
              :paginationPadding=1
              style="padding-left: 50px; padding-right: 50px">
      <slide v-for="(service, index) in services" :key="index" style="width: 100px">
        <p>Carousel ===== >>>>{{service.image}}</p>
        <a href="/zhidkosti-omyvatelja-stekla/">
          <div class="icon"><img v-bind:src="service.image" alt=""></div>
          <strong>{{service.title}}</strong>
          <div
            style="overflow: hidden; text-overflow: ellipsis; -webkit-box-orient: vertical; display: -webkit-box; -webkit-line-clamp: 3;">
            <span>{{service.description}}</span>
          <span>================================</span></div>
        </a>
      </slide>
      <slide><part/></slide>
      <slide><part/></slide>
      <slide><part/></slide>
      <slide><part/></slide>
      <slide><part/></slide>
    </carousel>
  </section>
</template>

<script>
import {Carousel, Slide} from 'vue-carousel'
import axios from 'axios'
import part from './part.vue'

export default {
  name: 'sales-slider',
  data: function () {
    return {
      services: []
    }
  },
  created () {
    axios.get('/api/popular').then(response => (this.services = response.data))
  },
  components: {
    Carousel,
    Slide,
    part
  }
}
</script>

<style scoped>

</style>
