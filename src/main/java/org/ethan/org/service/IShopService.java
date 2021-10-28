package org.ethan.org.service;

import org.ethan.basic.service.IBaseService;
import org.ethan.org.domain.Employee;
import org.ethan.org.domain.Shop;

import java.util.List;

/**
 * @author Ethan Hunter
 */

public interface IShopService extends IBaseService<Shop> {

    void shopRegiste(Shop shop);
}
