<template>
    <vodal measure="em" :show="show" :animation="animation" @hide="show = false" :duration="0" className="my-dialog">
        <div class="box-modal">
            <div class="box-part" id="bp-left">
                <div class="partition" id="partition-register">
                    <div class="partition-title">РЕГИСТРАЦИЯ</div>
                    <div class="partition-form">
                        <form autocomplete="false">

                            <div class="autocomplete-fix">
                                <input type="password">
                            </div>
                            <input id="n-login" v-model="$v.user.username.$model" type="text" placeholder="Username"
                                   v-bind:class="{error: $v.user.username.$error, valid: $v.user.username.$dirty && !$v.user.username.$invalid}"
                                   @focus="username_flag = true"
                                   @blur="username_flag = false">
                            <div class="error" v-if="!$v.user.username.required && username_flag">username is required.</div>
                            <div class="error" v-if="!$v.user.username.minLength && username_flag">username must have at least {{ $v.user.username.$params.minLength.min }} letters.</div>
                            <input id="n-email"  v-model="$v.user.email.$model" type="email" placeholder="Email"
                                   v-bind:class="{error: $v.user.email.$error, valid: $v.user.email.$dirty && !$v.user.email.$invalid}"
                                   @focus="email_flag = true"
                                   @blur="email_flag = false">
                            <div class="error" v-if="!$v.user.email.email && email_flag">Invalid e-mail.</div>
                            <maskedInput id="n-phone"  v-model="user.phone" type="tel" placeholder="phone"
                                   mask="\+\3\8 (\011) 111-1111"/>
                            <input id="n-password"  v-model="$v.user.password.$model" type="password" placeholder="Password"
                                   v-bind:class="{error: $v.user.password.$error, valid: $v.user.password.$dirty && !$v.user.password.$invalid}"
                                   @focus="password_flag = true"
                                   @blur="password_flag = false">
                            <div class="error" v-if="!$v.user.password.required && password_flag">Password is required.</div>
                            <div class="error" v-if="!$v.user.password.minLength && password_flag">Password must have at least {{ $v.user.password.$params.minLength.min }} letters.</div>
                            <input id="confirm-password" v-model="$v.user.confirmpassword.$model" type="password" placeholder="Confirm password"
                                   v-bind:class="{error: $v.user.confirmpassword.$error, valid: $v.user.confirmpassword.$dirty && !$v.user.confirmpassword.$invalid}"
                                   @focus="confirmpassword_flag = true"
                                   @blur="confirmpassword_flag = false">
                            <div class="error" v-if="!$v.user.confirmpassword.sameAsPassword && confirmpassword_flag">Passwords must be identical.</div>
                        </form>

                        <div style="margin-top: 42px">
                        </div>

                        <div class="button-set">
                            <button id="goto-signin-btn" @click="registration">Создать аккаунт</button>
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
import { required, sameAs, minLength, email } from 'vuelidate/lib/validators'
import maskedInput from 'vue-masked-input'

export default {
  name: 'ModalBody',
  data () {
    return {
      user: {
        username: '',
        email: '',
        phone: '',
        password: '',
        confirmpassword: ''},
      error: '',
      show: false,
      animation: '',
      paddingTop: `paddingTop: ${(window.innerHeight - 940) / 2}px`,
      types: ['zoom', 'fade', 'flip', 'door', 'rotate', 'slideUp', 'slideDown', 'slideLeft', 'slideRight'],
      username_flag: false,
      password_flag: false,
      email_flag: false,
      confirmpassword_flag: false
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
    status (validation) {
      return {
        error: validation.$error,
        dirty: validation.$dirty
      }
    },
    registration: function () {
      if (!this.$v.user.$anyError) {
        let username = this.user.username
        let password = this.user.password
        let email = this.user.email
        let phone = this.user.phone
        console.log('reg phone' + phone)
        console.log('reg email' + email)
        this.$store.dispatch('register', { username, email, phone, password })
          .then(() => {
            this.$router.push('/account')
            this.show = false
          })
          .catch(err => {
            console.log(err)
            this.error = err
          })
      } else {
        this.username_flag = true
        this.email_flag = true
        this.password_flag = true
        this.confirmpassword_flag = true
      }
    }
  },
  components: {
    vodal: Vodal,
    maskedInput: maskedInput
  },
  validations: {
    user: {
      username: {
        required,
        minLength: minLength(4)
      },
      email: {
        required,
        email
      },
      password: {
        required,
        minLength: minLength(6)
      },
      confirmpassword: {
        sameAsPassword: sameAs('password')
      }
    }
  }
}
</script>
<style>
    input {
        border: 1px solid silver;
        border-radius: 4px;
        background: white;
        padding: 5px 10px;
    }

    .dirty {
        border-color: #5A5;
        background: #EFE;
    }

    .dirty:focus {
        outline-color: #8E8;
    }

    .error {
        border-color: red;
        background: #FDD;
    }

    .error:focus {
        outline-color: #F99;
    }
</style>
