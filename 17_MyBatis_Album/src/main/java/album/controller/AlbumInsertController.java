package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController { //인서트를 처리하는 컨트롤러

	private final String command = "/insert.ab";
	//리퀘스트에 들어가는 벨류는 상수값을 입력해야하기때문에 final을 입력해줘야함
	private final String getPage = "albumInsertForm"; //final반드시 안붙여도됨
	private final String gotoPage = "redirect:/list.ab"; //목록보기로 이동
	
	//객체를 여기서 필요로 한다
	@Autowired
	private AlbumDao albumDao;
	
	// 위치 albumList.jsp에서 추가하기 클릭했을때 insert.ab get방식요청 form으로 요청을했을때
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}//get방식요청 
	
	//위치 albumInsertForm에서 추가하기 클릭했을때 insert.ab post방식으로 요청 삽입으로 요청했을때
	@RequestMapping(value=command,method =RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("album") @Valid AlbumBean album,BindingResult result) {
		//"album"은 jsp에서 사용하는 이름이고 album은 자바에서 사용하는 이름 
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
		mav.setViewName(getPage);
		return mav;
		}
		
		int cnt = -1;
		cnt = albumDao.insertAlbum(album);//여기서 album은 위에 자바에서사용하는 AlbumBean album 의 album임 
		mav.setViewName(gotoPage);
		return mav;
		
	}//post방식 요청 
}
