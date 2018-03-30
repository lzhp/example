/**
 * Date: 2018-03-23 15:10:33.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.customs.h2018.sample.dao.BussinessRepository;

/**
 * Date: 2018-03-23 15:10:33.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Service
@Transactional
public class BussinessService {

  private BussinessRepository repo;

  @Autowired
  BussinessService(BussinessRepository repo) {
    this.repo = repo;
  }

}

