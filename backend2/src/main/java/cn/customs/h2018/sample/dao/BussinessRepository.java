/**  
 * Date: 2018-03-23 15:04:14. 
 * @author: lizhipeng.
 */  
package cn.customs.h2018.sample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cn.customs.h2018.sample.pojo.Bussiness;

/**  
 * Date: 2018-03-23 15:04:14. 
 * @author: lizhipeng.
 * @description: 
 */
@Repository
public interface BussinessRepository extends CrudRepository<Bussiness, String> {

}
  
