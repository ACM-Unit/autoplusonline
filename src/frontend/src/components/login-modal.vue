<template>
    <vodal measure="em" :show="show" :animation="animation" @hide="show = false" :duration="0" className="my-dialog">
        <div class="box-modal">
            <div class="box-part" id="bp-left">
                <div class="partition" id="partition-register">
                    <div class="partition-title">ВХОД</div>
                    <div class="partition-form">
                        <form autocomplete="false">

                            <div class="autocomplete-fix">
                                <input type="password">
                            </div>
                            <input id="n-username" v-model="username" type="text" placeholder="Username">
                            <input id="n-password2" v-model="password" type="password" placeholder="Password">
                        </form>

                        <div style="margin-top: 42px">
                        </div>

                        <div class="button-set">
                            <button id="goto-signin-btn" @click="login()">Sign In</button>
                            <v-facebook-login app-id="512428446105679"></v-facebook-login>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box-part" id="bp-right">
                <div class="close-modal">
                    <i class="fa fa-times" aria-hidden="true" @click="show = false"/>
                </div>
            </div>
        </div>
    </vodal>
</template>
<script>
import Vodal from 'vodal'
import VFacebookLogin from 'vue-facebook-login-component'

export default {
  name: 'ModalBody',
  data () {
    return {
      username: '',
      password: '',
      error: '',
      show: false,
      animation: '',
      paddingTop: `paddingTop: ${(window.innerHeight - 940) / 2}px`,
      types: ['zoom', 'fade', 'flip', 'door', 'rotate', 'slideUp', 'slideDown', 'slideLeft', 'slideRight']
    }
  },
  methods: {
    delay (index) {
      return `
        animationDelay: ${index * 100}ms;
        WebkitAnimationDelay: ${index * 100}ms;
      `
    },
    onShow (animation) {
      console.log('hallo modal')
      this.animation = animation
      this.show = !this.show
    },
    login: function () {
      let username = this.username
      let password = this.password
      this.$store.dispatch('login', {username, password})
        .then(() => {
          this.$router.push('/home')
          this.show = false
        })
        .catch(err => {
          console.log(err)
          this.error = err
        })
    }
  },
  components: {
    vodal: Vodal,
    VFacebookLogin: VFacebookLogin
  }
}
</script>
