import axios from 'axios'
// import AxiosMockAdapter from 'axios-mock-adapter'

// window.axiosMock = window.axiosMock || new AxiosMockAdapter(axios, { delayResponse: 1000 })

axios.defaults.baseURL = 'http://127.0.0.1:8000/'
axios.defaults.timeout = 30000
axios.defaults.headers.post['Content-Type'] =
  'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.withCredentials = true

// window.axiosMock.onAny().passThrough()

export default axios
