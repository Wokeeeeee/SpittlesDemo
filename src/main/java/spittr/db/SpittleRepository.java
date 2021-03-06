package spittr.db;

import java.util.List;

import spittr.domain.Manager;
import spittr.domain.Spittle;

/**
 * 吐槽内容资源库接口
 * 
 * @author wben
 * @version v1.0
 */
public interface SpittleRepository {

	/**
	 * 取得吐槽数量
	 * 
	 * @return 吐槽数量
	 */
	long count();

	/**
	 * 取得审核通过的吐槽数量
	 * @return
	 */
	long countPass();

	/**
	 * 还未审核的吐槽数量
	 * @return
	 */
	long countUncheck();

	/**
	 * 取得最新的10条吐槽
	 * 
	 * @return 最新的10条吐槽
	 */
	List<Spittle> findRecent();

	/**
	 * 取得指定数量的最新吐槽
	 * 
	 * @param count
	 *            吐槽数量
	 * @return 最新吐槽
	 */
	List<Spittle> findRecent(int count,int start_index);

	/**
	 * 获得指定数量的未检查吐槽贴
	 * @param count
	 * @param start_index
	 * @return
	 */
	List<Spittle> findNotCheckedRecent(int count,int start_index);

	/**
	 * 删除吐槽
	 * @param id
	 */
	void deleteUnpassed(Long id);

	/**
	 * 通过吐槽
	 * @param id
	 * @param manager
	 */
	void updatePassed(Long id,Manager manager);

	/**
	 * 依据id查找吐槽
	 * 
	 * @param id
	 *            吐槽ID
	 * @return 吐槽
	 */
	Spittle findOne(long id);

	/**
	 * 新建一个吐槽
	 * 
	 * @param spittle
	 *            吐槽
	 * @return 以保存的吐槽
	 */
	Spittle save(Spittle spittle);

	/**
	 * 取得指定吐槽者的全部吐槽
	 * 
	 * @param spitterId
	 *            吐槽者ID
	 * @return 指定吐槽者的全部吐槽
	 */
	List<Spittle> findBySpitterId(long spitterId);

	/**
	 * 删除指定ID的吐槽
	 * 
	 * @param id
	 *            吐槽ID
	 */
	void delete(long id);

}
