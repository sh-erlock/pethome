package org.ethan.org.service.impl;

import org.ethan.basic.exception.BasicException;
import org.ethan.basic.service.impl.BaseServiceImpl;
import org.ethan.org.domain.Employee;
import org.ethan.org.domain.Shop;
import org.ethan.org.mapper.EmployeeMapper;
import org.ethan.org.mapper.ShopMapper;
import org.ethan.org.service.IEmployeeService;
import org.ethan.org.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Ethan Hunter
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ShopServiceImpl extends BaseServiceImpl<Shop> implements IShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 店铺入驻管理
     * 入驻需要添加店铺的基本信息和店长的基本信息
     * @param shop
     */
    @Override
    @Transactional
    public void shopRegiste(Shop shop) {
        // 获取前端传入的employee对象admin，对象中包含了密码，用户名等需要验证的信息
        Employee admin = shop.getAdmin();

        // 验证两次输入的密码是否一致
        if (!admin.getPassword().equals(admin.getConfirmPassword())) {
            throw new BasicException("密码不一致，请重新输入！！！");
        }

        // 验证输入的用户名是否已经在数据库存在
        Employee employee = employeeMapper.findByUsername(admin.getUsername());
        if (employee != null) {
            throw new BasicException("用户名已存在！！！");
        }

        // 向两张表添加数据，必须先添加t_employee的数据,获取自增的id，这个id就是t_shop表的admin_id
        employeeMapper.add(admin);

        // 把t_employee自增的id，设置为t_shop表的admin_id,因为这个id已经在admin对象中存在，所以直接传入对象
        shop.setAdmin(admin);

        // 向t_shop表添加数据,获得自增的id，这个id就是t_employee表的shop_id
        shopMapper.add(shop);

        // 把t_shop自增的id，设置为t_employee表的shop_id
        admin.setShop_id(shop.getId());

        // 更新t_employee表数据
        employeeMapper.update(admin);
    }
}
