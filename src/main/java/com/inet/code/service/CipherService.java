package com.inet.code.service;

import com.inet.code.entity.Cipher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-11-14
 */
public interface CipherService extends IService<Cipher> {
    /**
     * 通过邮箱查找密码
     * @author HCY
     * @since 2020-11-16
     * @param userEmail 用户邮箱
     * @return Cipher实体类
     */
    Cipher getByEmail(String userEmail);
}
