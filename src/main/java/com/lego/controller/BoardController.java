package com.lego.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lego.dto.Board;
import com.lego.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
	private HttpSession session;
    
    @GetMapping("boardList.do")
    public String list(Model model) {
        List<Board> boards = boardService.getBoardAll();
        model.addAttribute("boards", boards);
        return "board/boardList";
    }

    @GetMapping("/view")
    public String view(@RequestParam("bno") int bno, Model model) {
        Board board = boardService.getOneBoard(bno);
        model.addAttribute("board", board);
        return "board/boardView";
    }

    @GetMapping("/createForm.do")
    public String createForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/boardForm";
    }

    @PostMapping("/addBoard.do")
     
    public String insBoardPro(
    @RequestParam("title") String title,
    @RequestParam("content") String content,
    @RequestParam("file") MultipartFile file, Model model) {

	String author = (String) session.getAttribute("sid");
    log.info("제목: {}", title);
    log.info("내용: {}", content);
    
    Board board = new Board();
    board.setTitle(title);
    board.setContent(content);
    board.setAuthor(author);
    model.addAttribute("title", title);
    model.addAttribute("content", content);
    	
	if (file != null && !file.isEmpty()) {
	    String fileRealName = file.getOriginalFilename();
	    long size = file.getSize();
	    log.info("제목: {}", title);
	    log.info("내용: {}", content);
	    log.info("파일명: {}", fileRealName);
	    log.info("파일 크기(byte): {}", size);
	    
	    // 로컬시스템에 저장할 파일 이름 생성
	    String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
	    String uploadFolder = "D:\\Leeangie\\spring_pro03\\pro04_lego\\src\\main\\webapp\\upload"; // 로컬 시스템의 업로드 폴더 경로
	
	    File uploadDir = new File(uploadFolder);
	    if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        UUID uuid = UUID.randomUUID();
        String uniqueName = uuid.toString().split("-")[0];
        String uuidName = uploadFolder + "\\" + uniqueName + fileExtension;
        
        // 파일 저장
        File saveFile = new File(uuidName);
        try {
            file.transferTo(saveFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        
        board.setUrl(uuidName); // 파일 경로를 URL에 설정
        model.addAttribute("fileRealName", fileRealName);
        model.addAttribute("size", size);
    } else {
        board.setUrl(""); // 파일이 없을 경우 빈 문자열로 설정
    }
    
    /* 서비스 호출 영역 시작 */
    boardService.addBoard(board);
    /* 서비스 호출 영역 끝 */
	
		return "redirect:boardList.do";
	}


     
    
    @GetMapping("/editBoard.do")
    public String editForm(@RequestParam("bno") int bno, Model model) {
        Board board = boardService.getOneBoard(bno);
        model.addAttribute("board", board);
        return "board/boardFormEdit";
    }
    
    @PostMapping("/upBoard.do")
    public String update(@RequestParam("bno") int bno, @ModelAttribute Board board) {
        board.setBno(bno);
        boardService.upBoard(board);
        return "redirect:boardList.do";
    }
    
    @GetMapping("/delBoard.do")
    public String delete(@RequestParam("bno") int bno) {
        boardService.delBoard(bno);
        return "redirect:boardList.do";
    }
}







