<template>
  <div>
    <div class="pull-right">
      <ul class="header-btns">
        <li class="header-search">
          <div class="input-group">
            <input v-model="page.filter" placeholder="search"
                   id="example-search-input" class="form-control border-end-0 border rounded-pill" type="text">
          </div>
        </li>
        <li class="nav-toggle">
          <button @click="updateFilter(page.filter)"
                  class="btn btn-outline-secondary bg-white border-start-0 border rounded-pill ms-n3"
                  type="button">
            <i class="fa fa-search"></i>
          </button>
        </li>
      </ul>
    </div>
    <table class="table table-striped">
      <thead>
      <tr>
        <th style="width: 40px;">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" id="checkAll54005558" aria-label="Select All" class="custom-control-input">
            <label for="checkAll54005558" class="custom-control-label"></label>
          </div>
        </th>
        <th scope="col" v-for="column in columns" :key="column.name">{{ column.title }}
          <i v-if="column.sort == true" v-bind:class="'fa fa-fw fa-' + column.direction" @click="column = sort(column)"></i>
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="p in products.data" :key="p.id">
        <td>
          <div class="custom-control custom-checkbox">
            <input type="checkbox" id="check540055588" class="custom-control-input">
            <label for="check540055588" class="custom-control-label"></label>
          </div>
        </td>
        <td v-for="column in columns" :key="column.name" v-html="column.render(column.name, p)"></td>
        <td>
          <div class="part-cart"><i class="fa fa-shopping-cart table-btn" @click="addToCart(p)"></i></div>
        </td>
      </tr>
      </tbody>
    </table>
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item"><span v-on:click=goToPage(1,page.filter)>«</span></li>
        <li v-for="p in slicePages" :key="p" v-bind:class="paginationClass(p)">
          <span v-on:click=goToPage(p,page.filter)>{{ p }}</span></li>
        <li class="page-item"><span v-on:click=goToPage(products.filtered,page.filter)>»</span></li>
      </ul>
    </nav>
  </div>
</template>

<script>
import PartService from '../services/PartService'

var products = []
export default {
  name: 'parts',
  data: function () {
    return {
      page: {
        filter: '',
        currentPage: 1,
        pageSize: 10,
        sortcol: [],
        sortdir: []
      },
      columns: [
        {
          name: 'name',
          title: 'Название',
          sort: true,
          direction: 'sort',
          render: this.renderName
        },
        {
          name: 'code',
          title: 'Код',
          sort: true,
          direction: 'sort',
          render: this.renderCode
        },
        {
          name: 'trademark.description',
          title: 'Прозводитель',
          sort: true,
          direction: 'sort',
          render: this.renderTrademark
        },
        {
          name: 'params',
          title: 'Параметры',
          visible: true,
          sort: true,
          direction: 'sort',
          render: this.renderParamsColumn
        },
        {
          name: 'quantity',
          title: 'Кол-во',
          sort: false,
          direction: 'sort',
          render: this.renderQuantity
        },
        {
          name: 'price',
          title: 'Цена',
          sort: false,
          direction: 'sort',
          render: this.renderPrice
        }
      ],
      products
    }
  },
  created () {
    this.page.filter = this.$route.query.filter === undefined ? '' : this.$route.query.filter
  },
  mounted () {
    this.getData()
  },
  computed: {
    slicePages: function () {
      let page = this.page.currentPage
      let allPages = this.products.filtered
      let selectedPages = []
      let j = 0
      let i = page > 3 ? page - 3 : 1
      if (page + 3 > allPages) {
        i = allPages < 6 ? 1 : allPages - 6
      }
      for (; i <= allPages; i++) {
        if (j > 6) {
          break
        }
        selectedPages[j++] = i
      }
      return selectedPages
    }
  },
  methods: {
    updateFilter (filter) {
      this.page.filter = filter
      this.page.currentPage = 1
      this.getData()
    },
    sort (column) {
      this.columns.forEach(col => {
        if (col.name === column.name) {
          this.page.sortcol = column.name
          if (col.direction === 'sort-asc') {
            col.direction = 'sort-desc'
            this.page.sortdir = 'desc'
          } else {
            col.direction = 'sort-asc'
            this.page.sortdir = 'asc'
          }
        } else {
          col.direction = 'sort'
        }
      })
      this.getData()
      return column
    },
    paginationClass (page) {
      return page === this.page.currentPage ? 'page-item active' : 'page-item'
    },
    addToCart: function (entry) {
      return this.$store.commit('addToCart', entry)
    },
    goToPage: function (page) {
      this.page.currentPage = page
      this.getData()
    },
    renderParamsColumn: function (colname, entry) {
      var content = '<div>'
      entry.parameters.forEach((p) => {
        content += '<span>' + p.attribute.name + ': ' + p.value + '</span></br>'
      })
      content += '</div>'
      return content
    },
    renderName: function (colname, entry) {
      return entry.name
    },
    renderCode: function (colname, entry) {
      return entry.code
    },
    renderTrademark: function (colname, entry) {
      return entry.trademark.description
    },
    renderQuantity: function (colname, entry) {
      return '1 шт'
    },
    renderPrice: function (entry) {
      return '<span>0,00 <i class="fas fa-hryvnia"></i></span>'
    },
    getData: function () {
      PartService.getParts(this.$route.params.reference, this.page).then(resp => (this.products = resp.data))
    }
  },
  components: {}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
