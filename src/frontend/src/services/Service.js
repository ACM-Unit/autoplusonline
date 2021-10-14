import axios from 'axios'

axios.defaults.withCredentials = true

export default {
  async getQuery (link, map) {
    let response = await axios.get(link, {params: this.axiosParams(map)})
    return response
  },
  axiosParams (parameters) {
    const params = new URLSearchParams()
    Object.entries(parameters).forEach(([key, value]) => params.append(key, value))
    return params
  }
}
