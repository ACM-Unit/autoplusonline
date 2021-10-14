import axios from 'axios'
import service from './Service'

axios.defaults.withCredentials = true

export default {
  getParts (reference, page) {
    return service.getQuery('/api/part/findby/' + reference,
      {'filter': page.filter,
        'page': page.currentPage,
        'pagesize': page.pageSize,
        'sortcol[]': page.sortcol,
        'sortdir[]': page.sortdir,
        'echo': 1})
  }
}
