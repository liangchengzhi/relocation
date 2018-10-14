package common.service.collect;

import java.util.List;

import common.domain.Cuser;

public interface MyCollectService {
	
	/**
	 * 增加收藏、点赞、“想”DO
	 * @param uid
	 * @param sid
	 * @param type  可以为active, strategy, forum, talk, goods
	 * @param flag  为1表示收藏，为2表示点赞，为3表示“想去”
	 * @return
	 */
	public boolean addCollect(int uid, int sid, String type, int flag);
	
	/**
	 * 删除收藏、点赞、“想”DO
	 * @param uid
	 * @param sid
	 * @param type  可以为active, strategy, forum, talk, goods
	 * @param flag  为1表示收藏，为2表示点赞，为3表示“想去”
	 * @return
	 */
	public boolean removeCollect(int uid, int sid, String type, int flag);
	
	/**
	 * 获取指定用户的收藏列表、点赞列表、想DO列表
	 * @param uid	用户ID
	 * @param type	可以为active, strategy, forum, talk, goods
	 * @param flag  为1表示收藏，为2表示点赞，为3表示“想去”
	 * @param offset
	 * @param pS
	 * @return
	 */
	public List<MyCollect> listMyCollect(int uid, String type, int flag, int offset, int pS);
	public int countMyCollect(int uid, String type, int flag);
	
	/**
	 * 指定用户所有收藏、点赞或想DO数量
	 * @param uid	用户ID
	 * @param flag	为1表示收藏，为2表示点赞，为3表示“想去”
	 * @return
	 */
	public int countMyCollect(int uid, int flag);
	
	/**
	 * 获取指定对象的收藏者、点赞者、想DO者
	 * @param sid	资源ID
	 * @param type	可以为active, strategy, forum, talk, goods
	 * @param flag	为1表示收藏，为2表示点赞，为3表示“想去”
	 * @param offset
	 * @param pS
	 * @return
	 */
	public List<Cuser> listCollectUser(int sid, String type, int flag, int offset, int pS);
	public int countCollectUser(int sid, String type, int flag);
	
	/**
	 * 判断指定用是否收藏、点赞、想去指定对象（活动、攻略、论坛、说说、商品）
	 * @param uid	用户ID
	 * @param sid	资源ID
	 * @param type	可以为active, strategy, forum, talk, goods
	 * @param flag	为1表示收藏，为2表示点赞，为3表示“想去”
	 * @return
	 */
	public boolean hasCollect(int uid, int sid, String type, int flag);
}
