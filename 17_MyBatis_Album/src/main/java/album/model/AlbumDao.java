package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myAlbumDao")
//@Component의 의미는 AlbumDao myAlbumDao = new AlbumDao();
public class AlbumDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate ;
	//SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate();
		//데이터베이스관련 데이터를 많이 가지고있기때문에 꼭필요하다
		 //root-context에다가 만들어놨다.


	
	public AlbumDao() {
		System.out.println("AlbumDao()");
	}
	
	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String,String>map) {
		//Map에는 whatColumn : singer keyword는 %레드% 들어가있음 
		//System.out.println("getalbumlist");
		System.out.println("offset:" +pageInfo.getOffset()); // 현재 페이지에서 건너뛸 갯수
		System.out.println("limit:"+pageInfo.getLimit()); // 가지고있는 레코드수(가지고올 갯수)
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList",map,rowBounds);
		System.out.println("lists.size():" + lists.size());
//		select * from albums;
		return lists;
	}//getAlbumList
	
	// 1 3 5 페이지번호 3페이지를 눌렀다면 
	//0 4 8 레코드 2개를 건너뛰어야하니까 2개 2개 4개씩 건너뛰어야함
	//2 2 2 레코드 2개갯수 
	
	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		cnt =sqlSessionTemplate.insert("album.AlbumBean.insertAlbum",album);
		System.out.println("insertAlbum cnt:" + cnt);
		return cnt;
	}//insertAlbum
	
	
	public AlbumBean getAlbum(int num) {
		
		AlbumBean album = null;
		album = sqlSessionTemplate.selectOne("album.AlbumBean.getAlbum",num);
		//하나만 받을수있도록 selectOne을 입력해줌
		return album;
	}//getAlbum

	public int updateAlbum(AlbumBean album) {
		System.out.println("updateAlbum");
		System.out.println(album.getNum());
		System.out.println(album.getSinger());
		
		int cnt = -1;
		cnt =sqlSessionTemplate.insert("album.AlbumBean.updateAlbum",album);
		System.out.println("updateAlbum cnt:" + cnt);
		return cnt;
		
		
	}//updateAlbum

	public int deleteAlbum(int num) {
		System.out.println("deleteAlbum");
		int cnt = sqlSessionTemplate.delete("album.AlbumBean.deleteAlbum",num);
		
		System.out.println("deleteAlbum cnt:" + cnt);
		return cnt;
		
	}//deleteAlbum

public int getTotalCount(Map<String, String> map){
		
		int count = -1;
		
		count = sqlSessionTemplate.selectOne("album.AlbumBean.getTotalCount", map);
		
		System.out.println("totalCount : " + count);
		
		return count;
	}//getTotalCount
}      