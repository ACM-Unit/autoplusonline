<template>
  <ul class="category-list open" style="z-index: initial" ref="el">
      <li v-for="(category, index) in $store.state.categories" v-bind:key="index" class="dropdown side-dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
          <img v-bind:src="'/static/img/categoties'+category.reference+category.id+'.png'" alt="" style="height: 30px">
          <div style="display: inline-block">{{category.title}}</div>
          <i class="fa fa-angle-right"></i></a>
        <div v-bind:class="['custom-menu side-bar-3']" >
          <div class="row">
            <div v-bind:class="['col-md-3']" v-for="(cat, index) in category.children"
                 v-bind:key="index"    v-if="category.children.size !== 0 & index<4">
              <ul class="list-links" style="height:200px; overflow: hidden;">
                <li>
                  <h5 class="list-links-title">{{cat.title}}</h5></li>
                <li v-for="(cell, index) in cat.children" v-bind:key="index">
                  <router-link :to="{path: '/catalog' + cell.reference}">{{cell.title}}</router-link>
                </li>
              </ul>
                <router-link :to="{path: '/catalog' + cat.reference}">-----view all-----</router-link>
                <div class="col-md-12">
                  <hr>
                  <a class="banner banner-1" href="#">
                    <img v-bind:src="'/static/img/categoties'+cat.reference+cat.id+'.png'" alt="">
                  </a>
                </div>
            </div>
          </div>
        </div>
      </li>
    <li class="reg-service">
      <div class="modal-header">
        <h4 class="modal-title">Запись на ТО</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <label class="label" for="usr">Имя:</label>
          <input type="text" class="form-control" placeholder="имя" id="usr">
        </div>
        <div class="form-group">
          <label class="label">Телефон:</label>
          <maskedInput id="tel" class="form-control" v-model="phone" mask="\+\3\8 (\011) 111-1111"
                       placeholder="телефон" type="tel"/>
        </div>
        <div class="form-group">
          <label class="label" for="eml">e-mail:</label>
          <input type="email" class="form-control" placeholder="почта" id="eml">
        </div>
        <div class="form-group">
          <label class="label"></label>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">записаться</button>
      </div>
    </li>
    </ul>
</template>

<script>
import maskedInput from 'vue-masked-input'
var allCategories = []
export default {
  name: 'side-menu',
  data: function () {
    return {
      allCategories,
      phone: ''
    }
  },
  mounted () {
  },
  components: {maskedInput}
}

</script>

<style scoped>

</style>
