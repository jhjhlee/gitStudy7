package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {

	private final String command = "/list.ab";
	private final String getPage = "albumList";
	
	@Autowired
	@Qualifier("myAlbumDao")
	AlbumDao albumDao;
	
	@RequestMapping(command)
	public ModelAndView list(
			@RequestParam(value="whatColumn",required=false)String whatColumn,
		@RequestParam(value="keyword",required=false) String keyword,
		@RequestParam(value="pageNumber",required=false) String pageNumber,
		HttpServletRequest request){
		//페이지번호가 넘어갈수도 있고 안넘어 갈수도있으니 required=false입력해주기
		
		//required 기본값이 true이기 때문에 required쓰려면 항상 앞에 value를 입력해줘야함
		//whatColumn,keyword가 넘어오지 않을때 http://localhost:8080/ex/list.ab
		//넘어올때는 ? 목록보기에서 검색할때 
			System.out.println("whatColumn(검색할 칼럼)"+whatColumn);//whatColumn :singer
			System.out.println("keyword(검색할 단어)"+keyword); //keyword:레드
			System.out.println("pageNumber(페이지번호)"+pageNumber); //페이지번호 맨처음에는 null값으로 들어가있음
			
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);//whatColumn :singer
		map.put("keyword", "%"+keyword+"%");//keyword:%레드%
			
		//System.out.println("list");
		
		int totalCount = albumDao.getTotalCount(map);//전체레코드 일수도 있고, 검색어에 일치하는 레코드 갯수일수도있음
		System.out.println("totalCount: " +totalCount);
		
		String url = request.getContextPath() + this.command;
		System.out.println("url:" + url); /* ex안에 프로젝트명도 포함이되어있다.또한 HttpServletRequest를 넣어야함*/

		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		//Paging pageInfo = new Paging(pageNumber,null,);
		ModelAndView mav = new ModelAndView();
		List<AlbumBean> albumLists = albumDao.getAlbumList(pageInfo,map);
		mav.addObject("albumLists", albumLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage); // /WEB-INF/album/albumList.jsp
		return mav;
	}
}