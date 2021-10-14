import axios from 'axios';

axios.defaults.withCredentials = true;

export default {
  getCluster(id) {
    return axios.get('/api/cluster/' + id).then((response) => {
      return response.data;
    });
  },
  addCluster(name) {
    return axios.put('/api/cluster', { name: name }).then((response) => {
      return response.data;
    });
  }
};
