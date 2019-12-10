package net.plang.DYAccountVer3.base.controller;
/*package net.plang.DYAccountVer3.base.controller;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.sf.jasperreports.engine.JasperExportManager;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmailController extends AbstractController{

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		System.out.println("email 컨트롤러시작");
		// TODO Auto-generated method stub
		try {
			1차때 해봤기때문에 귀찮아서 안함
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\Account\\DYAccount\\WebContent\\resources\\reportform\\report11.pdf");
			
			String slipNo=request.getParameter("slipNo");
			String email=request.getParameter("email");
			String emailOption=request.getParameter("emailOption");
			System.out.println(slipNo);
			System.out.println(email);
			System.out.println(emailOption);
			
		String host = null; 
		final String username = "zaqwwsx";  
		final String password = "tmvlzj89"; 
		String pdfBaseUrl = "C:\\Account\\DYAccount\\WebContent\\resources\\reportform\\report11.pdf";
		
		int port=0; 
		
		if(emailOption.equals("naver.com")) { 
			port=465;
			host = "smtp.naver.com";
		}
		else if(emailOption.equals("gmail.com")) {
			port=587;
			host = "smtp.gmail.com";
			//구글 포트번호 보안때문에 해결 안됨.
		}
		
		String recipient = email+"@"+emailOption; // 받는 사람의 이메일
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+email+"@"+emailOption);
		String subject = "전표번호 : " +slipNo + "의 상세내용입니다"; // 이메일 제목
		String body = "확인 후 회신바랍니다"; // 이메일 내용

		Properties props = System.getProperties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("zaqwwsx@naver.com","DYAccount"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		msg.setSubject(subject);

		// 파일첨부를 위한 Multipart
		Multipart multipart = new MimeMultipart();

		// BodyPart를 생성
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(body);

		// Multipart에 BodyPart를 붙인다.
		multipart.addBodyPart(bodyPart);

		// 이미지를 첨부한다.
		bodyPart = new MimeBodyPart();
		String filename = pdfBaseUrl;

		// 첨부할 파일 경로
		FileDataSource source = new FileDataSource(filename);
		bodyPart.setDataHandler(new DataHandler(source));
		multipart.addBodyPart(bodyPart);
		   

		bodyPart.setFileName(slipNo + ".pdf");
		// 첨부할 파일의 이름을 바꿔서 보낼수 있음

		bodyPart.setHeader("Content-ID", "image_id");

		// 이메일 메시지의 내용에 Multipart를 붙인다.
		msg.setContent(multipart);
		Transport.send(msg);
		}catch(Exception e) {
			System.out.println("PDF발송 중 에러  : "+e.getMessage());
		}
		return null;
	}
}*/