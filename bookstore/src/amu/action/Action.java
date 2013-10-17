package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;

public interface Action {
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
