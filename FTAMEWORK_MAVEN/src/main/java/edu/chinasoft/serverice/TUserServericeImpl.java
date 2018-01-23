package edu.chinasoft.serverice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.chinasoft.mapper.TUserMapper;
import edu.chinasoft.pojo.TUser;

/**
 * @Title: TUserServericeImpl.java
 * @Package edu.chinasoft.serverice
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Icabod_Crane
 * @date 2018年1月19日 下午3:10:41
 * @version V1.0
 */
@Service("tUserServericeImpl")
public class TUserServericeImpl implements TUserServerice {
	private TUserMapper tUserMapper;

	/*
	 * (non-Javadoc)
	 * @see
	 * edu.chinasoft.serverice.TUserServerice#registerUser(edu.chinasoft.pojo.TUser)
	 */
	public void registerUser(TUser tUser) {
		tUserMapper.insert(tUser);
	}

	public TUserMapper gettUserMapper() {
		return tUserMapper;
	}

	@Resource(name = "tUserMapper")
	public void settUserMapper(TUserMapper tUserMapper) {
		this.tUserMapper = tUserMapper;
	}

}
