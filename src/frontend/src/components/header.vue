<template>
  <header>
    <div id="top-header">
      <div class="container container-fluid">
        <div class="pull-left">
          <span>Welcome to Auto Plus service!</span>
        </div>
        <div class="pull-right">
          <ul class="header-top-links">
            <li class="header-car dropdown default-dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <div class="header-btns-icon">
                  <i class="fa fa-car"></i>
                </div>
              </a>
              <div class="custom-menu">

              </div>
            </li>
            <li class="header-car dropdown default-dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <div class="header-btns-icon" >
                  <i style="color: #0756a5" class="fa fa-user"></i>
                </div>
              </a>
              <ul class="custom-menu">
                <li v-if="isLoggedIn"><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                <li v-if="!isLoggedIn"><a href="#" role="button" @click="onShow('rotate')"><i class="fa fa-unlock-alt"></i> Login</a></li>
                <li v-if="!isLoggedIn"><a href="#" role="button" @click="regShow('rotate')"><i class="fa fa-user-plus"></i> Create An Account</a></li>
                <li v-if="isLoggedIn"><a href="#" role="button" @click="logout()"><i class="fa fa-sign-out"></i> Logout</a></li>
              </ul>
            </li>
            <li v-if="isLoggedIn" class="header-account dropdown default-dropdown">
              {{$store.state.user.username}}
            </li>
            <li class="header-cart dropdown default-dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <div class="header-btns-icon">
                  <i class="fa fa-shopping-cart"></i>
                  <span class="qty">{{ $store.state.cartCount }}</span>
                </div>
              </a>
              <cartTag/>
            </li>
           <!-- <li class="dropdown default-dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">ENG <i class="fa fa-caret-down"></i></a>
              <ul class="custom-menu">
                <li><a href="#">English (ENG)</a></li>
                <li><a href="#">Russian (Ru)</a></li>
              </ul>
            </li>-->
            <li class="dropdown default-dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">USD <i class="fa fa-caret-down"></i></a>
              <ul class="custom-menu">
                <li><a href="#">USD ($)</a></li>
                <li><a href="#">UAH (€)</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div id="header">
      <div class="container container-fluid">
        <div class="pull-left">
          <!-- Logo -->
          <div class="header-logo">
            <router-link :to="{path: '/'}">
              <img src="/static/img/logodealer.png" alt="">
            </router-link>
          </div>
        </div>
        <div class="pull-right">
          <ul class="header-btns">
            <div class="header-search">
              <form>
                <input class="input search-input" type="text" placeholder="поиск" v-model="place"/>
                <select class="input search-categories" v-model="selectedCategory">
                  <option value="0">All Categories</option>
                  <option v-for="category in $store.state.categories" v-bind:key="category.title" v-bind:value="category.reference">{{category.title}}</option>
                </select>
                <button class="search-btn"><router-link :to="{path: '/catalog' + selectedCategory, query: {filter: place }}"><i class="fa fa-search"></i></router-link></button>
              </form>
            </div>
            <!-- Mobile nav toggle-->
            <li class="nav-toggle">
              <button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
            </li>
            <!-- / Mobile nav toggle -->
          </ul>
        </div>
      </div>
      <!-- header -->
    </div>
    <!-- container -->
<loginmodal ref="loginmodal"/>
    <regmodal ref="regmodal"/>
  </header>

</template>
<script>
import cartTag from './cart'
import loginmodal from './login-modal'
import regmodal from './reg-modal'

var cart = []
var categories1 = []
var subcategories1 = []
export default ({
  name: 'App',
  data: function () {
    return {
      username: '',
      password: '',
      selectedCategory: '',
      place: '',
      error: '',
      categories1,
      subcategories1,
      cart,
      show: false,
      animation: '',
      paddingTop: `paddingTop: ${(window.innerHeight - 440) / 2}px`,
      types: ['zoom', 'fade', 'flip', 'door', 'rotate', 'slideUp', 'slideDown', 'slideLeft', 'slideRight']
    }
  },
  created () {
  },
  methods: {
    delay (index) {
      return `
        animationDelay: ${index * 100}ms;
        WebkitAnimationDelay: ${index * 100}ms;
      `
    },
    onShow: function () {
      this.$refs.loginmodal.onShow('rotate')
    },
    regShow: function () {
      this.$refs.regmodal.onShow('rotate')
    },
    logout: function () {
      this.$store.dispatch('logout')
        .then(() => {
          this.$router.push('/')
        })
    }
  },
  components: {
    loginmodal,
    regmodal,
    cartTag: cartTag
  },
  computed: {
    isLoggedIn: function () { return this.$store.getters.isLoggedIn },
    authStatus: function () { return this.$store.getters.authStatus }
  }
})

</script>
