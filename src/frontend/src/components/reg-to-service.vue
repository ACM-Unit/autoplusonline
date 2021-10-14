<template>
  <div id="TOModal" class="modal fade" role="dialog">
    <div class="modal-dialog  modal-sm">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Запись на ТО</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
              <label class="label" for="usr">Имя:</label>
              <input type="text" class="form-control" placeholder="имя" id="usr">
            </div>
            <div class="form-group">
              <label class="label">Телефон:</label>
              <maskedInput id="tel" class="form-control" v-model="phone" mask="\+\3\8 (\011) 111-1111"
                           placeholder="телефон" type="tel"/>
            </div>
            <div class="form-group">
              <label class="label" for="eml">e-mail:</label>
              <input type="email" class="form-control" placeholder="почта" id="eml">
            </div>
            <div class="form-group">
              <label class="label"></label>
            </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-light">записаться</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import maskedInput from 'vue-masked-input'

export default {
  name: 'reg-to-service',
  data: function () {
    return {
      phone: ''
    }
  },
  components: {maskedInput}
}
</script>
