package pl.dernovyi.homework6mailsendler.controller;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import pl.dernovyi.homework6mailsendler.EmailCfg;
import pl.dernovyi.homework6mailsendler.service.FilmService;




@Aspect
@Component
public class FilmAspectSender {

   private final EmailCfg emailCfg;
   private final FilmService filmService;
    @Autowired
    public FilmAspectSender(EmailCfg emailCfg, FilmService filmService) {
        this.emailCfg = emailCfg;
        this.filmService = filmService;
    }

    @After("@annotation(pl.dernovyi.homework6mailsendler.annotation.MyAspect)")
    private void afterPostFilmsSand(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(this.emailCfg.getHost());
        javaMailSender.setPort(this.emailCfg.getPort());
        javaMailSender.setUsername(this.emailCfg.getUsername());
        javaMailSender.setPassword(this.emailCfg.getPassword());

        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setFrom("avtomatic@massage.com");
        simpleMailMessage.setTo("user@gmail.com");
        simpleMailMessage.setText("We have some new film for You : This is - "+  filmService.getLastAdded().getName() +
                ". producer: " +  filmService.getLastAdded().getProducer()+
                ". year: " + filmService.getLastAdded().getYear());

        javaMailSender.send(simpleMailMessage);

    }

}
