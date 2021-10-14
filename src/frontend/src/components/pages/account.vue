<template>
    <div id="account">
        <Header/>
        <div class="redline"></div>
        <Navigation/>
        <div class="container">
<div class="col-lg-12">
    <div class="row">
    <div class="col-lg-4"><Account/></div>
        <div class="col-lg-8"></div>
    </div>
</div>
        </div>
        <Footer/>
    </div>
</template>

<script>
import Header from '../header'
import Navigation from '../navigation'
import Account from '../account'
import Footer from '../footer'

export default ({
  name: 'Account',
  data: function () {
    return {}
  },
  components: {
    Header,
    Account,
    Navigation,
    Footer
  }
})
</script>

<style scoped>

</style>
