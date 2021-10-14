<template>
  <section>
    <div class="select-car col-lg-12">
      <div class="col-md-2 col-sm-12">
        <label class="label">Год выпуска</label>
        <select class="form-control" id="sel1" v-model="selectedyear" @change='getBrands()'>
          <option disabled value="">Выберите год</option>
          <option v-for="year in years" :key="year">{{ year }}</option>
        </select>
      </div>
      <div class="col-md-2 col-sm-12" v-if="selectedyear">
        <label class="label">Марка</label>
        <select class="form-control" id="sel2" v-model="selectedbrand" @change='getModels()'>
          <option disabled value="">Выберите марку</option>
          <option v-for="(mark, index) in brands" :key="index">{{mark}}</option>
        </select>
      </div>
      <div class="col-md-2 col-sm-12" v-if="selectedbrand">
        <label class="label">Модель</label>
        <select class="form-control" id="sel3" v-model="selectedmodel" @change='getTypes()'>
          <option disabled value="">Выберите модель</option>
          <option v-for="model in models" :key="model">{{model}}</option>
        </select>
      </div>
      <div class="col-md-2 col-sm-12" v-if="selectedmodel"  @change='getModifications()'>
        <label class="label">Тип модели</label>
        <select class="form-control" id="sel4" v-model="selectedmodeltype">
          <option disabled value="">Выберите тип</option>
          <option v-for="type in types" :key="type.id" v-bind:value="type.id">{{type.type}}</option>
        </select>
      </div>
      <div class="col-md-2 col-sm-12" v-if="selectedmodeltype">
        <label class="label">Модификация</label>
        <select class="form-control" id="sel5" v-model="selectedmodify">
          <option disabled value="">Выберите модификацию</option>
          <option v-for="mod in modifications" :key="mod.id">{{mod.name}}</option>
        </select>
      </div>
      <div class="col-md-2 col-sm-12"  v-if="selectedmodify">
        <label class="label">Добавить</label>
        <button type="button" style="height: 35px" class="btn btn-light"><img src="/static/img/car_revers.png" alt="" style="height: 25px"></button>
      </div>
    </div>
  </section>
</template>

<script>
import CarService from '../services/CarService'
export default {
  name: 'select-car',
  data: function () {
    return {
      selectedyear: '',
      selectedbrand: '',
      brands: [],
      selectedmodel: '',
      models: [],
      selectedmodeltype: '',
      types: [],
      selectedmodify: '',
      modifications: []
    }
  },
  computed: {
    years () {
      return CarService.years()
    }
  },
  methods: {
    getBrands: function () {
      CarService.getBrands(this.selectedyear).then(resp => (this.brands = resp.data))
    },
    getModels: function () {
      CarService.getModels(this.selectedbrand, this.selectedyear).then(resp => (this.models = resp.data))
    },
    getTypes: function () {
      CarService.getTypes(this.selectedbrand, this.selectedmodel, this.selectedyear).then(resp => (this.types = resp.data))
    },
    getModifications: function () {
      CarService.getModifications(this.selectedmodeltype).then(resp => (this.modifications = resp.data))
    }
  }
}
</script>
