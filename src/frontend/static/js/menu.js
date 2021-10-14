// NAVIGATION
$(document).ready(function () {
  var responsiveNav = $('#responsive-nav'),
    catToggle = $('#responsive-nav .category-nav .category-header'),
    catList = $('.category-list'),
    menuToggle = $('#responsive-nav .menu-nav .menu-header'),
    menuList = $('#responsive-nav .menu-nav .menu-list')

  catToggle.on('click', function () {
    menuList.removeClass('open')
    catList.toggleClass('open')
  })

  menuToggle.on('click', function () {
    catList.removeClass('open')
    menuList.toggleClass('open')
  })
})
$(document).click(function (event) {
  if (!$(event.target).closest($('#responsive-nav')).length) {
    if ($('#responsive-nav').hasClass('open')) {
      $('#responsive-nav').removeClass('open')
      $('#navigation').removeClass('shadow')
    } else {
      if ($(event.target).closest('.nav-toggle > button').length) {
        if (!$('#responsive-nav .menu-nav .menu-list').hasClass('open') && !$('.category-list').hasClass('open')) {
          $('#responsive-nav .menu-nav .menu-list').addClass('open')
        }
        $('#navigation').addClass('shadow')
        $('#responsive-nav').addClass('open')
      }
    }
  }
})
