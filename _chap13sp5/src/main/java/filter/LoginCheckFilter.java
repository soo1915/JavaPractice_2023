package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.util.PatternMatchUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Integer.MIN_VALUE)
public class LoginCheckFilter implements Filter {

    private static final String[] whitelist = {"/", "/order", "/login", "/logout", "/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try {
            log.info("인층 체크 필터 시작{}", requestURI);
            if (isLoginCheckPath(requestURI)) {
                log.info("인증 체크 로직 실행 {}", requestURI);
                HttpSession session = httpRequest.getSession(false);
                if (session == null || session.getAttribute("authInfo") == null) {
                    log.info("미인증 사용자 요청 {}", requestURI);
                    //로그인으로 리다이렉트
//                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login?redirectURL=" + requestURI);
//                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/main");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
                    dispatcher.forward(httpRequest, httpResponse);
                    return;
                }
            }
            chain.doFilter(request, response);

        } catch (Exception e) {
            throw e;
        } finally {
            log.info("인증 체크 필터 종료 {}", requestURI);
        }
    }

    /**
     * whiteList의 경우 인증 체크를 안하도록 한다.
     */
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }

}