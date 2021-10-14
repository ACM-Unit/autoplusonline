<template>
  <div id="main">
    <Header/>
    <div class="redline"></div>
    <Navigation/>
    <div class="container">
      <div id="sidemenu" v-if="window.width>991">
        <SideMenu v-if="window.width>991"/>
      </div>
      <div id="content">
        <Slider/>
        <SelectCar/>
        <Catalog/>
      </div>
    </div>
    <div class="redline"></div>
    <Footer/>
  </div>
</template>

<script>
import Header from '../header'
import Navigation from '../navigation'
import Slider from '../mainSlider'
import Footer from '../footer'
import SelectCar from '../select-car'
import SideMenu from '../sideMenu'
import Catalog from '../catalog.vue'
import PartTable from '../partTable.vue'
export default ({
  name: 'App',
  data: function () {
    return {
      window: {
        width: 0,
        height: 0
      }
    }
  },
  created () {
    window.addEventListener('resize', this.handleResize)
    this.handleResize()
  },
  destroyed () {
    window.removeEventListener('resize', this.handleResize)
  },
  methods: {
    handleResize () {
      this.window.width = window.innerWidth
      this.window.height = window.innerHeight
    }
  },
  components: {
    Header,
    Navigation,
    Slider,
    Footer,
    SelectCar,
    SideMenu,
    Catalog,
    PartTable
  }
})
</script>
