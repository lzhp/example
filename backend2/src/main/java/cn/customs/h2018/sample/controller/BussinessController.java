/**  
 * Date: 2018-03-23 14:58:42. 
 * @author: lizhipeng.
 */  
package cn.customs.h2018.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import cn.customs.h2018.sample.service.BussinessService;
import cn.customs.h2018.sample.utils.CustomBussinessRuntimeException;
import cn.customs.h2018.sample.utils.CustomExceptionPojo;
import lombok.extern.slf4j.Slf4j;

/**  
 * Date: 2018-03-23 14:58:42. 
 * @author: lizhipeng.
 * @description: 
 */
@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@Slf4j
public class BussinessController {
  
  private BussinessService service;

  @Autowired
  BussinessController(BussinessService service) {
    this.service = service;
  }

  
  @ExceptionHandler({CustomBussinessRuntimeException.class})
  public ResponseEntity<CustomExceptionPojo> handleException(CustomBussinessRuntimeException e) {
    CustomExceptionPojo result = new CustomExceptionPojo(e);
    log.error(result.toString(), e);
    return new ResponseEntity<>(result, HttpStatus.SERVICE_UNAVAILABLE);
  }  
}
  
