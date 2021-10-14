import axios from 'axios'
import service from './Service'

axios.defaults.withCredentials = true

export default {
  years () {
    const year = new Date().getFullYear()
    return Array.from({length: year - 1950}, (value, index) => 1951 + index)
  },
  getBrands (selectedyear) {
    return service.getQuery('/api/cars/allMarks', {'year': selectedyear})
  },
  getModels (selectedbrand, selectedyear) {
    return service.getQuery('/api/cars/allMarks/byBrand',
      {'brand': selectedbrand, 'year': selectedyear})
  },
  getTypes (selectedbrand, selectedmodel, selectedyear) {
    return service.getQuery('/api/cars/allMarks/byModel',
      {'brand': selectedbrand, 'model': selectedmodel, 'year': selectedyear})
  },
  getModifications (selectedmodeltype) {
    return service.getQuery('/api/cars/modifications', {'carId': selectedmodeltype})
  }
}
