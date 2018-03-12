// http请求代理，在获得请求响应时缓存数据，在离线时从缓存中取历史数据
import axios from 'axios'
import AxiosMockAdapter from 'axios-mock-adapter'

window.axiosMock = window.axiosMock || new AxiosMockAdapter(axios, { delayResponse: 1000 })

axios.defaults.baseURL = '/'
axios.defaults.timeout = 30000
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8'
axios.defaults.withCredentials = true

window.axiosMock.onAny().passThrough()

const Request = {
  async get (url, config) {
    try {
      let res = await axios.get(url, config)
      return res
    } catch (err) {
      this.checkAuth(err)
    }
  },

  async post (url, data, config) {
    try {
      let res = await axios.post(url, data, config)
      return res
    } catch (err) {
      this.checkAuth(err)
    }
  },

  async put (url, data, config) {
    try {
      let res = await axios.put(url, data, config)
      return res
    } catch (err) {
      this.checkAuth(err)
    }
  },

  async delete (url, config) {
    try {
      let res = await axios.delete(url, config)
      return res
    } catch (err) {
      this.checkAuth(err)
    }
  },

  checkAuth (err) {
    if (err.message.includes('code 401')) {
      this.location.href = '/login.html'
    }
  }
}

export default Request
