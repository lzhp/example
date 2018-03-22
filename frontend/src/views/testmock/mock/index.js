import axios from 'axios'
import AxiosMockAdapter from 'axios-mock-adapter'
var axiosMock = new AxiosMockAdapter(axios, { delayResponse: 10 })

var mockData = [
  {
    id: 1,
    title: 'mockdata new',
    body: '3body2221'
  },
  {
    id: 2,
    title: '2title2',
    body: '2body2222'
  },
  {
    id: 3,
    title: '2title3',
    body: '2body2223'
  },
  {
    id: 4,
    title: '2title4',
    body: '2body2224'
  },
  {
    id: 5,
    title: '2title5',
    body: '2body2225'
  },
  {
    id: 6,
    title: '2title6',
    body: '2body2226'
  }
]

// axiosMock.onGet('/t1').reply(200, mockData)
axiosMock.onGet('/article/t2').reply(200, mockData)
axiosMock.onAny().passThrough()
