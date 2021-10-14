<template>
    <section>
        <div class="row">
        <img  class="subcategoryimg col-md-4" :src="'/static/img/categoties'+subCategory.reference+subCategory.id+'.png'"/>
            <div class = "col-md-8"><div class="subcategory">
            <span>{{subCategory.title}}</span>
        </div>
                <div class="subcategoryred"></div>
        </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <carousel :per-page="8" :navigationEnabled="true"
                          navigationNextLabel="<i class='fas fa-chevron-right' style='margin-left:-100px; margin-bottom: 40px; font-size: 15pt; color:gray'></i>"
                          navigationPrevLabel="<i class='fas fa-chevron-left'  style='margin-right:-80px; margin-bottom: 40px; font-size: 15pt; color:gray'></i>"
                          :paginationEnabled="false"
                          style="padding-left: 50px; padding-right: 50px">
                    <slide v-for="cat in subCategory.children" :key="cat.id"><div style="width: 90%">
                        <div><img :src="'/static/img/categoties'+cat.reference+cat.id+'.png'" style="width: 100%;"/></div>
                        <router-link :to="{path: '/catalog' + cat.reference}">
                            <strong>{{cat.title}}</strong>
                        </router-link>
                    </div>
                    </slide>
                </carousel>
            </div>
        </div>
    </section>
</template>

<script>
import {Carousel, Slide} from 'vue-carousel'
import axios from 'axios'
var subCategory = {}
export default {
  name: 'catalog',
  data: function () {
    return {
      subCategory
    }
  },
  created () {
  },
  mounted () {
    axios
      .get('/api/category/findby/' + this.$route.params.reference)
      .then(response => (this.subCategory = response.data))
  },
  components: {
    Carousel,
    Slide
  }
}
</script>

<style scoped>

</style>
