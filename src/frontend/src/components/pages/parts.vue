<template>
    <div id="home">
        <Header/>
        <div class="redline"></div>
        <Navigation/>
        <div class="container">
            <SubCategory/>
            <PartTable/>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../header'
import Navigation from '../navigation'
import SubCategory from '../subCategory'
import PartTable from '../partTable'
import Footer from '../footer'

export default ({
  name: 'App',
  data: function () {
    return {}
  },
  components: {
    Header,
    Navigation,
    PartTable,
    SubCategory,
    Footer
  }
})
</script>
