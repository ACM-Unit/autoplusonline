<template>
  <div id="footer" class="section section-grey">
    <!-- container -->
    <div class="container">
      <!-- row -->
      <div class="row">
        <!-- footer widget -->
        <div class="col-md-3 col-sm-6 col-xs-6">
          <div class="footer">
            <!-- footer logo -->
            <div class="footer-logo">
              <router-link :to="{path: '/'}">
                <img src="/static/img/logodealer.png" alt="">
              </router-link>
            </div>
            <!-- /footer logo -->
            <!-- footer social -->
            <ul class="footer-social" style="text-align: center;">
              <li><a href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a href="#"><i class="fa fa-instagram"></i></a></li>
              <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
            </ul>
            <!-- /footer social -->
          </div>
        </div>
        <!-- /footer widget -->

        <!-- footer widget -->
        <div class="col-md-3 col-sm-6 col-xs-6">
          <div class="footer">
            <h3 class="footer-header">My Account</h3>
            <ul class="list-links">
              <li><a href="#">My Account</a></li>
              <li><a href="#">My Wishlist</a></li>
              <li><a href="#">Compare</a></li>
              <li><a href="#">Checkout</a></li>
              <li><a href="#">Login</a></li>
            </ul>
          </div>
        </div>
        <!-- /footer widget -->

        <div class="clearfix visible-sm visible-xs"></div>

        <!-- footer widget -->
        <div class="col-md-3 col-sm-6 col-xs-6">
          <div class="footer">
            <h3 class="footer-header">Customer Service</h3>
            <ul class="list-links">
              <li><a href="#">About Us</a></li>
              <li><a href="#">Shiping & Return</a></li>
              <li><a href="#">Shiping Guide</a></li>
              <li><a href="#">FAQ</a></li>
            </ul>
          </div>
        </div>
        <!-- /footer widget -->

        <!-- footer subscribe -->
        <div class="col-md-3 col-sm-6 col-xs-6">
          <div class="footer">
            <h3 class="footer-header">Stay Connected</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.</p>
            <form>
              <div class="form-group">
                <input class="input" placeholder="Enter Email Address">
              </div>
              <button class="primary-btn">Join Newslatter</button>
            </form>
          </div>
        </div>
        <!-- /footer subscribe -->
      </div>
      <!-- /row -->
      <hr>
      <!-- row -->
      <div class="row">
        <div class="col-md-8 col-md-offset-2 text-center">
          <!-- footer copyright -->
          <div class="footer-copyright">
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;2020 All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="" target="_blank">ACM-Unit</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </div>
          <!-- /footer copyright -->
        </div>
      </div>
      <!-- /row -->
    </div>
    <!-- /container -->
  </div>
</template>
<script>
var categories = [
  {
    name: 'ДВИГАТЕЛЬ',
    row: [
      {
        cell: ['Women’s Clothing',
          'Men’s Clothing',
          'Phones & Accessories',
          'Jewelry & Watches',
          'Bags & Shoes']
      },
      {
        cell: ['Women’s Clothing',
          'Men’s Clothing',
          'Phones & Accessories',
          'Jewelry & Watches',
          'Bags & Shoes']
      }
    ],
    picture: '../../static/img/banner05.jpg'
  },
  {
    name: 'ТРАНСМИССИЯ',
    row: [
      {
        cell: ['Women’s Clothing',
          'Men’s Clothing',
          'Phones & Accessories',
          'Jewelry & Watches',
          'Bags & Shoes']
      },
      {
        cell: ['Women’s Clothing',
          'Men’s Clothing',
          'Phones & Accessories',
          'Jewelry & Watches',
          'Bags & Shoes']
      },
      {
        cell: ['Women’s Clothing',
          'Men’s Clothing',
          'Phones & Accessories',
          'Jewelry & Watches',
          'Bags & Shoes']
      }
    ],
    picture: null
  },
  {name: 'ПОДВЕСКА И РУЛЕВОЕ УПРАВЛЕНИЕ', row: null, picture: null},
  {name: 'ТОРМОЗА', row: null, picture: null},
  {name: 'ТОПЛИВНАЯ СИСТЕМА', row: null, picture: null},
  {name: 'ЭЛЕКТРИКА И ЗАЖИГАНИЕ', row: null, picture: null},
  {name: 'СИСТЕМЫ ОТОПЛЕНИЯ И ОХЛАЖДЕНИЯ', row: null, picture: null},
  {name: 'ВЫХЛОПНАЯ СИСТЕМА', row: null, picture: null},
  {name: 'СИСТЕМА ОЧИСТКИ ОКОН', row: null, picture: null},
  {name: 'ФИЛЬТРЫ', row: null, picture: null},
  {name: 'КУЗОВНЫЕ ДЕТАЛИ И СОСТАВЛЯЮЩИЕ', row: null, picture: null},
  {name: 'ОПТИКА И СВЕТ', row: null, picture: null},
  {name: 'ШИНЫ', row: null, picture: null}
]
export default ({
  name: 'App',
  data: function () {
    return {
      categories
    }
  }
})
</script>
