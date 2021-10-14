import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)
let store = {
  state: {
    cart: [],
    cartCount: 0,
    categories: [],
    marks: [],
    status: '',
    user: {},
    filter: ''
  },
  mutations: {
    initialiseStore (state) {
      if (localStorage.getItem('store')) {
        this.replaceState(
          Object.assign(state, JSON.parse(localStorage.getItem('store')))
        )
      }
    },
    updateFilter (state, filter) {
      state.filter = filter
    },
    addToCart (state, item) {
      var cartEntry = {
        id: item.id,
        name: item.name,
        code: item.code,
        trademark: item.trademark.description,
        price: '0,00',
        quantity: 1
      }
      let found = state.cart.find(product => product.id === cartEntry.id)
      if (found) {
        found.quantity++
        found.totalPrice = found.quantity * found.price
      } else {
        state.cart.push(cartEntry)
        Vue.set(cartEntry, 'quantity', 1)
        Vue.set(cartEntry, 'totalPrice', cartEntry.price)
      }
      state.cartCount++
      localStorage.setItem('store', JSON.stringify(state))
    },
    removeFromCart (state, item) {
      let index = state.cart.indexOf(item)
      if (index > -1) {
        var part = state.cart[index]
        state.cartCount -= part.quantity
        state.cart.splice(index, 1)
        localStorage.setItem('store', JSON.stringify(state))
      }
    },
    getCategories (state) {
      axios
        .get('/api/category/root')
        .then(response => (state.categories = response.data))
      localStorage.setItem('store', JSON.stringify(state))
    },
    auth_request (state) {
      state.status = 'loading'
    },
    auth_success (state, user) {
      state.status = 'success'
      state.user = user
      localStorage.setItem('store', JSON.stringify(state))
    },
    auth_error (state) {
      state.status = 'error'
      state.user = {}
      localStorage.setItem('store', JSON.stringify(state))
    },
    logout (state) {
      state.status = ''
      state.user = {}
      localStorage.setItem('store', JSON.stringify(state))
    }
  },
  actions: {
    login ({commit}, user) {
      return new Promise((resolve, reject) => {
        commit('auth_request')
        axios(
          {
            url: '/api/token', params: user, method: 'POST'
          })
          .then(resp => {
            console.log('resp = ' + resp.data)
            const user = resp.data
            console.log('user = ' + user)
            axios.defaults.headers.common['Authorization'] = user.token
            commit('auth_success', user)
            resolve(resp)
          })
          .catch(err => {
            commit('auth_error')
            reject(err)
          })
      })
    },
    register ({commit}, user) {
      return new Promise((resolve, reject) => {
        console.log('user = ' + user)
        commit('auth_request')
        axios({url: '/api/registration', params: user, method: 'POST'})
          .then(resp => {
            console.log('resp = ' + resp.data)
            const user = resp.data
            console.log('user = ' + user)
            axios.defaults.headers.common['Authorization'] = user.token
            commit('auth_success', user)
            resolve(resp)
          })
          .catch(err => {
            commit('auth_error', err)
            reject(err)
          })
      })
    },
    logout ({commit}) {
      return new Promise((resolve, reject) => {
        commit('logout')
        delete axios.defaults.headers.common['Authorization']
        resolve()
      })
    }
  },
  getters: {
    isLoggedIn: state => !!state.user.token,
    authStatus: state => state.status
  }
}
export default store
