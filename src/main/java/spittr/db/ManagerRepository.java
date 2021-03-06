package spittr.db;

import spittr.domain.Manager;

import java.util.List;

public interface ManagerRepository {
    /**
     * 取得管理员数量
     *
     * @return
     */
    long count();

    /**
     * 新建一个管理员
     *
     * @param manager
     *            新建的管理员
     * @return 管理员
     */
    Manager save(Manager manager);

    /**
     * 依据id查找 管理员
     *
     * @param id
     *            管理员ID
     * @return  管理员
     */
    Manager findOne(long id);

    /**
     * 依据用户名（登录名）查找 管理员
     *
     * @param userName
     *            用户名（登录名）
     * @return  管理员
     */
    Manager findByUserName(String userName);

    /**
     * 依据用户名（登录名），密码查找 管理员
     *
     * @param userName
     *            用户名（登录名）
     * @param password
     *            密码
     * @return  管理员
     */
    Manager findByUserName(String userName, String password);

    /**
     * 取得全部 管理员
     *
     * @return 全部 管理员
     */
    List<Manager> findAll();

    /**
     * 获得某范围内的管理员名单，用于分页
     * @param start_index
     * @param offset
     * @return
     */
    List<Manager> findRange(int start_index,int offset);

    /**
     * 删除某个管理员，将管理员的delete属性置为1
     * @param id
     */
    void delete(Long id);

    /**
     * 更新管理员信息
     * @param manager
     */
    void update(Manager manager);

}
