<template>
  <div id="navigation">
    <div class="container">
      <div id="responsive-nav">
        <div class="category-nav show-on-click">
          <span class="category-header" onclick="">Repair parts online shop<i class="fas fa-cog"></i></span>
          <SideMenu v-if="window.width<991"/>
        </div>
        <div class="menu-nav">
          <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
          <ul class="menu-list">
            <li class="dropdown mega-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">АВТОСЕРВИС<i class="fa fa-caret-down"></i></a></li>
            <li class="dropdown mega-dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">ШИНОМОНТАЖ&БАЛАНСИРОВКА <i class="fa fa-caret-down"></i></a>
              <div class="custom-menu">
                <div class="row">
                  <div class="col-md-4">
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Online shop</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                    <hr class="hidden-md hidden-lg">
                  </div>
                  <div class="col-md-4">
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                    <hr class="hidden-md hidden-lg">
                  </div>
                  <div class="col-md-4">
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                  </div>
                </div>
                <div class="row hidden-sm hidden-xs">
                  <div class="col-md-12">
                    <hr>
                    <a class="banner banner-1" href="#">
                      <img src="../../static/img/banner05.jpg" alt="">
                      <div class="banner-caption text-center">
                        <h2 class="white-color">NEW COLLECTION</h2>
                        <h3 class="white-color font-weak">HOT DEAL</h3>
                      </div>
                    </a>
                  </div>
                </div>
              </div>
            </li>
            <li class="dropdown mega-dropdown full-width"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">КОРРЕКТИРОВКА СВЕТА ФАР <i class="fa fa-caret-down"></i></a>
              <div class="custom-menu">
                <div class="row">
                  <div class="col-md-3">
                    <div class="hidden-sm hidden-xs">
                      <a class="banner banner-1" href="#">
                        <img src="../../static/img/banner06.jpg" alt="">
                        <div class="banner-caption text-center">
                          <h3 class="white-color text-uppercase">Women’s</h3>
                        </div>
                      </a>
                      <hr>
                    </div>
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <div class="hidden-sm hidden-xs">
                      <a class="banner banner-1" href="#">
                        <img src="../../static/img/banner07.jpg" alt="">
                        <div class="banner-caption text-center">
                          <h3 class="white-color text-uppercase">Men’s</h3>
                        </div>
                      </a>
                    </div>
                    <hr>
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <div class="hidden-sm hidden-xs">
                      <a class="banner banner-1" href="#">
                        <img src="../../static/img/banner07.jpg" alt="">
                        <div class="banner-caption text-center">
                          <h3 class="white-color text-uppercase">Accessories</h3>
                        </div>
                      </a>
                    </div>
                    <hr>
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <div class="hidden-sm hidden-xs">
                      <a class="banner banner-1" href="#">
                        <img src="../../static/img/banner09.jpg" alt="">
                        <div class="banner-caption text-center">
                          <h3 class="white-color text-uppercase">Bags</h3>
                        </div>
                      </a>
                    </div>
                    <hr>
                    <ul class="list-links">
                      <li>
                        <h3 class="list-links-title">Categories</h3></li>
                      <li><a href="#">Women’s Clothing</a></li>
                      <li><a href="#">Men’s Clothing</a></li>
                      <li><a href="#">Phones & Accessories</a></li>
                      <li><a href="#">Jewelry & Watches</a></li>
                      <li><a href="#">Bags & Shoes</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </li>
            <li><a href="#">CAFE STATION</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>
<script> import SideMenu from './sideMenu'
var services = [{
  name: 'АВТОСЕРВИС',
  row: [{
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  }]
},
{
  name: 'ШИНОМОНТАЖ&БАЛАНСИРОВКА',
  row: [{
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  }]
},
{
  name: 'КОРРЕКТИРОВКА СВЕТА ФАР',
  row: [{
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  },
  {
    cell: ['Women’s Clothing',
      'Men’s Clothing',
      'Phones & Accessories',
      'Jewelry & Watches',
      'Bags & Shoes'],
    picture: null
  }]
},
{name: 'CAFE STATION', row: null, picture: null}
]
export default ({
  name: 'App',
  data: function () {
    return {
      services,
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
    SideMenu
  }
})

</script>
