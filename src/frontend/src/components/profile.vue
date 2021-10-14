<template>
    <div class="modal-body">
        <div class="form-group">
            <label class="label" for="usr">Имя:</label>
            <input type="text" class="form-control" v-model="$store.state.user.username" placeholder="имя" id="usr">
        </div>
        <div class="form-group">
            <label class="label">Телефон:</label>
            <maskedInput id="tel" class="form-control" v-model="$store.state.user.phone" mask="\+\3\8 (\011) 111-1111"
                         placeholder="телефон" type="tel"/>
        </div>
        <div class="form-group">
            <label class="label" for="email-profile">e-mail:</label>
            <input type="email" class="form-control" placeholder="почта" v-model="$store.state.user.email" id="email-profile">
        </div>
        <div class="form-group">
            <label class="label" for="password-profile">Пароль:</label>
            <input type="email" class="form-control" placeholder="почта" v-model="$store.state.user.password" id="password-profile">
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-primary">Сохранить</button>
        </div>
    </div>
</template>

<script>
import maskedInput from 'vue-masked-input'

export default {
  name: 'profile',
  data () {
    return {
      user: {
        username: '',
        email: '',
        phone: '',
        password: '',
        confirmpassword: ''
      }
    }
  },
  components: {maskedInput}
}
</script>

<style scoped>

</style>
