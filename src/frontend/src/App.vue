<template>
  <div id="app">
    <router-view :key="$route.fullPath"/>
  </div>
</template>

<script>

import Vue from 'vue'
import Axios from 'axios'
import store from './store'

export default {
  name: 'App',
  beforeCreate () {
    this.$store.commit('initialiseStore')
    this.$store.commit('getCategories')
    Vue.prototype.$http = Axios
    const token = store.state.user.token
    console.log('token ' + token)
    if (token) {
      Vue.prototype.$http.defaults.headers.common['Authorization'] = token
    }
  }
}
</script>
