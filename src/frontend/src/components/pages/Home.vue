<template>
  <div id="home">
    <Header/>
    <Navigation/>
    <Footer/>
  </div>
</template>

<script>
import Header from '../header'
import Navigation from '../navigation'
import Footer from '../footer'

export default ({
  name: 'App',
  data: function () {
    return {
    }
  },
  components: {
    Header,
    Navigation,
    Footer
  }
})
</script>
