<template>
  <section>
    <h4 style="text-align: center">КАТАЛОГ</h4>
    <section v-for="category in $store.state.categories" :key="category.id">
      <div class="row">
        <img class="col-md-1" v-bind:src="'/static/img/categoties'+category.reference+category.id+'.png'" alt="" style="    height: 28px;
    margin-left: 65px;
    max-width: 60px;">
        <div class="col-md-9" style="color:white;text-align:center;    background: linear-gradient(0.25turn, #0756a5, lightgrey); font-size: 20px;vertical-align: middle; margin-bottom: 20px; padding-bottom: 0}">{{category.title}}</div>
       </div>
      <div class="col-md-12 col-sm-12 col-xs-12">
          <carousel :per-page="6" :navigationEnabled="true"
                    navigationNextLabel="<i class='fas fa-chevron-right' style='margin-left:-100px; margin-bottom: 40px; font-size: 15pt; color:gray'></i>"
                    navigationPrevLabel="<i class='fas fa-chevron-left'  style='margin-right:-80px; margin-bottom: 40px; font-size: 15pt; color:gray'></i>"
                    :paginationEnabled="false"
                    style="padding-left: 50px; padding-right: 50px">
            <slide v-for="cat in category.children" :key="cat.id"><div style="width: 90%">
              <div><img :src="'/static/img/categoties'+cat.reference+cat.id+'.png'" style="width: 100%;"/></div>
              <router-link :to="{path: '/catalog' + cat.reference}">
                <strong>{{cat.title}}</strong>
              </router-link>
              </div>
            </slide>
          </carousel>
        </div>
    </section>
  </section>
</template>

<script>
import {Carousel, Slide} from 'vue-carousel'
export default {
  name: 'catalog',
  created () {
  },
  mounted () {
  },
  components: {
    Carousel,
    Slide
  }
}
</script>

<style scoped>

</style>
