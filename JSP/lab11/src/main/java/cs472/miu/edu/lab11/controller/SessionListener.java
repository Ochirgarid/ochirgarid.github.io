package cs472.miu.edu.lab11.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.Instant;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(Instant.now() + ": Session " + e.getSession().getId() + " created.");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println(Instant.now() + ": Session " + e.getSession().getId() + " destroyed.");
    }
}