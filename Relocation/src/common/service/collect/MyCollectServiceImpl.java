package common.service.collect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.util.NativesqlDao;
import common.domain.Cuser;

@Service("MyCollectService")
public class MyCollectServiceImpl implements MyCollectService{
	@Autowired
	NativesqlDao nativesqlDao;
	
	@Override
	public boolean addCollect(int uid, int sid, String type, int flag) {
		if(flag>0 && flag<4){}else{return false;}
		
		String sql = "select count(*) from collect where uid="+uid+" and type='"+type+"' and sid="+sid+" and flag="+flag+" and (is_deleted is null or is_deleted=false)";
		if(nativesqlDao.countBySql(sql)>0){
			return false;
		}
		sql = "insert into collect(uid,sid,type,flag,created_time,is_deleted) values("+uid+","+sid+",'"+type+"',"+flag+",now(),0)";
		nativesqlDao.executeSql(sql);
		return true;
	}

	@Override
	public boolean removeCollect(int uid, int sid, String type, int flag) {
		if(flag>0 && flag<4){}else{return false;}
		
		String sql = "update collect set is_deleted=true where uid="+uid+" and sid="+sid+" and type='"+type+"' and flag="+flag;
		nativesqlDao.executeSql(sql);
		return true;
	}

	@Override
	public List<MyCollect> listMyCollect(int uid, String type, int flag,
			int offset, int pS) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<MyCollect> result = new ArrayList<>();
		if(flag>0 && flag<4){}else{return result;}
		
		// TODO 根据具体项目修改
		
		String sql = "select a.sid, a.created_time from collect as a left join";
		if(type.equals("active")){
			sql += " actives as b on a.sid=b.activeid where b.activeid is not null";
		}else if(type.equals("strategy")){
			sql += " travelstrategy as b on a.sid=b.strategyid where b.strategyid is not null";
		}else if(type.equals("forum")){
			sql += " forums as b on a.sid=b.forumid where b.forumid is not null and b.forumdomain!=2 and (b.forumref is null or b.forumref=0)";
		}else if(type.equals("talk")){
			sql += " forums as b on a.sid=b.forumid where b.forumid is not null and b.forumdomain=2 and (b.forumref is null or b.forumref=0)";
		}else if(type.equals("goods")){
			sql += " goods as b on a.sid=b.goodsid where b.goodsid is not null";
		}
		sql += " and uid="+uid+" and type='"+type+"' and flag="+flag;
		sql += " and (b.isdelete is null or b.isdelete!=true)";
		sql += " order by a.created_time desc";
		
		if(offset>=0 && pS>0) sql += " limit "+offset+","+pS;
		
		List<Object[]> queryList = nativesqlDao.queryList(sql);
		
		//TODO
		
		return result;
	}

	@Override
	public int countMyCollect(int uid, String type, int flag) {
		if(flag>0 && flag<4){}else{return 0;}
		
		//TODO 根据具体项目修改
		
		String sql = "select count(*) from collect as a left join";
		if(type.equals("active")){
			sql += " actives as b on a.sid=b.activeid where b.activeid is not null";
		}else if(type.equals("strategy")){
			sql += " travelstrategy as b on a.sid=b.strategyid where b.strategyid is not null";
		}else if(type.equals("forum")){
			sql += " forums as b on a.sid=b.forumid where b.forumid is not null and b.forumdomain!=2 and (b.forumref is null or b.forumref=0)";
		}else if(type.equals("talk")){
			sql += " forums as b on a.sid=b.forumid where b.forumid is not null and b.forumdomain=2 and (b.forumref is null or b.forumref=0)";
		}else if(type.equals("goods")){
			sql += " goods as b on a.sid=b.goodsid where b.goodsid is not null";
		}
		sql += " and uid="+uid+" and type='"+type+"' and flag="+flag;
		sql += " and (b.isdelete is null or b.isdelete!=true)";
		return nativesqlDao.countBySql(sql);
	}

	@Override
	public List<Cuser> listCollectUser(int sid, String type, int flag,
			int offset, int pS) {
		if(flag>0 && flag<4){}else{return new ArrayList<>();}
		
		String sql = "select distinct c.* from collect as a left join cuser as c on a.uid=c.id";
		sql += " and c.id is not null";
		sql += " and (a.is_deleted is null or a.is_deleted=false)";
		sql += " and sid="+sid+" and type='"+type+"' and flag="+flag;
		sql += " order by a.created_time desc";
		
		if(offset>=0 && pS>0) sql += " limit "+offset+","+pS;
		return nativesqlDao.listBySql(sql, new Cuser());
	}

	@Override
	public int countCollectUser(int sid, String type, int flag) {
		if(flag>0 && flag<4){}else{return 0;}
		
		String sql = "select count( distinct c.id) from collect as a left join cuser as c on a.uid=c.id";
		sql += " and c.id is not null";
		sql += " and (a.is_deleted is null or a.is_deleted=false)";
		sql += " and sid="+sid+" and type='"+type+"' and flag="+flag;
		
		return nativesqlDao.countBySql(sql);
	}

	@Override
	public boolean hasCollect(int uid, int sid, String type, int flag) {
		if(flag>0 && flag<4){}else{return false;}
		
		String sql = "select count(*) from collect where type='"+type+"' and flag="+flag+" and uid="+uid+" and sid="+sid;
		sql += " and (is_deleted is null or is_deleted=false)";
		
		return nativesqlDao.countBySql(sql)==0?false:true;
	}

	@Override
	public int countMyCollect(int uid, int flag) {
		if(flag>0 && flag<4){}else{return 0;}
		String sql = "select count(*) from collect where uid="+uid+" and flag="+flag;
		sql += " and (is_deleted is null or is_deleted=false)";
		return nativesqlDao.countBySql(sql);
	}

}
